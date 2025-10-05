package net.eden.eden_knights.lib;

import banduty.stoneycore.items.SCItems;
import net.eden.eden_knights.EdenKnights;
import net.eden.eden_knights.registry.EKItems;
import net.eden.eden_knights.tag.EKItemTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;

public class ItemStackHelper {
    public static ItemStack convert(ItemStack stack, Item item) {
        ItemStack original = stack.copyAndClear();
        ItemStack newStack = item.getDefaultInstance();
        EnchantmentHelper.setEnchantments(EnchantmentHelper.getEnchantments(original), newStack);
        newStack.setDamageValue(original.getDamageValue());
        newStack.setRepairCost(original.getBaseRepairCost());
        return newStack;
    }

    public static ItemStack convert(ItemStack stack, boolean convertTo) {
        if (stack.is(EKItemTags.CONVERTABLE) && !EdenKnights.disableConverting) {
            Item crown;
            Item crown2;
            if (convertTo) {
                crown = EKItems.CROWN.get();
                crown2 = SCItems.CROWN.get();
            } else {
                crown = SCItems.CROWN.get();
                crown2 = EKItems.CROWN.get();
            }

            return stack.is(crown) ? convert(stack, crown2) : stack;
        } else {
            return stack;
        }
    }

    public static void inventoryConvert(LivingEntity livingEntity, ItemStack stack) {
        if (livingEntity instanceof Player player) {
            for(int x = 0; x < player.getInventory().items.size(); ++x) {
                if (player.getInventory().items.get(x) == stack) {
                    player.getInventory().items.set(x, convert(stack, false));
                }
            }

            if (player.getOffhandItem() == stack) {
                livingEntity.setItemSlot(EquipmentSlot.OFFHAND, convert(stack, false));
            }
        }

    }

    public static void convertBoth(LivingEntity livingEntity, ItemStack stack, EquipmentSlot slot, Item item, Item item2) {
        if (stack.is(item) || stack.is(item2)) {
            if (stack.is(item) && livingEntity.getItemBySlot(slot) == stack) {
                livingEntity.setItemSlot(slot, convert(stack, true));
            } else if (stack.is(item2)) {
                inventoryConvert(livingEntity, stack);
            }

        }
    }
}