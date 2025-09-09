package com.kekecreations.configurable_falls;


import com.kekecreations.configurable_falls.core.config.ConfigurableFallsCommonConfig;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

@Mod(ConfigurableFalls.MOD_ID)
public class NeoForgeConfigurableFalls {

    public NeoForgeConfigurableFalls(IEventBus eventBus, ModContainer modContainer) {
        modContainer.registerConfig(ModConfig.Type.COMMON, ConfigurableFallsCommonConfig.SPEC);

        ConfigurableFalls.init();

    }
}