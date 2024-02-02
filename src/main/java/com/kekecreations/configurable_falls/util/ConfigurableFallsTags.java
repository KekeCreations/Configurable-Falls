package com.kekecreations.configurable_falls.util;

import com.kekecreations.configurable_falls.ConfigurableFalls;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

public class ConfigurableFallsTags {


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

    public static final TagKey<Fluid> WATER
            = fluidTag("water");

    private static TagKey<Block> tag(String name) {
        return BlockTags.create(new ResourceLocation(ConfigurableFalls.MOD_ID, name));
    }
    private static TagKey<Fluid> fluidTag(String name) {
        return FluidTags.create(new ResourceLocation(ConfigurableFalls.MOD_ID, name));
    }
}
