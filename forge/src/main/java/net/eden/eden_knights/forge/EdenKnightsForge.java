package net.eden.eden_knights.forge;

import dev.architectury.platform.forge.EventBuses;
import net.eden.eden_knights.EdenKnights;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraftforge.event.AddPackFindersEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(EdenKnights.MOD_ID)
public final class EdenKnightsForge {
    public EdenKnightsForge() {
        // Submit our event bus to let Architectury API register our content on the right time.
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        EventBuses.registerModEventBus(EdenKnights.MOD_ID, modEventBus);

        // Run our common setup.
        EdenKnights.init();
        modEventBus.addListener(this::addPackFinders);
    }

    public void addPackFinders(AddPackFindersEvent event) {
        if (event.getPackType() == PackType.SERVER_DATA) {
            event.addRepositorySource((packConsumer) -> {
                    packConsumer.accept(
                            Pack.readMetaAndCreate(
                                    "builtin/eden_knights",
                                    Component.literal("Eden Knights Data Overrides"),
                                    true,
                                    (path) -> new PathPackResources(path, ModList.get().getModFileById(EdenKnights.MOD_ID).getFile().findResource("resourcepacks/eden_knights"), true),
                                    PackType.SERVER_DATA, Pack.Position.TOP, PackSource.BUILT_IN)
                    );
            });
        }
    }
}
