package com.kekecreations.configurable_falls.mixin;

import com.google.common.collect.ImmutableList;
import com.kekecreations.configurable_falls.config.ConfigurableFallsCommonConfigs;
import com.kekecreations.configurable_falls.util.ConfigurableFallsTags;
import net.minecraft.CrashReport;
import net.minecraft.CrashReportCategory;
import net.minecraft.ReportedException;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Mth;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.extensions.IForgeEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.annotation.Nullable;


@Mixin(Entity.class)
public abstract class EntityMixin implements IForgeEntity {

    @Shadow private Vec3 position;
    @Shadow public boolean noPhysics;

    @Shadow public boolean wasOnFire;
    @Shadow public boolean horizontalCollision;
    @Shadow public boolean verticalCollision;
    @Shadow public boolean verticalCollisionBelow;
    @Shadow public boolean minorHorizontalCollision;
    @Shadow protected boolean onGround;
    @Shadow public float walkDist;
    @Shadow public float moveDist;
    @Shadow public float flyDist;
    @Shadow public float fallDistance;
    @Shadow private float nextStep = 1.0F;
    @Shadow public Level level;

    @Shadow protected Vec3 stuckSpeedMultiplier = Vec3.ZERO;
    @Shadow private Vec3 deltaMovement = Vec3.ZERO;

    @Shadow private ImmutableList<Entity> passengers = ImmutableList.of();

    @Shadow protected int getFireImmuneTicks() {
        return 1;
    }
    @Shadow public boolean isInPowderSnow;

    @Shadow private static final AABB INITIAL_AABB = new AABB(0.0D, 0.0D, 0.0D, 0.0D, 0.0D, 0.0D);

    @Shadow private AABB bb = INITIAL_AABB;

    @Shadow private int remainingFireTicks = -this.getFireImmuneTicks();

    @Shadow
    public void setPos(double p_20210_, double p_20211_, double p_20212_) {
    }
    @Shadow
    public boolean isOnFire() {
        return false;
    }
    @Shadow public Vec3 position() {
        return this.position;
    }
    @Shadow
    public void setDeltaMovement(Vec3 p_20257_) {
        this.deltaMovement = p_20257_;
    }
    @Shadow
    public void setDeltaMovement(double p_20335_, double p_20336_, double p_20337_) {
        this.setDeltaMovement(new Vec3(p_20335_, p_20336_, p_20337_));
    }
    @Shadow public Vec3 getDeltaMovement() {
        return this.deltaMovement;
    }

    @Shadow
    protected Vec3 limitPistonMovement(Vec3 p_20134_) {
        return Vec3.ZERO;
    }
    @Shadow protected Vec3 maybeBackOffFromEdge(Vec3 p_20019_, MoverType p_20020_) {
        return p_20019_;
    }
    @Shadow private Vec3 collide(Vec3 p_20273_) {
        return p_20273_;
    }
    @Shadow public void resetFallDistance() {
    }

    @Shadow protected boolean isHorizontalCollisionMinor(Vec3 p_196625_) {
        return false;
    }
    @Shadow public BlockPos getOnPosLegacy() {
        return this.blockPosition;
    }
    @Shadow protected void checkFallDamage(double p_19911_, boolean p_19912_, BlockState p_19913_, BlockPos p_19914_) {
    }
    @Shadow public final boolean isRemoved() {
        return false;
    }
    @Shadow protected Entity.MovementEmission getMovementEmission() {
        return Entity.MovementEmission.ALL;
    }

    @Shadow public boolean isPassenger() {
        return this.getVehicle() != null;
    }
    @Shadow public void setOnGround(boolean p_20181_) {
        this.onGround = p_20181_;
    }
    @Shadow  public BlockPos getOnPos() {
        return this.blockPosition;
    }
    @Shadow protected float nextStep() {
        return (float)((int)this.moveDist + 1);
    }
    @Shadow public boolean isInWater() {
        return this.wasTouchingWater;
    }
    @Shadow public boolean isVehicle() {
        return !this.passengers.isEmpty();
    }
    @Shadow @Nullable
    public Entity getControllingPassenger() {
        return null;
    }
    @Shadow protected void playSwimSound(float p_20213_) {
    }
    @Shadow  public void gameEvent(GameEvent p_146851_) {
    }
    @Shadow protected void playStepSound(BlockPos p_20135_, BlockState p_20136_) {
    }

    @Shadow private void playAmethystStepSound(BlockState p_146883_) {
    }
    @Shadow protected void processFlappingMovement() {
    }

    @Shadow public BlockState getBlockStateOn() {
        return this.level.getBlockState(this.getOnPos());
    }
    @Shadow  protected void tryCheckInsideBlocks() {
    }
    @Shadow protected float getBlockSpeedFactor() {
        return 1F;
    }
    @Shadow public final AABB getBoundingBox() {
        return this.bb;
    }
    @Shadow public void setRemainingFireTicks(int p_20269_) {
        this.remainingFireTicks = p_20269_;
    }
    @Shadow public boolean isInWaterRainOrBubble() {
        return false;
    }
    @Shadow protected void playEntityOnFireExtinguishedSound() {
    }


    @Inject(method = "move", at = @At("HEAD"), cancellable = true)
    public void move(MoverType p_19973_, Vec3 p_19974_, CallbackInfo ci) {
        if (this.noPhysics) {
            this.setPos(this.getX() + p_19974_.x, this.getY() + p_19974_.y, this.getZ() + p_19974_.z);
        } else {
            this.wasOnFire = this.isOnFire();
            if (p_19973_ == MoverType.PISTON) {
                p_19974_ = this.limitPistonMovement(p_19974_);
                if (p_19974_.equals(Vec3.ZERO)) {
                    return;
                }
            }

            this.level.getProfiler().push("move");
            if (this.stuckSpeedMultiplier.lengthSqr() > 1.0E-7D) {
                p_19974_ = p_19974_.multiply(this.stuckSpeedMultiplier);
                this.stuckSpeedMultiplier = Vec3.ZERO;
                this.setDeltaMovement(Vec3.ZERO);
            }

            p_19974_ = this.maybeBackOffFromEdge(p_19974_, p_19973_);
            Vec3 vec3 = this.collide(p_19974_);
            double d0 = vec3.lengthSqr();
            if (d0 > 1.0E-7D) {
                if (this.fallDistance != 0.0F && d0 >= 1.0D) {
                    BlockHitResult blockhitresult = this.level.clip(new ClipContext(this.position(), this.position().add(vec3), ClipContext.Block.FALLDAMAGE_RESETTING, ClipContext.Fluid.NONE, Entity.class.cast(this)));
                    if (blockhitresult.getType() != HitResult.Type.MISS) {
                        this.resetFallDistance();
                    }
                }

                this.setPos(this.getX() + vec3.x, this.getY() + vec3.y, this.getZ() + vec3.z);
            }

            this.level.getProfiler().pop();
            this.level.getProfiler().push("rest");
            boolean flag2 = !Mth.equal(p_19974_.x, vec3.x);
            boolean flag = !Mth.equal(p_19974_.z, vec3.z);
            this.horizontalCollision = flag2 || flag;
            this.verticalCollision = p_19974_.y != vec3.y;
            this.verticalCollisionBelow = this.verticalCollision && p_19974_.y < 0.0D;
            if (this.horizontalCollision) {
                this.minorHorizontalCollision = this.isHorizontalCollisionMinor(vec3);
            } else {
                this.minorHorizontalCollision = false;
            }

            this.onGround = this.verticalCollision && p_19974_.y < 0.0D;
            BlockPos blockpos = this.getOnPosLegacy();
            BlockState blockstate = this.level.getBlockState(blockpos);
            this.checkFallDamage(vec3.y, this.onGround, blockstate, blockpos);
            if (this.isRemoved()) {
                this.level.getProfiler().pop();
            } else {
                if (this.horizontalCollision) {
                    Vec3 vec31 = this.getDeltaMovement();
                    this.setDeltaMovement(flag2 ? 0.0D : vec31.x, vec31.y, flag ? 0.0D : vec31.z);
                }

                Block block = blockstate.getBlock();
                if (p_19974_.y != vec3.y) {
                    block.updateEntityAfterFallOn(this.level, Entity.class.cast(this));
                }

                if (this.onGround) {
                    block.stepOn(this.level, blockpos, blockstate, Entity.class.cast(this));
                }

                Entity.MovementEmission entity$movementemission = this.getMovementEmission();
                if (entity$movementemission.emitsAnything() && !this.isPassenger()) {
                    double d1 = vec3.x;
                    double d2 = vec3.y;
                    double d3 = vec3.z;
                    this.flyDist = (float) ((double) this.flyDist + vec3.length() * 0.6D);
                    boolean flag1 = blockstate.is(BlockTags.CLIMBABLE) || blockstate.is(Blocks.POWDER_SNOW);
                    if (!flag1) {
                        d2 = 0.0D;
                    }

                    this.walkDist += (float)vec3.horizontalDistance() * 0.6F;
                    this.moveDist += (float)Math.sqrt(d1 * d1 + d2 * d2 + d3 * d3) * 0.6F;
                    if (this.moveDist > this.nextStep && !blockstate.isAir()) {
                        this.nextStep = this.nextStep();
                        if (this.isInWater()) {
                            if (entity$movementemission.emitsSounds()) {
                                Entity entity = this.isVehicle() && this.getControllingPassenger() != null ? this.getControllingPassenger() : Entity.class.cast(this);
                                float f = entity == Entity.class.cast(this) ? 0.35F : 0.4F;
                                Vec3 vec32 = entity.getDeltaMovement();
                                float f1 = Math.min(1.0F, (float)Math.sqrt(vec32.x * vec32.x * (double)0.2F + vec32.y * vec32.y + vec32.z * vec32.z * (double)0.2F) * f);
                                this.playSwimSound(f1);
                            }

                            if (entity$movementemission.emitsEvents()) {
                                this.gameEvent(GameEvent.SWIM);
                            }
                        } else {
                            if (entity$movementemission.emitsSounds()) {
                                this.playAmethystStepSound(blockstate);
                                this.playStepSound(blockpos, blockstate);
                            }

                            if (entity$movementemission.emitsEvents() && (this.onGround || p_19974_.y == 0.0D || this.isInPowderSnow || flag1)) {
                                this.level.gameEvent(GameEvent.STEP, this.position, GameEvent.Context.of(Entity.class.cast(this), this.getBlockStateOn()));
                            }
                        }
                    } else if (blockstate.isAir()) {
                        this.processFlappingMovement();
                    }
                }

                this.tryCheckInsideBlocks();
                float f2 = this.getBlockSpeedFactor();
                this.setDeltaMovement(this.getDeltaMovement().multiply((double) f2, 1.0D, (double) f2));
            }
            if (this.level.getBlockStatesIfLoaded(this.getBoundingBox().deflate(1.0E-6D)).noneMatch((p_20127_) -> p_20127_.is(BlockTags.FIRE) || p_20127_.is(Blocks.LAVA))) {
                if (this.remainingFireTicks <= 0) {
                    this.setRemainingFireTicks(-this.getFireImmuneTicks());
                }

                if (this.wasOnFire && (this.isInPowderSnow || this.isInWaterRainOrBubble() || this.isInFluidType((fluidType, height) -> this.canFluidExtinguish(fluidType)))) {
                    this.playEntityOnFireExtinguishedSound();
                }
            }

            if (this.isOnFire() && (this.isInPowderSnow || this.isInWaterRainOrBubble() || this.isInFluidType((fluidType, height) -> this.canFluidExtinguish(fluidType)))) {
                this.setRemainingFireTicks(-this.getFireImmuneTicks());
            }

            this.level.getProfiler().pop();
        }
        ci.cancel();
    }
    @Shadow
    public Entity getVehicle() {
        return null;
    }
    @Shadow
    public boolean updateFluidHeightAndDoFluidPushing(TagKey<Fluid> p_210500_1_, double p_210500_2_) {
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
    @Shadow public boolean causeFallDamage(float p_146828_, float p_146829_, DamageSource p_146830_) {
        return false;
    }

    @Shadow public void clearFire() {}

    @Shadow public abstract boolean hurt(DamageSource p_70097_1_, float p_70097_2_);

    @Shadow private BlockPos blockPosition;

    @Shadow public abstract void remove(Entity.RemovalReason p_146834_);

    @Inject(method = "updateInWaterStateAndDoWaterCurrentPushing", at = @At("HEAD"), cancellable = true)
    public void updateInWaterStateAndDoWaterCurrentPushing(CallbackInfo ci) {

        if (this.getVehicle() instanceof Boat) {
            this.wasTouchingWater = false;
        }else if (this.updateFluidHeightAndDoFluidPushing(FluidTags.WATER, 0.014D)) {
            if (!this.wasTouchingWater && !this.firstTick) {
                this.doWaterSplashEffect();


                BlockPos blockPos = new BlockPos(this.getX(), this.getY(), this.getZ());

                int waterDepth = 1;
                while (this.level.getFluidState(new BlockPos(blockPos.getX(), blockPos.getY() - waterDepth, blockPos.getZ())).is(ConfigurableFallsTags.WATER)) {
                    waterDepth++;
                }
                try {
                    if (this.level.getFluidState(new BlockPos(blockPos.getX(), blockPos.getY(), blockPos.getZ())).is(ConfigurableFallsTags.WATER)) {
                      if (this.fallDistance >= ConfigurableFallsCommonConfigs.WATER_FALL_DAMAGE_FALL_DISTANCE.get()) {
                          if (waterDepth == 1) {
                            this.causeFallDamage(this.fallDistance + (waterDepth), ConfigurableFallsCommonConfigs.WATER_DEPTH_1_FALL_DAMAGE_PERCENTAGE.get().floatValue(), DamageSource.FALL);
                          }
                          if (waterDepth == 2) {
                            this.causeFallDamage(this.fallDistance + (waterDepth), ConfigurableFallsCommonConfigs.WATER_DEPTH_2_FALL_DAMAGE_PERCENTAGE.get().floatValue(), DamageSource.FALL);
                          }
                          if (waterDepth == 3) {
                            this.causeFallDamage(this.fallDistance + (waterDepth), ConfigurableFallsCommonConfigs.WATER_DEPTH_3_FALL_DAMAGE_PERCENTAGE.get().floatValue(), DamageSource.FALL);
                          }
                          if (waterDepth == 4) {
                            this.causeFallDamage(this.fallDistance + (waterDepth), ConfigurableFallsCommonConfigs.WATER_DEPTH_4_FALL_DAMAGE_PERCENTAGE.get().floatValue(), DamageSource.FALL);
                          }
                          if (waterDepth >= 5) {
                            this.causeFallDamage(this.fallDistance + (waterDepth), ConfigurableFallsCommonConfigs.WATER_DEPTH_5_FALL_DAMAGE_PERCENTAGE.get().floatValue(), DamageSource.FALL);
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