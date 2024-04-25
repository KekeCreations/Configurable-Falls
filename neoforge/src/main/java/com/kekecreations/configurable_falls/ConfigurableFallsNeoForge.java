package com.kekecreations.configurable_falls;


import com.kekecreations.configurable_falls.core.config.ConfigurableFallsCommonConfig;
import fuzs.forgeconfigapiport.neoforge.api.forge.v4.ForgeConfigRegistry;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

@Mod(ConfigurableFalls.MOD_ID)
public class ConfigurableFallsNeoForge {


    public ConfigurableFallsNeoForge() {
        ForgeConfigRegistry.INSTANCE.register(ConfigurableFalls.MOD_ID, ModConfig.Type.COMMON, ConfigurableFallsCommonConfig.SPEC, "configurable_falls-common.toml");

        // This method is invoked by the NeoForge mod loader when it is ready
        // to load your mod. You can access NeoForge and Common code in this
        // project.

        // Use NeoForge to bootstrap the Common mod.
        ConfigurableFalls.LOG.info("Hello NeoForge world!");
        ConfigurableFalls.init();

    }
}