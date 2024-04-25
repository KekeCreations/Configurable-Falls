package com.kekecreations.configurable_falls.core.platform;

import com.kekecreations.configurable_falls.ConfigurableFalls;
import com.kekecreations.configurable_falls.core.platform.services.RegistryHelper;

import java.util.ServiceLoader;

public class Services {

    public static final RegistryHelper REGISTRY = load(RegistryHelper.class);

    public static <T> T load(Class<T> clazz) {

        final T loadedService = ServiceLoader.load(clazz)
                .findFirst()
                .orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));
        ConfigurableFalls.LOG.debug("Loaded {} for service {}", loadedService, clazz);
        return loadedService;
    }
}
