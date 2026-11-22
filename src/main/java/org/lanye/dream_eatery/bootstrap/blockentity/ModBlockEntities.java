package org.lanye.dream_eatery.bootstrap.blockentity;

import net.minecraft.world.level.block.entity.BlockEntityType;
import org.lanye.dream_eatery.DreamEatery;
import org.lanye.reverie_core.loader.ModBus;
import org.lanye.reverie_core.loader.ModRegistry;

public final class ModBlockEntities {

    private ModBlockEntities() {}

    public static final ModRegistry<BlockEntityType<?>> BLOCK_ENTITY_TYPES =
            ModRegistry.blockEntities(DreamEatery.MODID);

    public static void register(ModBus modEventBus) {
        BLOCK_ENTITY_TYPES.attach(modEventBus);
    }
}
