package net.eden.eden_knights.item;

import banduty.stoneycore.model.CrownModel;
import com.knightsheraldry.items.armor.accessory.KHHelmetAccessory;
import net.eden.eden_knights.EdenKnights;
import net.eden.eden_knights.registry.EKItems;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public class EKItem extends KHHelmetAccessory {

    private final boolean openVisor;

    public EKItem(Properties settings, boolean openVisor) {
        super(settings, openVisor);
        this.openVisor = openVisor;
    }

    @Override
    public HumanoidModel<LivingEntity> getModel(ItemStack itemStack) {
        if (itemStack.is(EKItems.CROWN.get())) {
            return new CrownModel(CrownModel.getTexturedModelData().bakeRoot());
        }
        return null;
    }

    @Override
    public ResourceLocation getTexturePath(ItemStack itemStack) {
        if (itemStack.is(EKItems.CROWN.get())) {
            return new ResourceLocation("stoneycore", "textures/entity/armor/" + this + ".png");
        }
        return new ResourceLocation(EdenKnights.MOD_ID, "textures/entity/armor/" + this + ".png");
    }
}
