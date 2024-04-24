package com.kekecreations.configurable_falls;

import net.minecraftforge.fml.common.Mod;

@Mod(ConfigurableFalls.MOD_ID)
public class ConfigurableFallsForge {
    
    public ConfigurableFallsForge() {
    
        // This method is invoked by the Forge mod loader when it is ready
        // to load your mod. You can access Forge and Common code in this
        // project.
    
        // Use Forge to bootstrap the Common mod.
        ConfigurableFalls.init();
        
    }
}