package net.eden.eden_knights.mixin.item;

import net.eden.eden_knights.registry.EKItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Enchantment.class)
public class EnchantmentMixin {

    @Shadow @Final public EnchantmentCategory category;

    @Inject(at = @At("HEAD"), method = "canEnchant", cancellable = true)
    private void inventory(ItemStack itemStack, CallbackInfoReturnable<Boolean> cir) {
        if (itemStack.is(EKItemTags.CONVERTABLE) && this.category == EnchantmentCategory.ARMOR) cir.setReturnValue(true);
        if (itemStack.is(EKItemTags.ENCHANTABLE_HELMET) && this.category == EnchantmentCategory.ARMOR_HEAD) cir.setReturnValue(true);
        if (itemStack.is(EKItemTags.ENCHANTABLE_CHESTPLATE) && this.category == EnchantmentCategory.ARMOR_CHEST) cir.setReturnValue(true);
        if (itemStack.is(EKItemTags.ENCHANTABLE_LEGGINGS) && this.category == EnchantmentCategory.ARMOR_LEGS) cir.setReturnValue(true);
        if (itemStack.is(EKItemTags.ENCHANTABLE_BOOTS) && this.category == EnchantmentCategory.ARMOR_FEET) cir.setReturnValue(true);
    }
}