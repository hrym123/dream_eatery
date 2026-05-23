package org.lanye.dream_eatery.bootstrap;

import net.minecraftforge.eventbus.api.IEventBus;
import org.lanye.dream_eatery.bootstrap.block.ModBlocks;
import org.lanye.dream_eatery.bootstrap.blockentity.ModBlockEntities;
import org.lanye.dream_eatery.bootstrap.item.ModCreativeTabs;

public final class ModBootstrap {

    private ModBootstrap() {}

    public static void register(IEventBus modEventBus) {
        ModBlocks.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModCreativeTabs.register(modEventBus);
    }
}
