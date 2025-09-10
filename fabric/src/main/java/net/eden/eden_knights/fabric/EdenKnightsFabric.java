package net.eden.eden_knights.fabric;

import net.eden.eden_knights.EdenKnights;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.network.chat.Component;

import java.util.Optional;

public final class EdenKnightsFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        EdenKnights.init();

        Optional<ModContainer> modContainer = FabricLoader.getInstance().getModContainer(EdenKnights.MOD_ID);

        ResourceManagerHelper.registerBuiltinResourcePack(
                EdenKnights.id("eden_knights"), modContainer.get(),
                Component.literal("Eden Knights Data Overrides"),
                ResourcePackActivationType.ALWAYS_ENABLED
        );
    }
}
