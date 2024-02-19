package com.kekecreations.configurable_falls.mixin;

import com.kekecreations.configurable_falls.config.ConfigurableFallsCommonConfigs;
import com.kekecreations.configurable_falls.util.ConfigurableFallsTags;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ITag;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;



@Mixin(Entity.class)
public abstract class ConfigurableFallsEntityMixin implements IForgeEntity {


    @Shadow public final double getX() {
        return 0D;
    }
    @Shadow public final double getY() {
        return 0D;
    }
    @Shadow public final double getZ() {
        return 0D;
    }
    @Shadow public boolean causeFallDamage(float p_225503_1_, float p_225503_2_) {
        return false;
    }
    @Shadow public float fallDistance;
    @Shadow public World level;

    @Inject(method = "updateInWaterStateAndDoWaterCurrentPushing", at = @At(value = "INVOKE", target = "net/minecraft/entity/Entity.doWaterSplashEffect ()V"))
    public void updateInWaterStateAndDoWaterCurrentPushing(CallbackInfo ci) {
        BlockPos blockPos = new BlockPos(this.getX(), this.getY(), this.getZ());

        int waterDepth = 1;
        while (this.level.getFluidState(new BlockPos(blockPos.getX(), blockPos.getY() - waterDepth, blockPos.getZ())).is(ConfigurableFallsTags.WATER)) {
            waterDepth++;
        }
        try {
            if (this.level.getFluidState(new BlockPos(blockPos.getX(), blockPos.getY(), blockPos.getZ())).is(ConfigurableFallsTags.WATER)) {
                if (this.fallDistance >= ConfigurableFallsCommonConfigs.WATER_FALL_DAMAGE_FALL_DISTANCE.get()) {
                    if (waterDepth == 1) {
                        this.causeFallDamage(this.fallDistance + (waterDepth), ConfigurableFallsCommonConfigs.WATER_DEPTH_1_FALL_DAMAGE_PERCENTAGE.get().floatValue());
                    }
                    if (waterDepth == 2) {
                        this.causeFallDamage(this.fallDistance + (waterDepth), ConfigurableFallsCommonConfigs.WATER_DEPTH_2_FALL_DAMAGE_PERCENTAGE.get().floatValue());
                    }
                    if (waterDepth == 3) {
                        this.causeFallDamage(this.fallDistance + (waterDepth), ConfigurableFallsCommonConfigs.WATER_DEPTH_3_FALL_DAMAGE_PERCENTAGE.get().floatValue());
                    }
                    if (waterDepth == 4) {
                        this.causeFallDamage(this.fallDistance + (waterDepth), ConfigurableFallsCommonConfigs.WATER_DEPTH_4_FALL_DAMAGE_PERCENTAGE.get().floatValue());
                    }
                    if (waterDepth >= 5) {
                        this.causeFallDamage(this.fallDistance + (waterDepth), ConfigurableFallsCommonConfigs.WATER_DEPTH_5_FALL_DAMAGE_PERCENTAGE.get().floatValue());
                    }
                }
            }
        } catch (Exception e) {
            //System.out.println(e);
        }
    }
}