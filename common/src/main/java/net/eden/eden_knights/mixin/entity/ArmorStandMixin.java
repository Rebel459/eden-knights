package net.eden.eden_knights.mixin.entity;

import net.eden.eden_knights.lib.ItemStackHelper;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ArmorStand.class)
public abstract class ArmorStandMixin {

    @ModifyVariable(
            method = "setItemSlot(Lnet/minecraft/world/entity/EquipmentSlot;Lnet/minecraft/world/item/ItemStack;)V",
            at = @At("HEAD"),
            argsOnly = true,
            index = 2
    )
    private ItemStack modifyItemStack(ItemStack stack) {
        return ItemStackHelper.convert(stack, true);
    }
}