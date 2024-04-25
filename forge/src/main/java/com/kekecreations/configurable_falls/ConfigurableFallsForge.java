package com.kekecreations.configurable_falls;

import com.kekecreations.configurable_falls.core.config.ConfigurableFallsCommonConfig;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(ConfigurableFalls.MOD_ID)
public class ConfigurableFallsForge {
    
    public ConfigurableFallsForge() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigurableFallsCommonConfig.SPEC, "configurable_falls-common.toml");

        ConfigurableFalls.init();
        
    }
}