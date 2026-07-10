package com.kekecreations.break_my_fall.mixin;

import com.kekecreations.break_my_fall.common.tag.ConfigurableFallsTags;
import com.kekecreations.break_my_fall.core.config.BreakMyFallCommonConfig;
import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BrushableBlock;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public class FabricEntityMixin {


    @Inject(method = "move", at = @At(value = "TAIL"))
    public void break_my_fall$move(MoverType moverType, Vec3 vec3, CallbackInfo ci) {
        Entity entity = Entity.class.cast(this);
        BlockPos layerPos = new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ());
        BlockPos blockPos = new BlockPos(entity.getBlockX(), entity.getBlockY() - 1, entity.getBlockZ());


        if (!entity.level().isClientSide() && entity.onGround() && (!(entity instanceof Player) || (entity instanceof Player player && !player.isCreative() && !player.isSpectator()))) {
            //Ice
            if (entity.fallDistance >= BreakMyFallCommonConfig.ICE_BREAK_ON_FALL_FALL_DISTANCE.get() && BreakMyFallCommonConfig.ICE_BREAK_ON_FALL.get() && entity.level().getBlockState(blockPos).is(ConfigurableFallsTags.BlockTags.ICE)) {
                entity.level().destroyBlock(blockPos, true, entity);
            }
            //Glass
            if (entity.fallDistance >= BreakMyFallCommonConfig.GLASS_BREAK_ON_FALL_FALL_DISTANCE.get() && BreakMyFallCommonConfig.GLASS_BREAK_ON_FALL.get() && entity.level().getBlockState(blockPos).is(ConventionalBlockTags.GLASS_BLOCKS)) {
                entity.level().destroyBlock(blockPos, BreakMyFallCommonConfig.GLASS_BREAK_ON_FALL_DROPS.get(), entity);
            }
            if (entity.fallDistance >= BreakMyFallCommonConfig.GLASS_PANE_BREAK_ON_FALL_FALL_DISTANCE.get() && BreakMyFallCommonConfig.GLASS_PANE_BREAK_ON_FALL.get() && entity.level().getBlockState(blockPos).is(ConventionalBlockTags.GLASS_PANES)) {
                entity.level().destroyBlock(blockPos, false, entity);
            }

            //Snow
            if (entity.fallDistance >= BreakMyFallCommonConfig.SNOW_BREAK_ON_FALL_FALL_DISTANCE.get() && BreakMyFallCommonConfig.SNOW_BREAK_ON_FALL.get() && entity.level().getBlockState(layerPos).is(ConfigurableFallsTags.BlockTags.SNOW)) {
                entity.level().destroyBlock(layerPos, BreakMyFallCommonConfig.SNOW_BREAK_ON_FALL_DROPS.get(), entity);
            }

            //Grass
            if (entity.fallDistance >= BreakMyFallCommonConfig.GRASS_BREAK_ON_FALL_FALL_DISTANCE.get() && BreakMyFallCommonConfig.GRASS_BREAK_ON_FALL.get() && entity.level().getBlockState(layerPos).is(ConfigurableFallsTags.BlockTags.GRASS)) {
                entity.level().destroyBlock(layerPos, BreakMyFallCommonConfig.GRASS_BREAK_ON_FALL_DROPS.get(), entity);
            }
            if (entity.fallDistance >= BreakMyFallCommonConfig.GRASS_TURNS_TO_DIRT_ON_FALL_FALL_DISTANCE.get() && BreakMyFallCommonConfig.GRASS_TURNS_TO_DIRT_ON_FALL.get() && entity.level().getBlockState(blockPos).is(ConfigurableFallsTags.BlockTags.GRASS_BLOCKS)) {
                entity.level().setBlock(blockPos, Blocks.DIRT.defaultBlockState(), 3);
            }
            if (entity.fallDistance >= BreakMyFallCommonConfig.TALL_GRASS_BREAK_ON_FALL_FALL_DISTANCE.get() && BreakMyFallCommonConfig.TALL_GRASS_BREAK_ON_FALL.get() && entity.level().getBlockState(layerPos).is(ConfigurableFallsTags.BlockTags.TALL_GRASS)) {
                entity.level().destroyBlock(layerPos, BreakMyFallCommonConfig.TALL_GRASS_BREAK_ON_FALL_DROPS.get(), entity);
            }
            //FLOWERS
            if (entity.fallDistance >= BreakMyFallCommonConfig.SMALL_FLOWERS_BREAK_ON_FALL_FALL_DISTANCE.get() && BreakMyFallCommonConfig.SMALL_FLOWERS_BREAK_ON_FALL.get() && entity.level().getBlockState(layerPos).is(BlockTags.SMALL_FLOWERS)) {
                entity.level().destroyBlock(layerPos, BreakMyFallCommonConfig.SMALL_FLOWERS_BREAK_ON_FALL_DROPS.get(), entity);
            }

            if (entity.fallDistance >= BreakMyFallCommonConfig.TALL_FLOWERS_BREAK_ON_FALL_FALL_DISTANCE.get() && BreakMyFallCommonConfig.TALL_FLOWERS_BREAK_ON_FALL.get() && entity.level().getBlockState(layerPos).is(BlockTags.TALL_FLOWERS)) {
                entity.level().destroyBlock(layerPos, BreakMyFallCommonConfig.TALL_FLOWERS_BREAK_ON_FALL_DROPS.get(), entity);
            }

            //LEAVES
            if (entity.fallDistance >= BreakMyFallCommonConfig.LEAVES_BREAK_ON_FALL_FALL_DISTANCE.get() && BreakMyFallCommonConfig.LEAVES_BREAK_ON_FALL.get() && entity.level().getBlockState(blockPos).is(BlockTags.LEAVES)) {
                entity.level().destroyBlock(blockPos, BreakMyFallCommonConfig.LEAVES_BREAK_ON_FALL_DROPS.get(), entity);
            }


            //ETC
            if (entity.fallDistance >= BreakMyFallCommonConfig.MELON_EXPLODE_INTO_SLICES_ON_FALL_FALL_DISTANCE.get() && BreakMyFallCommonConfig.MELON_EXPLODE_INTO_SLICES_ON_FALL.get() && entity.level().getBlockState(blockPos).is(ConfigurableFallsTags.BlockTags.MELON_BLOCKS)) {
                entity.level().destroyBlock(blockPos, true, entity);
            }
            if (entity.fallDistance >= BreakMyFallCommonConfig.SUS_BLOCKS_BREAK_ON_FALL_FALL_DISTANCE.get() && BreakMyFallCommonConfig.SUS_BLOCKS_BREAK_ON_FALL.get() && entity.level().getBlockState(blockPos).getBlock() instanceof BrushableBlock) {
                entity.level().destroyBlock(blockPos, true, entity);
            }


            //TAGS
            if (entity.fallDistance >= BreakMyFallCommonConfig.CONFIGURABLE_FALLS_FRAGILE_BREAK_ON_FALL_FALL_DISTANCE.get() && entity.level().getBlockState(blockPos).is(ConfigurableFallsTags.BlockTags.FRAGILE) && entity.level().getBlockState(blockPos).getBlock() != Blocks.AIR) {
                entity.level().destroyBlock(blockPos, BreakMyFallCommonConfig.CONFIGURABLE_FALLS_FRAGILE_BREAK_ON_FALL_DROPS.get(), entity);
            }
        }
    }
}
