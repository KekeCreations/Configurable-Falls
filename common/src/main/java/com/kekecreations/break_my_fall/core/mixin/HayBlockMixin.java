package com.kekecreations.break_my_fall.core.mixin;

import com.kekecreations.break_my_fall.core.config.BreakMyFallCommonConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.HayBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HayBlock.class)
public class HayBlockMixin {


    @Inject(method= "fallOn", at = @At(value = "HEAD"), cancellable = true)
    private void break_my_fall$fallOn(Level level, BlockState state, BlockPos pos, Entity entity, double fallDistance, CallbackInfo callbackInfo) {
        if (BreakMyFallCommonConfig.HAY_BALE_FALL_DAMAGE_PERCENTAGE.get() != BreakMyFallCommonConfig.HAY_BALE_FALL_DAMAGE_PERCENTAGE.getDefault()) {
            entity.causeFallDamage(fallDistance, BreakMyFallCommonConfig.HAY_BALE_FALL_DAMAGE_PERCENTAGE.get().floatValue(), level.damageSources().fall());
            callbackInfo.cancel();
        }
    }
}
