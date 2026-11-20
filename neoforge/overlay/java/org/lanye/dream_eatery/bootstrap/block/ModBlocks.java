package org.lanye.dream_eatery.bootstrap.block;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.lanye.dream_eatery.DreamEatery;
import org.lanye.reverie_core.loader.ModBus;
import org.lanye.reverie_core.loader.ModRegistry;
import org.lanye.dream_eatery.content.kitchen.blockentity.HalfHalfPotBlockEntity;
import org.lanye.dream_eatery.content.kitchen.blockentity.JamPotBlockEntity;
import org.lanye.dream_eatery.content.kitchen.blockentity.KitchenCounterBlockEntity;
import org.lanye.dream_eatery.content.kitchen.blockentity.KitchenCounterCabinetBlockEntity;
import org.lanye.dream_eatery.content.kitchen.blockentity.MixingBowlBlockEntity;
import org.lanye.dream_eatery.content.kitchen.blockentity.OvenBlockEntity;
import org.lanye.dream_eatery.content.kitchen.blockentity.PestleBowlBlockEntity;
import org.lanye.reverie_core.geolib.AnimatedBlockEntry;

public final class ModBlocks {

    private ModBlocks() {}

    public static final ModRegistry<Block> BLOCKS = ModRegistry.blocks(DreamEatery.MODID);
    public static final ModRegistry<Item> BLOCK_ITEMS = ModRegistry.items(DreamEatery.MODID);

    public static final AnimatedBlockEntry<MixingBowlBlockEntity> MIXING_BOWL = KitchenAnimatedBlocks.MIXING_BOWL;
    public static final AnimatedBlockEntry<JamPotBlockEntity> JAM_POT = KitchenAnimatedBlocks.JAM_POT;
    public static final AnimatedBlockEntry<OvenBlockEntity> OVEN = KitchenAnimatedBlocks.OVEN;
    public static final AnimatedBlockEntry<PestleBowlBlockEntity> PESTLE_BOWL = KitchenAnimatedBlocks.PESTLE_BOWL;
    public static final AnimatedBlockEntry<HalfHalfPotBlockEntity> HALF_HALF_POT = KitchenAnimatedBlocks.HALF_HALF_POT;
    public static final AnimatedBlockEntry<KitchenCounterCabinetBlockEntity> KITCHEN_COUNTER_CABINET =
            KitchenAnimatedBlocks.KITCHEN_COUNTER_CABINET;
    public static final AnimatedBlockEntry<KitchenCounterBlockEntity> KITCHEN_COUNTER =
            KitchenAnimatedBlocks.KITCHEN_COUNTER;

    public static void register(ModBus modEventBus) {
        BLOCKS.attach(modEventBus);
        BLOCK_ITEMS.attach(modEventBus);
    }
}
