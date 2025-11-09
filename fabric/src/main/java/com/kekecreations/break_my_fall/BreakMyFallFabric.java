package com.kekecreations.break_my_fall;

import com.kekecreations.break_my_fall.core.config.BreakMyFallCommonConfig;
import fuzs.forgeconfigapiport.fabric.api.neoforge.v4.NeoForgeConfigRegistry;
import net.fabricmc.api.ModInitializer;
import net.neoforged.fml.config.ModConfig;

public class BreakMyFallFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        NeoForgeConfigRegistry.INSTANCE.register(BreakMyFall.MOD_ID, ModConfig.Type.COMMON, BreakMyFallCommonConfig.SPEC, "break_my_fall-common.toml");

        BreakMyFall.init();
    }
}
