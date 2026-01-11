package com.example;

import com.example.block.RegisterBlock;
import net.fabricmc.api.ModInitializer;

import net.minecraft.registry.Registries;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AutoPlanterMod implements ModInitializer {
    public static final String MODID = "auto_plant";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.
        RegisterBlock.register();
        LOGGER.info("Hello Fabric world!");
    }
}