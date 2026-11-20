package org.lanye.dream_eatery;

import com.mojang.logging.LogUtils;
import org.lanye.dream_eatery.bootstrap.ModBootstrap;
import org.lanye.reverie_core.content.fantasy_core.workbench.FantasyWorkbenchCatalogRegistry;
import org.lanye.reverie_core.loader.Env;
import org.lanye.reverie_core.loader.ModBus;
import org.lanye.reverie_core.loader.ReverieMod;
import org.slf4j.Logger;

@ReverieMod(DreamEatery.MODID)
public final class DreamEatery {

    public static final String MODID = "dream_eatery";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static void init(ModBus bus) {
        ModBootstrap.register(bus);
        bus.onCommonSetup(() -> FantasyWorkbenchCatalogRegistry.registerContentMod(MODID));
        if (Env.isClient()) {
            org.lanye.dream_eatery.client.ClientModEvents.register(bus);
        }
        LOGGER.info("{} loaded", MODID);
    }
}
