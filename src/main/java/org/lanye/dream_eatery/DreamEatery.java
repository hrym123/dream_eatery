package org.lanye.dream_eatery;

import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

@Mod(DreamEatery.MODID)
public final class DreamEatery {

    public static final String MODID = "dream_eatery";
    private static final Logger LOGGER = LogUtils.getLogger();

    public DreamEatery() {
        LOGGER.info("{} loaded", MODID);
    }
}
