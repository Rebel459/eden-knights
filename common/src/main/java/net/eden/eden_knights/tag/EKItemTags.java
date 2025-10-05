package net.eden.eden_knights.tag;

import net.eden.eden_knights.EdenKnights;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.NotNull;

public class EKItemTags {
    public static final TagKey<Item> CONVERTABLE = bind("convertable");
    public static final TagKey<Item> HAS_DESCRIPTION = bind("has_description");

    public static final TagKey<Item> ENCHANTABLE_HELMET = bind("enchantable/helmet");
    public static final TagKey<Item> ENCHANTABLE_CHESTPLATE = bind("enchantable/chestplate");
    public static final TagKey<Item> ENCHANTABLE_LEGGINGS = bind("enchantable/leggings");
    public static final TagKey<Item> ENCHANTABLE_BOOTS = bind("enchantable/boots");

    public static final TagKey<Item> CROWNS = bind("crowns");

    @NotNull
    private static TagKey<Item> bind(@NotNull String path) {
        return TagKey.create(Registries.ITEM, EdenKnights.id(path));
    }
}