package com.kekecreations.configurable_falls.mixin;

import com.kekecreations.configurable_falls.config.ConfigurableFallsCommonConfigs;
import net.minecraft.block.HayBlock;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HayBlock.class)
public class ConfigurableFallsHayBlockMixin {

    @Inject(method = "fallOn", at = @At("HEAD"), cancellable = true)
    public void fallOn(World p_180658_1_, BlockPos p_180658_2_, Entity p_180658_3_, float p_180658_4_, CallbackInfo ci) {
        p_180658_3_.causeFallDamage(p_180658_4_, ConfigurableFallsCommonConfigs.HAY_BALE_FALL_DAMAGE_PERCENTAGE.get().floatValue());
    }
}
