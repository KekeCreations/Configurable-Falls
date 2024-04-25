package com.kekecreations.configurable_falls;


import com.kekecreations.configurable_falls.core.config.ConfigurableFallsCommonConfig;
import fuzs.forgeconfigapiport.neoforge.api.forge.v4.ForgeConfigRegistry;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

@Mod(ConfigurableFalls.MOD_ID)
public class ConfigurableFallsNeoForge {


    public ConfigurableFallsNeoForge() {
        ForgeConfigRegistry.INSTANCE.register(ConfigurableFalls.MOD_ID, ModConfig.Type.COMMON, ConfigurableFallsCommonConfig.SPEC, "configurable_falls-common.toml");

        ConfigurableFalls.init();
    }
}