package com.kekecreations.configurable_falls.mixin;

import com.kekecreations.configurable_falls.config.ConfigurableFallsCommonConfigs;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
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

    @Inject(method = "fallOn", at = @At("HEAD"), cancellable = true)
    public void fallOn(Level p_153362_, BlockState p_153363_, BlockPos p_153364_, Entity p_153365_, float p_153366_, CallbackInfo ci) {
        p_153365_.causeFallDamage(p_153366_, ConfigurableFallsCommonConfigs.HAY_BALE_FALL_DAMAGE_PERCENTAGE.get().floatValue(), DamageSource.FALL);
    }
}
