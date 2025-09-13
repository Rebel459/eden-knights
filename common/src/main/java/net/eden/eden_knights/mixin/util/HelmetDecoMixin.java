package net.eden.eden_knights.mixin.util;

import com.knightsheraldry.util.itemdata.HelmetDeco;
import net.eden.eden_knights.registry.EKItems;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashMap;
import java.util.Map;

@Mixin(HelmetDeco.class)
public abstract class HelmetDecoMixin {

    @Mutable
    @Final
    @Shadow
    public static Map<Item, HelmetDeco> HELMET_DECO;

    @Inject(method = "<clinit>", at = @At("TAIL"))
    private static void extendHelmetDecoMap(CallbackInfo ci) {
        Map<Item, HelmetDeco> mutableCopy = new HashMap<>(HELMET_DECO);
        mutableCopy.put(EKItems.CROWN.get(), new HelmetDeco(EKItems.CROWN.get(), 0, 1));
        HELMET_DECO = Map.copyOf(mutableCopy);
    }
}