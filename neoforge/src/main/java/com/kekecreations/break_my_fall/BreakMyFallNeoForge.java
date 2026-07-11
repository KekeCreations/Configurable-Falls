package com.kekecreations.break_my_fall;


import com.kekecreations.break_my_fall.core.config.BreakMyFallCommonConfig;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

@Mod(BreakMyFall.MOD_ID)
public class BreakMyFallNeoForge {

    public BreakMyFallNeoForge(IEventBus eventBus, ModContainer modContainer) {
        modContainer.registerConfig(ModConfig.Type.COMMON, BreakMyFallCommonConfig.SPEC);
        BreakMyFall.init();

    }
}