package net.eden.eden_knights.mixin.client;

import banduty.stoneycore.client.SCAccessoryItemRenderer;
import com.mojang.blaze3d.vertex.PoseStack;
import io.wispforest.accessories.api.slot.SlotReference;
import net.eden.eden_knights.tag.EKItemTags;
import net.eden.eden_knights.registry.EKItems;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SCAccessoryItemRenderer.class)
public class SCAccessoryItemRendererMixin {

    @Inject(
        method = "render",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/model/HumanoidModel;renderToBuffer(Lcom/mojang/blaze3d/vertex/PoseStack;Lcom/mojang/blaze3d/vertex/VertexConsumer;IIFFFF)V",
            shift = At.Shift.BEFORE
        )
    )
    private <M extends LivingEntity> void EK$offsetAccessoryModels(ItemStack stack, SlotReference reference, PoseStack matrices, EntityModel<M> model, MultiBufferSource multiBufferSource, int light, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, CallbackInfo ci) {
        if (!stack.is(EKItemTags.CONVERTABLE)) return;
        if (stack.is(EKItems.CROWN.get())) {
            matrices.pushPose();
            matrices.translate(0.0f, -0.0625f, 0.0f);
        }
    }

    @Inject(
        method = "render",
        at = @At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/model/HumanoidModel;renderToBuffer(Lcom/mojang/blaze3d/vertex/PoseStack;Lcom/mojang/blaze3d/vertex/VertexConsumer;IIFFFF)V",
            shift = At.Shift.AFTER
        )
    )
    private void EK$updateModelsAfterOffset(ItemStack stack, SlotReference reference, PoseStack matrices, EntityModel<LivingEntity> model, MultiBufferSource multiBufferSource, int light, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, CallbackInfo ci) {
        if (!stack.is(EKItemTags.CONVERTABLE)) return;
        if (stack.is(EKItems.CROWN.get())) {
            matrices.popPose();
        }
    }
}