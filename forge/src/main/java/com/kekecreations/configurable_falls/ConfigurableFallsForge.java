package com.kekecreations.configurable_falls;

import com.kekecreations.configurable_falls.core.config.ConfigurableFallsCommonConfig;
import com.kekecreations.configurable_falls.core.events.KekeFallEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ConfigurableFalls.MOD_ID)
public class ConfigurableFallsForge {
    
    public ConfigurableFallsForge() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigurableFallsCommonConfig.SPEC, "configurable_falls-common.toml");


        modEventBus.addListener(this::loadComplete);
        ConfigurableFalls.init();
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void loadComplete(final FMLLoadCompleteEvent loadCompleteEvent) {
        MinecraftForge.EVENT_BUS.register(new KekeFallEvent());
    }
}