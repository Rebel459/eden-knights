package net.eden.eden_knights.registry;

import banduty.stoneycore.client.SCAccessoryItemRenderer;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.eden.eden_knights.EdenKnights;
import net.eden.eden_knights.item.EKItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.function.Supplier;

public final class EKItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(EdenKnights.MOD_ID, Registries.ITEM);

    public static final RegistrySupplier<Item> CROWN = register(
            "crown",
            () ->  new EKItem(
                    new Item.Properties()
                            .durability(256),
                    false,
                    Ingredient.of(Items.GOLD_INGOT))
            );

    public static void init() {
        ITEMS.register();
    }

    public static RegistrySupplier<Item> register(String path, Supplier<Item> itemSupplier) {
        return ITEMS.register(
                path,
                () -> {
                    Item item = itemSupplier.get();
                    new Item.Properties();
                    return item;
                }
        );
    }
}
