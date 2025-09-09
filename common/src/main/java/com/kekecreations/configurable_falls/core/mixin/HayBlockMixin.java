package com.kekecreations.configurable_falls.core.mixin;

import com.kekecreations.configurable_falls.core.config.ConfigurableFallsCommonConfig;
import net.minecraft.world.level.block.HayBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(HayBlock.class)
public class HayBlockMixin {

    @ModifyArg(method = "fallOn", at = @At(value = "INVOKE", target = "net/minecraft/world/entity/Entity.causeFallDamage (FFLnet/minecraft/world/damagesource/DamageSource;)Z"), index = 1)
    private float configurable_falls_modifyFloatValue(float $$0) {
        return ConfigurableFallsCommonConfig.HAY_BALE_FALL_DAMAGE_PERCENTAGE.get().floatValue();
    }
}
