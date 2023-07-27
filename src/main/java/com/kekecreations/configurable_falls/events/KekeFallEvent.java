package com.kekecreations.configurable_falls.events;

import com.kekecreations.configurable_falls.ConfigurableFalls;
import com.kekecreations.configurable_falls.config.ConfigurableFallsCommonConfigs;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.*;
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


        //Ice
        if (entity.fallDistance >= ConfigurableFallsCommonConfigs.ICE_BREAK_ON_FALL_FALL_DISTANCE.get() && ConfigurableFallsCommonConfigs.ICE_BREAK_ON_FALL.get() && entity.getBlockStateOn().getBlock() == Blocks.ICE) {
            entity.level().destroyBlock(blockPos, true, entity);
        }
        //Glass
        if (entity.fallDistance >= ConfigurableFallsCommonConfigs.GLASS_BREAK_ON_FALL_FALL_DISTANCE.get() && ConfigurableFallsCommonConfigs.GLASS_BREAK_ON_FALL.get() && entity.getBlockStateOn().getBlock() instanceof AbstractGlassBlock) {
            entity.level().destroyBlock(blockPos, ConfigurableFallsCommonConfigs.GLASS_BREAK_ON_FALL_DROPS.get(), entity);
        }
        if (entity.fallDistance >= ConfigurableFallsCommonConfigs.GLASS_PANE_BREAK_ON_FALL_FALL_DISTANCE.get() && ConfigurableFallsCommonConfigs.GLASS_PANE_BREAK_ON_FALL.get() && entity.getBlockStateOn().getBlock() == Blocks.GLASS_PANE) {
            entity.level().destroyBlock(blockPos, false, entity);
        }
        if (entity.fallDistance >= ConfigurableFallsCommonConfigs.GLASS_PANE_BREAK_ON_FALL_FALL_DISTANCE.get() && ConfigurableFallsCommonConfigs.GLASS_PANE_BREAK_ON_FALL.get() && entity.getBlockStateOn().getBlock() instanceof StainedGlassPaneBlock) {
            entity.level().destroyBlock(blockPos, false, entity);
        }
        //Snow
        if (entity.fallDistance >= ConfigurableFallsCommonConfigs.SNOW_BREAK_ON_FALL_FALL_DISTANCE.get() && ConfigurableFallsCommonConfigs.SNOW_BREAK_ON_FALL.get() && entity.level().getBlockState(layerPos).getBlock() == Blocks.SNOW) {
            entity.level().destroyBlock(layerPos, ConfigurableFallsCommonConfigs.SNOW_BREAK_ON_FALL_DROPS.get(), entity);
        }

        //Grass
        if (entity.fallDistance >= ConfigurableFallsCommonConfigs.GRASS_BREAK_ON_FALL_FALL_DISTANCE.get() && ConfigurableFallsCommonConfigs.GRASS_BREAK_ON_FALL.get() && entity.level().getBlockState(layerPos).getBlock() == Blocks.GRASS) {
            entity.level().destroyBlock(layerPos, ConfigurableFallsCommonConfigs.GRASS_BREAK_ON_FALL_DROPS.get(), entity);
        }
        if (entity.fallDistance >= ConfigurableFallsCommonConfigs.GRASS_TURNS_TO_DIRT_ON_FALL_FALL_DISTANCE.get() && ConfigurableFallsCommonConfigs.GRASS_TURNS_TO_DIRT_ON_FALL.get() && entity.level().getBlockState(blockPos).getBlock() == Blocks.GRASS_BLOCK) {
            entity.level().setBlock(blockPos, Blocks.DIRT.defaultBlockState(), 1);
        }
        if (entity.fallDistance >= ConfigurableFallsCommonConfigs.TALL_GRASS_BREAK_ON_FALL_FALL_DISTANCE.get() && ConfigurableFallsCommonConfigs.TALL_GRASS_BREAK_ON_FALL.get() && entity.level().getBlockState(layerPos).getBlock() == Blocks.TALL_GRASS) {
            entity.level().destroyBlock(layerPos, ConfigurableFallsCommonConfigs.TALL_GRASS_BREAK_ON_FALL_DROPS.get(), entity);
        }
    }
}
