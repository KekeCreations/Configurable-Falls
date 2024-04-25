package com.kekecreations.configurable_falls.core.tags;

import com.kekecreations.configurable_falls.ConfigurableFalls;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

public class ConfigurableFallsTags {

    public static class BlockTags {

        public static final TagKey<Block> FRAGILE
                = tag("fragile");

        public static final TagKey<Block> ICE
                = tag("ice");
        public static final TagKey<Block> GRASS_BLOCKS
                = tag("grass_blocks");

        public static final TagKey<Block> GRASS
                = tag("grass");

        public static final TagKey<Block> TALL_GRASS
                = tag("tall_grass");

        public static final TagKey<Block> SNOW
                = tag("snow");

        public static final TagKey<Block> MELON_BLOCKS
                = tag("melon_blocks");

        private static TagKey<Block> tag(String name) {
            return TagKey.create(Registries.BLOCK, new ResourceLocation(ConfigurableFalls.MOD_ID, name));
        }

        public static void registerBlockTags() {
            System.out.println("Configurable Falls Block Tags Loaded");
        }
    }

    public static class FluidTags {
        public static final TagKey<Fluid> WATER
                = tag("water");

        private static TagKey<Fluid> tag(String name) {
            return TagKey.create(Registries.FLUID, new ResourceLocation(ConfigurableFalls.MOD_ID, name));
        }
        public static void registerFluidTags() {
            System.out.println("Configurable Falls Fluid Tags Loaded");
        }
    }
}
