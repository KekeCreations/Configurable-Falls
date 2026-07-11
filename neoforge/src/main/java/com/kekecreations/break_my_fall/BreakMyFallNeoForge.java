package com.kekecreations.break_my_fall;


import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(BreakMyFall.MOD_ID)
public class BreakMyFallNeoForge {

    public BreakMyFallNeoForge(IEventBus eventBus) {
        BreakMyFall.init();

    }
}