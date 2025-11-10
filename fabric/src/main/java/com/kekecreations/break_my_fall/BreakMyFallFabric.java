package com.kekecreations.break_my_fall;

import com.kekecreations.break_my_fall.core.config.BreakMyFallCommonConfig;
import fuzs.forgeconfigapiport.api.config.v2.ForgeConfigRegistry;
import net.fabricmc.api.ModInitializer;
import net.minecraftforge.fml.config.ModConfig;

public class BreakMyFallFabric implements ModInitializer {
    
    @Override
    public void onInitialize() {
        ForgeConfigRegistry.INSTANCE.register(BreakMyFall.MOD_ID, ModConfig.Type.COMMON, BreakMyFallCommonConfig.SPEC, "break-my-fall-common.toml");

        BreakMyFall.init();
    }
}
