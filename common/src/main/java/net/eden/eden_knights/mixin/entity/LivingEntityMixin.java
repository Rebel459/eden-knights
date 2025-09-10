package net.eden.eden_knights.mixin.entity;

import net.eden.eden_knights.registry.EKItems;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Inject(at = @At("HEAD"), method = "getEquipmentSlotForItem", cancellable = true)
    private static void equippable(ItemStack stack, CallbackInfoReturnable<EquipmentSlot> cir) {
        if (stack.is(EKItems.CROWN.get())) cir.setReturnValue(EquipmentSlot.HEAD);
    }
}