package net.eden.eden_knights.mixin.item;

import net.eden.eden_knights.EdenKnights;
import net.eden.eden_knights.tag.EKItemTags;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(Item.class)
public abstract class ItemMixin {

    @Shadow
    public abstract ItemStack getDefaultInstance();

    @Inject(method = "appendHoverText", at = @At(value = "HEAD"))
    private void addDescription(ItemStack itemStack, Level level, List<Component> list, TooltipFlag tooltipFlag, CallbackInfo ci) {
        if (!this.getDefaultInstance().is(EKItemTags.HAS_DESCRIPTION)) return;
        MutableComponent descriptionText = Component.translatable(this.getDefaultInstance().getDescriptionId() + ".desc").withStyle(ChatFormatting.DARK_GRAY);
        if (Screen.hasShiftDown()) {
            list.add(Component.literal("").append(descriptionText));
        }
        else {
            list.add(Component.translatable("tooltip." + EdenKnights.MOD_ID + ".hold_shift").withStyle(ChatFormatting.DARK_GRAY));
        }
    }
}