package com.kekecreations.break_my_fall.core.mixin;

import com.kekecreations.break_my_fall.core.config.BreakMyFallCommonConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {


    @Shadow
    protected int calculateFallDamage(float fallDistance, float damageMultiplier) {
        return 0;
    }

    @Inject(method = "causeFallDamage", at = @At(value = "HEAD"), cancellable = true)
    public void break_my_fall$causeFallDamage(float fallDistance, float multiplier, DamageSource source, CallbackInfoReturnable<Boolean> ci) {
        LivingEntity $this = (LivingEntity) (Object) this;
        if (!BreakMyFallCommonConfig.CAN_FALL_DAMAGE_KILL_THE_PLAYER.get()) {
            if ($this instanceof Player player) {
                if (calculateFallDamage(fallDistance, multiplier) >= player.getHealth()) {
                    player.setHealth((BreakMyFallCommonConfig.PLAYER_HEALTH_AFTER_LETHAL_FALL.get().floatValue()));

                    int i = Mth.floor($this.getX());
                    int j = Mth.floor($this.getY() - (double)0.2F);
                    int k = Mth.floor($this.getZ());
                    BlockState blockstate = $this.level().getBlockState(new BlockPos(i, j, k));
                    if (!blockstate.isAir()) {
                        SoundType soundtype = blockstate.getSoundType();
                        $this.playSound(soundtype.getFallSound(), soundtype.getVolume() * 0.5F, soundtype.getPitch() * 0.75F);
                    }
                    ci.setReturnValue(false);
                }
            }
        }
    }
}
