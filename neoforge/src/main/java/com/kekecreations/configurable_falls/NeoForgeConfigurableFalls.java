package com.kekecreations.configurable_falls;


import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(ConfigurableFalls.MOD_ID)
public class NeoForgeConfigurableFalls {

    public NeoForgeConfigurableFalls(IEventBus eventBus) {
        ConfigurableFalls.init();

    }
}