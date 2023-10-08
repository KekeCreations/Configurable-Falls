package com.kekecreations.configurable_falls.mixin;

import com.kekecreations.configurable_falls.config.ConfigurableFallsCommonConfigs;
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
public abstract class EntityMixin implements IForgeEntity {

    @Shadow
    public Entity getVehicle() {
        return null;
    }
    @Shadow
    public boolean updateFluidHeightAndDoFluidPushing(ITag<Fluid> p_210500_1_, double p_210500_2_) {
        return false;
    }
    @Shadow protected void doWaterSplashEffect() {}
    @Shadow protected boolean wasTouchingWater;
    @Shadow protected boolean firstTick = true;

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

    @Shadow public void clearFire() {}

    @Shadow public abstract boolean hurt(DamageSource p_70097_1_, float p_70097_2_);

    @Inject(method = "updateInWaterStateAndDoWaterCurrentPushing", at = @At("HEAD"), cancellable = true)
    public void updateInWaterStateAndDoWaterCurrentPushing(CallbackInfo ci) {

        if (this.getVehicle() instanceof BoatEntity) {
            this.wasTouchingWater = false;
        }else if (this.updateFluidHeightAndDoFluidPushing(FluidTags.WATER, 0.014D)) {
            if (!this.wasTouchingWater && !this.firstTick) {
                this.doWaterSplashEffect();


                BlockPos blockPos = new BlockPos(this.getX(), this.getY(), this.getZ());

                int waterDepth = 1;
                while (this.level.getFluidState(new BlockPos(blockPos.getX(), blockPos.getY() - waterDepth, blockPos.getZ())).is(FluidTags.WATER)) {
                    waterDepth++;
                }
                try {
                    if (this.level.getFluidState(new BlockPos(blockPos.getX(), blockPos.getY(), blockPos.getZ())).is(FluidTags.WATER)) {
                      if (this.fallDistance >= ConfigurableFallsCommonConfigs.WATER_FALL_DAMAGE_FALL_DISTANCE.get()) {
                          if (waterDepth == 1) {
                            this.causeFallDamage(this.fallDistance, ConfigurableFallsCommonConfigs.WATER_DEPTH_1_FALL_DAMAGE_PERCENTAGE.get().floatValue());
                          }
                          if (waterDepth == 2) {
                            this.causeFallDamage(this.fallDistance + (waterDepth - 1), ConfigurableFallsCommonConfigs.WATER_DEPTH_2_FALL_DAMAGE_PERCENTAGE.get().floatValue());
                          }
                          if (waterDepth == 3) {
                            this.causeFallDamage(this.fallDistance + (waterDepth - 1), ConfigurableFallsCommonConfigs.WATER_DEPTH_3_FALL_DAMAGE_PERCENTAGE.get().floatValue());
                          }
                          if (waterDepth == 4) {
                            this.causeFallDamage(this.fallDistance + (waterDepth - 1), ConfigurableFallsCommonConfigs.WATER_DEPTH_4_FALL_DAMAGE_PERCENTAGE.get().floatValue());
                          }
                          if (waterDepth >= 5) {
                            this.causeFallDamage(this.fallDistance + (waterDepth - 1), ConfigurableFallsCommonConfigs.WATER_DEPTH_5_FALL_DAMAGE_PERCENTAGE.get().floatValue());
                          }
                       }
                    }
                }
                catch (Exception e) {
                    System.out.println(e);
                }
                this.fallDistance = 0.0F;
            }

            this.fallDistance = 0.0F;
            this.wasTouchingWater = true;
            this.clearFire();
        } else {
            this.wasTouchingWater = false;
        }
        ci.cancel();
    }
}