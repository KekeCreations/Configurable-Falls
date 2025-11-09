package com.kekecreations.break_my_fall.core.mixin;

import com.kekecreations.break_my_fall.common.tag.ConfigurableFallsTags;
import com.kekecreations.break_my_fall.core.config.BreakMyFallCommonConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(Entity.class)
public abstract class EntityMixin {


    @Shadow
    public abstract DamageSources damageSources();
    @Shadow
    public float fallDistance;
    @Shadow
    public Level level() {
        return null;
    }

    @Deprecated
    @Shadow
    public BlockPos getOnPosLegacy() {
        return this.getOnPos(0.2F);
    }

    @Shadow
    protected BlockPos getOnPos(float p_216987_) {
        return null;
    }

    @Shadow
    public abstract boolean causeFallDamage(float p_146828_, float p_146829_, DamageSource p_146830_);

    @Shadow
    public abstract int getBlockX();

    @Shadow
    public abstract int getBlockY();

    @Shadow
    public abstract int getBlockZ();



    @ModifyArg(method = "move(Lnet/minecraft/world/entity/MoverType;Lnet/minecraft/world/phys/Vec3;)V", at = @At(value = "INVOKE", target = "net/minecraft/world/level/ClipContext.<init> (Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/phys/Vec3;Lnet/minecraft/world/level/ClipContext$Block;Lnet/minecraft/world/level/ClipContext$Fluid;Lnet/minecraft/world/entity/Entity;)V"), index = 3)
    private ClipContext.Fluid configurable_falls$modifyClipContext(ClipContext.Fluid p_45691_) {
        return ClipContext.Fluid.NONE;
    }




    @Inject(method = "updateInWaterStateAndDoWaterCurrentPushing", at = @At(value = "INVOKE", target = "net/minecraft/world/entity/Entity.doWaterSplashEffect ()V"))
    public void configurable_falls$updateInWaterStateAndDoWaterCurrentPushing(CallbackInfo ci) {
        BlockPos blockPos = new BlockPos(this.getBlockX(), this.getBlockY(), this.getBlockZ());

        int waterDepth = 1;
        while (this.level().getFluidState(new BlockPos(blockPos.getX(), blockPos.getY() - waterDepth, blockPos.getZ())).is(ConfigurableFallsTags.FluidTags.WATER)) {
            waterDepth++;
        }
        try {
            if (this.level().getFluidState(new BlockPos(blockPos.getX(), blockPos.getY(), blockPos.getZ())).is(ConfigurableFallsTags.FluidTags.WATER)) {
                if (this.fallDistance >= BreakMyFallCommonConfig.WATER_FALL_DAMAGE_FALL_DISTANCE.get()) {
                    if (waterDepth == 1) {
                        this.causeFallDamage(this.fallDistance + (waterDepth), BreakMyFallCommonConfig.WATER_DEPTH_1_FALL_DAMAGE_PERCENTAGE.get().floatValue(), this.damageSources().fall());
                    }
                    if (waterDepth == 2) {
                        this.causeFallDamage(this.fallDistance + (waterDepth), BreakMyFallCommonConfig.WATER_DEPTH_2_FALL_DAMAGE_PERCENTAGE.get().floatValue(), this.damageSources().fall());
                    }
                    if (waterDepth == 3) {
                        this.causeFallDamage(this.fallDistance + (waterDepth), BreakMyFallCommonConfig.WATER_DEPTH_3_FALL_DAMAGE_PERCENTAGE.get().floatValue(), this.damageSources().fall());
                    }
                    if (waterDepth == 4) {
                        this.causeFallDamage(this.fallDistance + (waterDepth), BreakMyFallCommonConfig.WATER_DEPTH_4_FALL_DAMAGE_PERCENTAGE.get().floatValue(), this.damageSources().fall());
                    }
                    if (waterDepth >= 5) {
                        this.causeFallDamage(this.fallDistance + (waterDepth), BreakMyFallCommonConfig.WATER_DEPTH_5_FALL_DAMAGE_PERCENTAGE.get().floatValue(), this.damageSources().fall());
                    }
                }
            }
        } catch (Exception e) {
            //System.out.println(e);
        }
    }
}
