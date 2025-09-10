package net.eden.eden_knights.mixin.item;

import banduty.stoneycore.items.SCItems;
import net.eden.eden_knights.lib.ItemStackHelper;
import net.eden.eden_knights.registry.EKItemTags;
import net.eden.eden_knights.registry.EKItems;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin {

    @Inject(at = @At("HEAD"), method = "inventoryTick")
    private void EK$convert(Level level, Entity entity, int i, boolean bl, CallbackInfo ci) {
        ItemStack stack = ItemStack.class.cast(this);
        if (!(entity instanceof LivingEntity livingEntity) || !stack.is(EKItemTags.CONVERTABLE)) return;
        ItemStackHelper.convertBoth(livingEntity, stack, EquipmentSlot.HEAD, EKItems.CROWN.get(), SCItems.CROWN.get());
    }
}