package com.kekecreations.configurable_falls;

import net.fabricmc.api.ModInitializer;

public class FabricConfigurableFalls implements ModInitializer {
    
    @Override
    public void onInitialize() {
        ConfigurableFalls.init();
    }
}
