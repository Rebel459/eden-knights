package net.eden.eden_knights;

import banduty.stoneycore.StoneyCore;
import banduty.stoneycore.StoneyCoreClient;
import banduty.stoneycore.client.SCAccessoryItemRenderer;
import net.eden.eden_knights.registry.EKItems;
import net.minecraft.resources.ResourceLocation;

public class EdenKnights {
    public static final String MOD_ID = "eden_knights";
    public static ResourceLocation id(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    public static boolean disableConverting = false;

    public static void init() {

        EKItems.init();
    }
}