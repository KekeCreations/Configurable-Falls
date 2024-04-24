package com.kekecreations.configurable_falls;


import net.neoforged.fml.common.Mod;

@Mod(ConfigurableFalls.MOD_ID)
public class ConfigurableFallsNeoForge {


    public ConfigurableFallsNeoForge() {

        // This method is invoked by the NeoForge mod loader when it is ready
        // to load your mod. You can access NeoForge and Common code in this
        // project.

        // Use NeoForge to bootstrap the Common mod.
        ConfigurableFalls.LOG.info("Hello NeoForge world!");
        ConfigurableFalls.init();

    }
}