package org.lanye.dream_eatery.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lanye.dream_eatery.DreamEatery;
import org.lanye.dream_eatery.bootstrap.block.ModBlocks;
import org.lanye.dream_eatery.content.kitchen.blockentity.BarCounterBlockEntity;
import org.lanye.dream_eatery.content.kitchen.blockentity.CornerBarBlockEntity;
import org.lanye.reverie_core.geolib.client.AnimatedBlockClientRegistration;
import org.lanye.reverie_core.geolib.client.GeolibAnimatedBlockRenderers;

@Mod.EventBusSubscriber(modid = DreamEatery.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ClientModEvents {

    private ClientModEvents() {}

    static {
        AnimatedBlockClientRegistration.registerBlockEntityRenderer(
                ModBlocks.MIXING_BOWL,
                GeolibAnimatedBlockRenderers.defaultGeoRendererProvider(DreamEatery.MODID, "mixing_bowl"));
        AnimatedBlockClientRegistration.registerBlockEntityRenderer(
                ModBlocks.JAM_POT,
                GeolibAnimatedBlockRenderers.defaultGeoRendererProvider(DreamEatery.MODID, "jam_pot"));
        AnimatedBlockClientRegistration.registerBlockEntityRenderer(
                ModBlocks.OVEN,
                GeolibAnimatedBlockRenderers.defaultGeoRendererProvider(DreamEatery.MODID, "oven"));
        AnimatedBlockClientRegistration.registerBlockEntityRenderer(
                ModBlocks.PESTLE_BOWL,
                GeolibAnimatedBlockRenderers.defaultGeoRendererProvider(DreamEatery.MODID, "pestle_bowl"));
        AnimatedBlockClientRegistration.registerBlockEntityRenderer(
                ModBlocks.HALF_HALF_POT,
                GeolibAnimatedBlockRenderers.defaultGeoRendererProvider(DreamEatery.MODID, "half_half_pot"));
        AnimatedBlockClientRegistration.registerBlockEntityRenderer(
                ModBlocks.KITCHEN_COUNTER_CABINET,
                GeolibAnimatedBlockRenderers.defaultGeoRendererProvider(
                        DreamEatery.MODID, "kitchen_counter_cabinet"));
        AnimatedBlockClientRegistration.registerBlockEntityRenderer(
                ModBlocks.KITCHEN_COUNTER,
                GeolibAnimatedBlockRenderers.defaultGeoRendererProvider(DreamEatery.MODID, "kitchen_counter"));
        AnimatedBlockClientRegistration.registerBlockEntityRenderer(
                ModBlocks.BAR_COUNTER,
                GeolibAnimatedBlockRenderers.variableTextureGeoRendererProvider(
                        DreamEatery.MODID, "bar_counter", BarCounterBlockEntity::getTextureLocation));
        AnimatedBlockClientRegistration.registerBlockEntityRenderer(
                ModBlocks.CORNER_BAR,
                GeolibAnimatedBlockRenderers.variableTextureGeoRendererProvider(
                        DreamEatery.MODID, "corner_bar", CornerBarBlockEntity::getTextureLocation));
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        AnimatedBlockClientRegistration.registerAllRenderers(event);
    }
}
