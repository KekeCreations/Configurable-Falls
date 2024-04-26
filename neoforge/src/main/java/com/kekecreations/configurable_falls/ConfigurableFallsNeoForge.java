package com.kekecreations.configurable_falls;


import com.kekecreations.configurable_falls.core.config.ConfigurableFallsCommonConfig;
import com.kekecreations.configurable_falls.core.events.KekeFallEvent;
import fuzs.forgeconfigapiport.neoforge.api.forge.v4.ForgeConfigRegistry;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.common.NeoForge;

@Mod(ConfigurableFalls.MOD_ID)
public class ConfigurableFallsNeoForge {


    public ConfigurableFallsNeoForge() {
        ForgeConfigRegistry.INSTANCE.register(ConfigurableFalls.MOD_ID, ModConfig.Type.COMMON, ConfigurableFallsCommonConfig.SPEC, "configurable_falls-common.toml");

        ConfigurableFalls.init();
        //NeoForge.EVENT_BUS.addListener(KekeFallEvent.class);
    }
}