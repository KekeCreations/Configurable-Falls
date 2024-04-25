package com.kekecreations.configurable_falls;

import com.kekecreations.configurable_falls.core.config.ConfigurableFallsCommonConfig;
import fuzs.forgeconfigapiport.fabric.api.forge.v4.ForgeConfigRegistry;
import net.fabricmc.api.ModInitializer;
import net.minecraftforge.fml.config.ModConfig;

public class ConfigurableFallsFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        ForgeConfigRegistry.INSTANCE.register(ConfigurableFalls.MOD_ID, ModConfig.Type.COMMON, ConfigurableFallsCommonConfig.SPEC, "configurable_falls-common.toml");

        ConfigurableFalls.init();
    }
}
