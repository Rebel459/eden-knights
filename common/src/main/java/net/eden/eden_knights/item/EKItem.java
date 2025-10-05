package net.eden.eden_knights.item;

import banduty.stoneycore.model.CrownModel;
import com.knightsheraldry.items.armor.accessory.KHHelmetAccessory;
import net.eden.eden_knights.EdenKnights;
import net.eden.eden_knights.registry.EKItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

public class EKItem extends KHHelmetAccessory {

    private final boolean openVisor;
    private final Ingredient ingredient;

    public EKItem(Properties settings, boolean openVisor, Ingredient ingredient) {
        super(settings, openVisor, ingredient);
        this.openVisor = openVisor;
        this.ingredient = ingredient;
    }

    @Override
    public ModelBundle getModels(ItemStack itemStack) {
        if (itemStack.is(EKItems.CROWN.get())) {
            return ModelBundle.ofBase(new CrownModel(CrownModel.getTexturedModelData().bakeRoot()));
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
