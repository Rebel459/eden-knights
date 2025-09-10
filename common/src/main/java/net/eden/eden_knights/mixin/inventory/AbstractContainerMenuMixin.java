package net.eden.eden_knights.mixin.inventory;

import net.eden.eden_knights.lib.ItemStackHelper;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AbstractContainerMenu.class)
public class AbstractContainerMenuMixin {

    @Shadow private ItemStack carried;

    @Inject(at = @At("TAIL"), method = "setCarried")
    private void inventory(ItemStack stack, CallbackInfo ci) {
        this.carried = ItemStackHelper.convert(stack, false);
    }
}