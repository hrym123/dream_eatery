package org.lanye.dream_eatery.content.kitchen;

import net.minecraft.resources.ResourceLocation;
import org.lanye.dream_eatery.DreamEatery;

public final class BarMaterials {

    private BarMaterials() {}

    public static ResourceLocation sharedTexture(BarMaterialVariant variant) {
        return ResourceLocation.fromNamespaceAndPath(
                DreamEatery.MODID, "textures/block/" + variant.textureStem() + ".png");
    }
}
