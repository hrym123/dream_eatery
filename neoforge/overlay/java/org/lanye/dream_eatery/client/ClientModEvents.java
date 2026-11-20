package org.lanye.dream_eatery.client;

import org.lanye.dream_eatery.DreamEatery;
import org.lanye.dream_eatery.bootstrap.block.ModBlocks;
import org.lanye.reverie_core.geolib.client.AnimatedBlockClientRegistration;
import org.lanye.reverie_core.geolib.client.GeolibAnimatedBlockRenderers;
import org.lanye.reverie_core.loader.ClientHooks;
import org.lanye.reverie_core.loader.ModBus;
import org.lanye.reverie_core.loader.OnlyIn;
import org.lanye.reverie_core.loader.Dist;

@OnlyIn(Dist.CLIENT)
public final class ClientModEvents {

    private ClientModEvents() {}

    public static void register(ModBus bus) {
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
        ClientHooks.onEntityRenderers(bus, sink -> {});
    }
}
