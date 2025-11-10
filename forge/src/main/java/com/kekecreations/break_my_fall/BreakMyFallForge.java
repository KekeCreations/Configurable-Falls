package com.kekecreations.break_my_fall;

import com.kekecreations.break_my_fall.core.config.BreakMyFallCommonConfig;
import com.kekecreations.break_my_fall.core.events.KekeFallEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(BreakMyFall.MOD_ID)
public class BreakMyFallForge {
    
    public BreakMyFallForge() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, BreakMyFallCommonConfig.SPEC, "break-my-fall-common.toml");


        modEventBus.addListener(this::loadComplete);
        BreakMyFall.init();
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void loadComplete(final FMLLoadCompleteEvent loadCompleteEvent) {
        MinecraftForge.EVENT_BUS.register(new KekeFallEvent());
    }
}