package com.kekecreations.break_my_fall.core.mixin;

import com.kekecreations.break_my_fall.common.tag.BreakMyFallTags;
import com.kekecreations.break_my_fall.core.config.BreakMyFallCommonConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
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
    private ClipContext.Fluid break_my_fall$modifyClipContext(ClipContext.Fluid p_45691_) {
        return ClipContext.Fluid.NONE;
    }




    @Inject(method = "updateInWaterStateAndDoWaterCurrentPushing", at = @At(value = "INVOKE", target = "net/minecraft/world/entity/Entity.doWaterSplashEffect ()V"))
    public void break_my_fall$updateInWaterStateAndDoWaterCurrentPushing(CallbackInfo ci) {
        Entity entity = (Entity) (Object) this;
        if (entity instanceof LivingEntity livingEntity) {
            BlockPos blockPos = new BlockPos(this.getBlockX(), this.getBlockY(), this.getBlockZ());

            int waterDepth = 1;
            while (this.level().getFluidState(new BlockPos(blockPos.getX(), blockPos.getY() - waterDepth, blockPos.getZ())).is(BreakMyFallTags.FluidTags.WATER)) {
                waterDepth++;
            }
            try {
                if (this.level().getFluidState(new BlockPos(blockPos.getX(), blockPos.getY(), blockPos.getZ())).is(BreakMyFallTags.FluidTags.WATER)) {
                    double fallPower = fallDistance + 1.0E-6 - livingEntity.getAttributeValue(Attributes.SAFE_FALL_DISTANCE);
                    int fallDamage = Mth.floor(fallPower * 1 * livingEntity.getAttributeValue(Attributes.FALL_DAMAGE_MULTIPLIER));

                    if (this.fallDistance >= BreakMyFallCommonConfig.WATER_FALL_DAMAGE_FALL_DISTANCE.get()) {
                        switch (waterDepth) {
                            case 1 -> {
                                if (!BreakMyFallCommonConfig.CAN_FALL_DAMAGE_KILL_THE_PLAYER.get()) {
                                    if (livingEntity instanceof Player player) {
                                        if (fallDamage >= player.getHealth()) {
                                            player.setHealth(BreakMyFallCommonConfig.PLAYER_HEALTH_AFTER_LETHAL_FALL.get().floatValue());
                                        } else {
                                            dealWaterFallDamage(waterDepth, BreakMyFallCommonConfig.WATER_DEPTH_1_FALL_DAMAGE_PERCENTAGE.get().floatValue());
                                        }
                                    } else {
                                        dealWaterFallDamage(waterDepth, BreakMyFallCommonConfig.WATER_DEPTH_1_FALL_DAMAGE_PERCENTAGE.get().floatValue());
                                    }
                                } else {
                                    dealWaterFallDamage(waterDepth, BreakMyFallCommonConfig.WATER_DEPTH_1_FALL_DAMAGE_PERCENTAGE.get().floatValue());
                                }
                            }
                            case 2 -> {
                                if (BreakMyFallCommonConfig.CAN_FALL_DAMAGE_KILL_THE_PLAYER.get()) {
                                    if (livingEntity instanceof Player player) {
                                        if (fallDamage >= player.getHealth()) {
                                            player.setHealth(BreakMyFallCommonConfig.PLAYER_HEALTH_AFTER_LETHAL_FALL.get().floatValue());
                                        } else {
                                            dealWaterFallDamage(waterDepth, BreakMyFallCommonConfig.WATER_DEPTH_2_FALL_DAMAGE_PERCENTAGE.get().floatValue());
                                        }
                                    } else {
                                        dealWaterFallDamage(waterDepth, BreakMyFallCommonConfig.WATER_DEPTH_2_FALL_DAMAGE_PERCENTAGE.get().floatValue());
                                    }
                                } else {
                                    dealWaterFallDamage(waterDepth, BreakMyFallCommonConfig.WATER_DEPTH_2_FALL_DAMAGE_PERCENTAGE.get().floatValue());
                                }
                            }
                            case 3 -> {
                                if (BreakMyFallCommonConfig.CAN_FALL_DAMAGE_KILL_THE_PLAYER.get()) {
                                    if (livingEntity instanceof Player player) {
                                        if (fallDamage >= player.getHealth()) {
                                            player.setHealth(BreakMyFallCommonConfig.PLAYER_HEALTH_AFTER_LETHAL_FALL.get().floatValue());
                                        } else {
                                            dealWaterFallDamage(waterDepth, BreakMyFallCommonConfig.WATER_DEPTH_3_FALL_DAMAGE_PERCENTAGE.get().floatValue());
                                        }
                                    } else {
                                        dealWaterFallDamage(waterDepth, BreakMyFallCommonConfig.WATER_DEPTH_3_FALL_DAMAGE_PERCENTAGE.get().floatValue());
                                    }
                                } else {
                                    dealWaterFallDamage(waterDepth, BreakMyFallCommonConfig.WATER_DEPTH_3_FALL_DAMAGE_PERCENTAGE.get().floatValue());
                                }
                            }
                            case 4 -> {
                                if (BreakMyFallCommonConfig.CAN_FALL_DAMAGE_KILL_THE_PLAYER.get()) {
                                    if (livingEntity instanceof Player player) {
                                        if (fallDamage >= player.getHealth()) {
                                            player.setHealth(BreakMyFallCommonConfig.PLAYER_HEALTH_AFTER_LETHAL_FALL.get().floatValue());
                                        } else {
                                            dealWaterFallDamage(waterDepth, BreakMyFallCommonConfig.WATER_DEPTH_4_FALL_DAMAGE_PERCENTAGE.get().floatValue());
                                        }
                                    } else {
                                        dealWaterFallDamage(waterDepth, BreakMyFallCommonConfig.WATER_DEPTH_4_FALL_DAMAGE_PERCENTAGE.get().floatValue());
                                    }
                                } else {
                                    dealWaterFallDamage(waterDepth, BreakMyFallCommonConfig.WATER_DEPTH_4_FALL_DAMAGE_PERCENTAGE.get().floatValue());
                                }
                            }
                        }
                        if (waterDepth == 5) {
                            if (BreakMyFallCommonConfig.CAN_FALL_DAMAGE_KILL_THE_PLAYER.get()) {
                                if (livingEntity instanceof Player player) {
                                    if (fallDamage >= player.getHealth()) {
                                        player.setHealth(BreakMyFallCommonConfig.PLAYER_HEALTH_AFTER_LETHAL_FALL.get().floatValue());
                                    } else {
                                        dealWaterFallDamage(waterDepth, BreakMyFallCommonConfig.WATER_DEPTH_5_FALL_DAMAGE_PERCENTAGE.get().floatValue());
                                    }
                                } else {
                                    dealWaterFallDamage(waterDepth, BreakMyFallCommonConfig.WATER_DEPTH_5_FALL_DAMAGE_PERCENTAGE.get().floatValue());
                                }
                            } else {
                                dealWaterFallDamage(waterDepth, BreakMyFallCommonConfig.WATER_DEPTH_5_FALL_DAMAGE_PERCENTAGE.get().floatValue());
                            }
                        }
                    }
                }
            } catch (Exception e) {
                //System.out.println(e);
            }
        }
    }

    public void dealWaterFallDamage(int waterDepth, float damagePercentage) {
        this.causeFallDamage(this.fallDistance + (waterDepth), damagePercentage, this.damageSources().fall());
    }
}
