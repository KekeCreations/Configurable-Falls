package com.kekecreations.configurable_falls;

import com.kekecreations.configurable_falls.core.tags.ConfigurableFallsTags;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigurableFalls {

    public static final String MOD_ID = "configurable_falls";
    public static final String MOD_NAME = "Configurable Falls";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

    public static void init() {
        ConfigurableFallsTags.BlockTags.registerBlockTags();
        ConfigurableFallsTags.FluidTags.registerFluidTags();
    }
}