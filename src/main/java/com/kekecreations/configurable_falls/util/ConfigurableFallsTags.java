package com.kekecreations.configurable_falls.util;

import com.kekecreations.configurable_falls.ConfigurableFalls;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ConfigurableFallsTags {


    public static final TagKey<Block> FRAGILE
            = tag("fragile");

    private static TagKey<Block> tag(String name) {
        return BlockTags.create(new ResourceLocation(ConfigurableFalls.MOD_ID, name));
    }
}
