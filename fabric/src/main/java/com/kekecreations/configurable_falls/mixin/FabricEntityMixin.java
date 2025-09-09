package com.kekecreations.configurable_falls.mixin;

import com.kekecreations.configurable_falls.common.tag.ConfigurableFallsTags;
import com.kekecreations.configurable_falls.core.config.ConfigurableFallsCommonConfig;
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
    public void configurable_falls$move(MoverType moverType, Vec3 vec3, CallbackInfo ci) {
        Entity entity = Entity.class.cast(this);
        BlockPos layerPos = new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ());
        BlockPos blockPos = new BlockPos(entity.getBlockX(), entity.getBlockY() - 1, entity.getBlockZ());


        if (!entity.level().isClientSide() && entity.onGround() && (!(entity instanceof Player) || (entity instanceof Player player && !player.isCreative() && !player.isSpectator()))) {
            //Ice
            if (entity.fallDistance >= ConfigurableFallsCommonConfig.ICE_BREAK_ON_FALL_FALL_DISTANCE.get() && ConfigurableFallsCommonConfig.ICE_BREAK_ON_FALL.get() && entity.level().getBlockState(blockPos).is(ConfigurableFallsTags.BlockTags.ICE)) {
                entity.level().destroyBlock(blockPos, true, entity);
            }
            //Glass
            if (entity.fallDistance >= ConfigurableFallsCommonConfig.GLASS_BREAK_ON_FALL_FALL_DISTANCE.get() && ConfigurableFallsCommonConfig.GLASS_BREAK_ON_FALL.get() && entity.level().getBlockState(blockPos).is(ConventionalBlockTags.GLASS_BLOCKS)) {
                entity.level().destroyBlock(blockPos, ConfigurableFallsCommonConfig.GLASS_BREAK_ON_FALL_DROPS.get(), entity);
            }
            if (entity.fallDistance >= ConfigurableFallsCommonConfig.GLASS_PANE_BREAK_ON_FALL_FALL_DISTANCE.get() && ConfigurableFallsCommonConfig.GLASS_PANE_BREAK_ON_FALL.get() && entity.level().getBlockState(blockPos).is(ConventionalBlockTags.GLASS_PANES)) {
                entity.level().destroyBlock(blockPos, false, entity);
            }

            //Snow
            if (entity.fallDistance >= ConfigurableFallsCommonConfig.SNOW_BREAK_ON_FALL_FALL_DISTANCE.get() && ConfigurableFallsCommonConfig.SNOW_BREAK_ON_FALL.get() && entity.level().getBlockState(layerPos).is(ConfigurableFallsTags.BlockTags.SNOW)) {
                entity.level().destroyBlock(layerPos, ConfigurableFallsCommonConfig.SNOW_BREAK_ON_FALL_DROPS.get(), entity);
            }

            //Grass
            if (entity.fallDistance >= ConfigurableFallsCommonConfig.GRASS_BREAK_ON_FALL_FALL_DISTANCE.get() && ConfigurableFallsCommonConfig.GRASS_BREAK_ON_FALL.get() && entity.level().getBlockState(layerPos).is(ConfigurableFallsTags.BlockTags.GRASS)) {
                entity.level().destroyBlock(layerPos, ConfigurableFallsCommonConfig.GRASS_BREAK_ON_FALL_DROPS.get(), entity);
            }
            if (entity.fallDistance >= ConfigurableFallsCommonConfig.GRASS_TURNS_TO_DIRT_ON_FALL_FALL_DISTANCE.get() && ConfigurableFallsCommonConfig.GRASS_TURNS_TO_DIRT_ON_FALL.get() && entity.level().getBlockState(blockPos).is(ConfigurableFallsTags.BlockTags.GRASS_BLOCKS)) {
                entity.level().setBlock(blockPos, Blocks.DIRT.defaultBlockState(), 3);
            }
            if (entity.fallDistance >= ConfigurableFallsCommonConfig.TALL_GRASS_BREAK_ON_FALL_FALL_DISTANCE.get() && ConfigurableFallsCommonConfig.TALL_GRASS_BREAK_ON_FALL.get() && entity.level().getBlockState(layerPos).is(ConfigurableFallsTags.BlockTags.TALL_GRASS)) {
                entity.level().destroyBlock(layerPos, ConfigurableFallsCommonConfig.TALL_GRASS_BREAK_ON_FALL_DROPS.get(), entity);
            }
            //FLOWERS
            if (entity.fallDistance >= ConfigurableFallsCommonConfig.SMALL_FLOWERS_BREAK_ON_FALL_FALL_DISTANCE.get() && ConfigurableFallsCommonConfig.SMALL_FLOWERS_BREAK_ON_FALL.get() && entity.level().getBlockState(layerPos).is(BlockTags.SMALL_FLOWERS)) {
                entity.level().destroyBlock(layerPos, ConfigurableFallsCommonConfig.SMALL_FLOWERS_BREAK_ON_FALL_DROPS.get(), entity);
            }

            if (entity.fallDistance >= ConfigurableFallsCommonConfig.TALL_FLOWERS_BREAK_ON_FALL_FALL_DISTANCE.get() && ConfigurableFallsCommonConfig.TALL_FLOWERS_BREAK_ON_FALL.get() && entity.level().getBlockState(layerPos).is(BlockTags.TALL_FLOWERS)) {
                entity.level().destroyBlock(layerPos, ConfigurableFallsCommonConfig.TALL_FLOWERS_BREAK_ON_FALL_DROPS.get(), entity);
            }

            //LEAVES
            if (entity.fallDistance >= ConfigurableFallsCommonConfig.LEAVES_BREAK_ON_FALL_FALL_DISTANCE.get() && ConfigurableFallsCommonConfig.LEAVES_BREAK_ON_FALL.get() && entity.level().getBlockState(blockPos).is(BlockTags.LEAVES)) {
                entity.level().destroyBlock(blockPos, ConfigurableFallsCommonConfig.LEAVES_BREAK_ON_FALL_DROPS.get(), entity);
            }


            //ETC
            if (entity.fallDistance >= ConfigurableFallsCommonConfig.MELON_EXPLODE_INTO_SLICES_ON_FALL_FALL_DISTANCE.get() && ConfigurableFallsCommonConfig.MELON_EXPLODE_INTO_SLICES_ON_FALL.get() && entity.level().getBlockState(blockPos).is(ConfigurableFallsTags.BlockTags.MELON_BLOCKS)) {
                entity.level().destroyBlock(blockPos, true, entity);
            }
            if (entity.fallDistance >= ConfigurableFallsCommonConfig.SUS_BLOCKS_BREAK_ON_FALL_FALL_DISTANCE.get() && ConfigurableFallsCommonConfig.SUS_BLOCKS_BREAK_ON_FALL.get() && entity.level().getBlockState(blockPos).getBlock() instanceof BrushableBlock) {
                entity.level().destroyBlock(blockPos, true, entity);
            }


            //TAGS
            if (entity.fallDistance >= ConfigurableFallsCommonConfig.CONFIGURABLE_FALLS_FRAGILE_BREAK_ON_FALL_FALL_DISTANCE.get() && entity.level().getBlockState(blockPos).is(ConfigurableFallsTags.BlockTags.FRAGILE) && entity.level().getBlockState(blockPos).getBlock() != Blocks.AIR) {
                entity.level().destroyBlock(blockPos, ConfigurableFallsCommonConfig.CONFIGURABLE_FALLS_FRAGILE_BREAK_ON_FALL_DROPS.get(), entity);
            }
        }
    }
}
