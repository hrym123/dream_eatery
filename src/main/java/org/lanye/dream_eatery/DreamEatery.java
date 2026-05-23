package org.lanye.dream_eatery;

import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.lanye.dream_eatery.bootstrap.ModBootstrap;
import org.slf4j.Logger;

@Mod(DreamEatery.MODID)
public final class DreamEatery {

    public static final String MODID = "dream_eatery";
    private static final Logger LOGGER = LogUtils.getLogger();

    public DreamEatery(FMLJavaModLoadingContext context) {
        ModBootstrap.register(context.getModEventBus());
        LOGGER.info("{} loaded", MODID);
    }
}
