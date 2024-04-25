package com.kekecreations.configurable_falls.core.platform;

import com.kekecreations.configurable_falls.ConfigurableFalls;
import com.kekecreations.configurable_falls.core.platform.services.RegistryHelper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ForgeRegistryHelper implements RegistryHelper {


    @Override
    public TagKey<Block> create(String $$0) {
        return BlockTags.create(new ResourceLocation(ConfigurableFalls.MOD_ID, $$0));
    }
}
