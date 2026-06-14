package org.lanye.dream_eatery;

import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.lanye.dream_eatery.bootstrap.ModBootstrap;
import org.lanye.reverie_core.content.fantasy_core.workbench.FantasyWorkbenchCatalogRegistry;
import org.slf4j.Logger;

@Mod(DreamEatery.MODID)
public final class DreamEatery {

    public static final String MODID = "dream_eatery";
    private static final Logger LOGGER = LogUtils.getLogger();

    public DreamEatery(FMLJavaModLoadingContext context) {
        var modEventBus = context.getModEventBus();
        ModBootstrap.register(modEventBus);
        modEventBus.addListener(this::onCommonSetup);
        LOGGER.info("{} loaded", MODID);
    }

    private void onCommonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> FantasyWorkbenchCatalogRegistry.registerContentMod(MODID));
    }
}
