package net.eden.eden_knights.mixin.client;

import net.eden.eden_knights.lib.TooltipWrapper;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipPositioner;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(GuiGraphics.class)
public abstract class GuiGraphicsMixin {

    @Shadow
    public abstract int guiWidth();

    @Shadow public abstract int guiHeight();

    @Unique
    Font font;

    List<ClientTooltipComponent> list;

    int i;

    ClientTooltipPositioner clientTooltipPositioner;



    @Inject(method = "renderTooltipInternal", at = @At("HEAD"))
    private void getInternalTooltip(Font font, List<ClientTooltipComponent> list, int i, int j, ClientTooltipPositioner clientTooltipPositioner, CallbackInfo ci) {
        this.font = font;
        this.list = list;
        this.i = i;
        this.clientTooltipPositioner = clientTooltipPositioner;
    }

    @ModifyVariable(
            method = "renderTooltipInternal(Lnet/minecraft/client/gui/Font;Ljava/util/List;IILnet/minecraft/client/gui/screens/inventory/tooltip/ClientTooltipPositioner;)V",
            at = @At("HEAD"),
            argsOnly = true
    )
    private List<ClientTooltipComponent> wrapInternalTooltip(List<ClientTooltipComponent> list) {
        return TooltipWrapper.wrapComponents(this.list, this.font, this.guiWidth(), this.guiHeight(), this.i, this.clientTooltipPositioner);
    }
}