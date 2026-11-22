package org.lanye.dream_eatery.bootstrap;

import org.lanye.dream_eatery.bootstrap.block.ModBlocks;
import org.lanye.dream_eatery.bootstrap.blockentity.ModBlockEntities;
import org.lanye.dream_eatery.bootstrap.item.ModCreativeTabs;
import org.lanye.reverie_core.loader.ModBus;

public final class ModBootstrap {

    private ModBootstrap() {}

    public static void register(ModBus modEventBus) {
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModCreativeTabs.register(modEventBus);
    }
}
