package com.kekecreations.configurable_falls.util;

import com.kekecreations.configurable_falls.ConfigurableFalls;
import net.minecraft.block.Block;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

public class ConfigurableFallsTags {


    public static final Tags.IOptionalNamedTag<Block> FRAGILE
            = tag("fragile");

    private static Tags.IOptionalNamedTag<Block> tag(String name) {
        return BlockTags.createOptional(new ResourceLocation(ConfigurableFalls.MOD_ID, name));
    }
}
