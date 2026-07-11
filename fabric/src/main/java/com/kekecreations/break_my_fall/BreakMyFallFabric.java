package com.kekecreations.break_my_fall;

import com.kekecreations.break_my_fall.core.config.BreakMyFallCommonConfig;
import fuzs.forgeconfigapiport.fabric.api.v5.ConfigRegistry;
import net.fabricmc.api.ModInitializer;
import net.neoforged.fml.config.ModConfig;

public class BreakMyFallFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        ConfigRegistry.INSTANCE.register(BreakMyFall.MOD_ID, ModConfig.Type.COMMON, BreakMyFallCommonConfig.SPEC, "break_my_fall-common.toml");
        BreakMyFall.init();
    }
}
