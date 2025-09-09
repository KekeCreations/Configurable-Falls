package com.kekecreations.configurable_falls;

import com.kekecreations.configurable_falls.core.config.ConfigurableFallsCommonConfig;
import fuzs.forgeconfigapiport.fabric.api.neoforge.v4.NeoForgeConfigRegistry;
import net.fabricmc.api.ModInitializer;
import net.neoforged.fml.config.ModConfig;

public class FabricConfigurableFalls implements ModInitializer {
    
    @Override
    public void onInitialize() {
        NeoForgeConfigRegistry.INSTANCE.register(ConfigurableFalls.MOD_ID, ModConfig.Type.COMMON, ConfigurableFallsCommonConfig.SPEC, "configurable_falls-common.toml");

        ConfigurableFalls.init();
    }
}
