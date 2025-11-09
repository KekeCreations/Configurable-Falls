package com.kekecreations.break_my_fall;

import com.kekecreations.break_my_fall.common.tag.ConfigurableFallsTags;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BreakMyFall {

    public static final String MOD_ID = "break_my_fall";
    public static final String MOD_NAME = "Break My Fall";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

    public static void init() {
        ConfigurableFallsTags.BlockTags.registerBlockTags();
        ConfigurableFallsTags.FluidTags.registerFluidTags();
    }
}