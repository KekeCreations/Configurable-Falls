package com.kekecreations.configurable_falls.util;

import com.kekecreations.configurable_falls.ConfigurableFalls;
import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

public class ConfigurableFallsTags {


    public static final Tags.IOptionalNamedTag<Block> FRAGILE
            = tag("fragile");

    public static final Tags.IOptionalNamedTag<Block> ICE
            = tag("ice");
    public static final Tags.IOptionalNamedTag<Block> GRASS_BLOCKS
            = tag("grass_blocks");

    public static final Tags.IOptionalNamedTag<Block> GRASS
            = tag("grass");

    public static final Tags.IOptionalNamedTag<Block> TALL_GRASS
            = tag("tall_grass");

    public static final Tags.IOptionalNamedTag<Block> SNOW
            = tag("snow");

    public static final Tags.IOptionalNamedTag<Block> MELON_BLOCKS
            = tag("melon_blocks");

    public static final Tags.IOptionalNamedTag<Fluid> WATER
            = fluidTag("water");

    private static Tags.IOptionalNamedTag<Block> tag(String name) {
        return BlockTags.createOptional(new ResourceLocation(ConfigurableFalls.MOD_ID, name));
    }
    private static Tags.IOptionalNamedTag<Fluid> fluidTag(String name) {
        return FluidTags.createOptional(new ResourceLocation(ConfigurableFalls.MOD_ID, name));
    }
}
