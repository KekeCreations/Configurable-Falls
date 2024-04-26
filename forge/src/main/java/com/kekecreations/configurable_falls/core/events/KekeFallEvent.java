package com.kekecreations.configurable_falls.core.events;

import com.kekecreations.configurable_falls.ConfigurableFalls;
import com.kekecreations.configurable_falls.core.config.ConfigurableFallsCommonConfig;
import com.kekecreations.configurable_falls.core.tags.ConfigurableFallsTags;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BrushableBlock;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ConfigurableFalls.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class KekeFallEvent {



    @SubscribeEvent
    public void onFall(LivingFallEvent livingFallEvent) {
        Entity entity = livingFallEvent.getEntity();
        BlockPos layerPos = new BlockPos(entity.getBlockX(), entity.getBlockY(), entity.getBlockZ());
        BlockPos blockPos = new BlockPos(entity.getBlockX(), entity.getBlockY() - 1, entity.getBlockZ());


        if (!entity.level().isClientSide()) {
            //Ice
            if (entity.fallDistance >= ConfigurableFallsCommonConfig.ICE_BREAK_ON_FALL_FALL_DISTANCE.get() && ConfigurableFallsCommonConfig.ICE_BREAK_ON_FALL.get() && entity.level().getBlockState(blockPos).is(ConfigurableFallsTags.BlockTags.ICE)) {
                entity.level().destroyBlock(blockPos, true, entity);
            }
            //Glass
            if (entity.fallDistance >= ConfigurableFallsCommonConfig.GLASS_BREAK_ON_FALL_FALL_DISTANCE.get() && ConfigurableFallsCommonConfig.GLASS_BREAK_ON_FALL.get() && entity.level().getBlockState(blockPos).is(Tags.Blocks.GLASS)) {
                entity.level().destroyBlock(blockPos, ConfigurableFallsCommonConfig.GLASS_BREAK_ON_FALL_DROPS.get(), entity);
            }
            if (entity.fallDistance >= ConfigurableFallsCommonConfig.GLASS_PANE_BREAK_ON_FALL_FALL_DISTANCE.get() && ConfigurableFallsCommonConfig.GLASS_PANE_BREAK_ON_FALL.get() && entity.level().getBlockState(blockPos).is(Tags.Blocks.GLASS_PANES)) {
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
            if (entity.fallDistance >= ConfigurableFallsCommonConfig.CONFIGURABLE_FALLS_FRAGILE_BREAK_ON_FALL_FALL_DISTANCE.get() && entity.level().getBlockState(blockPos).is(ConfigurableFallsTags.BlockTags.FRAGILE)) {
                entity.level().destroyBlock(blockPos, ConfigurableFallsCommonConfig.CONFIGURABLE_FALLS_FRAGILE_BREAK_ON_FALL_DROPS.get(), entity);
            }
        }
    }
}
