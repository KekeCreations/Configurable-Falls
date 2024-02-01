package com.kekecreations.configurable_falls.events;

import com.kekecreations.configurable_falls.ConfigurableFalls;
import com.kekecreations.configurable_falls.config.ConfigurableFallsCommonConfigs;
import com.kekecreations.configurable_falls.util.ConfigurableFallsTags;
import net.minecraft.block.AbstractGlassBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.StainedGlassPaneBlock;
import net.minecraft.entity.Entity;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ConfigurableFalls.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class KekeFallEvent {

    @SubscribeEvent
    public void onFall(LivingFallEvent livingFallEvent) {
        Entity entity = livingFallEvent.getEntity();
        BlockPos layerPos = new BlockPos(entity.getX(), entity.getY(), entity.getZ());
        BlockPos blockPos = new BlockPos(entity.getX(), entity.getY() - 1, entity.getZ());


        if (!entity.level.isClientSide()) {
            //Ice
            if (entity.fallDistance >= ConfigurableFallsCommonConfigs.ICE_BREAK_ON_FALL_FALL_DISTANCE.get() && ConfigurableFallsCommonConfigs.ICE_BREAK_ON_FALL.get() && entity.level.getBlockState(blockPos).is(ConfigurableFallsTags.ICE)) {
                entity.level.destroyBlock(blockPos, true, entity);
            }
            //Glass
            if (entity.fallDistance >= ConfigurableFallsCommonConfigs.GLASS_BREAK_ON_FALL_FALL_DISTANCE.get() && ConfigurableFallsCommonConfigs.GLASS_BREAK_ON_FALL.get() && entity.level.getBlockState(blockPos).is(Tags.Blocks.GLASS)) {
                entity.level.destroyBlock(blockPos, ConfigurableFallsCommonConfigs.GLASS_BREAK_ON_FALL_DROPS.get(), entity);
            }
            if (entity.fallDistance >= ConfigurableFallsCommonConfigs.GLASS_PANE_BREAK_ON_FALL_FALL_DISTANCE.get() && ConfigurableFallsCommonConfigs.GLASS_PANE_BREAK_ON_FALL.get() && entity.level.getBlockState(blockPos).is(Tags.Blocks.GLASS_PANES)) {
                entity.level.destroyBlock(blockPos, false, entity);
            }

            //Snow
            if (entity.fallDistance >= ConfigurableFallsCommonConfigs.SNOW_BREAK_ON_FALL_FALL_DISTANCE.get() && ConfigurableFallsCommonConfigs.SNOW_BREAK_ON_FALL.get() && entity.level.getBlockState(layerPos).is(ConfigurableFallsTags.SNOW)) {
                entity.level.destroyBlock(layerPos, ConfigurableFallsCommonConfigs.SNOW_BREAK_ON_FALL_DROPS.get(), entity);
            }

            //Grass
            if (entity.fallDistance >= ConfigurableFallsCommonConfigs.GRASS_BREAK_ON_FALL_FALL_DISTANCE.get() && ConfigurableFallsCommonConfigs.GRASS_BREAK_ON_FALL.get() && entity.level.getBlockState(layerPos).is(ConfigurableFallsTags.GRASS)) {
                entity.level.destroyBlock(layerPos, ConfigurableFallsCommonConfigs.GRASS_BREAK_ON_FALL_DROPS.get(), entity);
            }
            if (entity.fallDistance >= ConfigurableFallsCommonConfigs.GRASS_TURNS_TO_DIRT_ON_FALL_FALL_DISTANCE.get() && ConfigurableFallsCommonConfigs.GRASS_TURNS_TO_DIRT_ON_FALL.get() && entity.level.getBlockState(blockPos).is(ConfigurableFallsTags.GRASS_BLOCKS)) {
                entity.level.setBlock(blockPos, Blocks.DIRT.defaultBlockState(), 3);
            }
            if (entity.fallDistance >= ConfigurableFallsCommonConfigs.TALL_GRASS_BREAK_ON_FALL_FALL_DISTANCE.get() && ConfigurableFallsCommonConfigs.TALL_GRASS_BREAK_ON_FALL.get() && entity.level.getBlockState(layerPos).is(ConfigurableFallsTags.TALL_GRASS)) {
                entity.level.destroyBlock(layerPos, ConfigurableFallsCommonConfigs.TALL_GRASS_BREAK_ON_FALL_DROPS.get(), entity);
            }

            //LEAVES
            if (entity.fallDistance >= ConfigurableFallsCommonConfigs.LEAVES_BREAK_ON_FALL_FALL_DISTANCE.get() && ConfigurableFallsCommonConfigs.LEAVES_BREAK_ON_FALL.get() && entity.level.getBlockState(blockPos).is(BlockTags.LEAVES)) {
                entity.level.destroyBlock(blockPos, ConfigurableFallsCommonConfigs.LEAVES_BREAK_ON_FALL_DROPS.get(), entity);
            }


            //ETC
            if (entity.fallDistance >= ConfigurableFallsCommonConfigs.MELON_EXPLODE_INTO_SLICES_ON_FALL_FALL_DISTANCE.get() && ConfigurableFallsCommonConfigs.MELON_EXPLODE_INTO_SLICES_ON_FALL.get() && entity.level.getBlockState(blockPos).is(ConfigurableFallsTags.MELON_BLOCKS)) {
                entity.level.destroyBlock(blockPos, true, entity);
            }


            //TAGS
            if (entity.fallDistance >= ConfigurableFallsCommonConfigs.CONFIGURABLE_FALLS_FRAGILE_BREAK_ON_FALL_FALL_DISTANCE.get() && entity.level.getBlockState(blockPos).is(ConfigurableFallsTags.FRAGILE)) {
                entity.level.destroyBlock(blockPos, ConfigurableFallsCommonConfigs.CONFIGURABLE_FALLS_FRAGILE_BREAK_ON_FALL_DROPS.get(), entity);
            }
        }
    }
}
