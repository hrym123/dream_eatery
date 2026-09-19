package org.lanye.dream_eatery.bootstrap.block;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.lanye.dream_eatery.DreamEatery;
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

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, DreamEatery.MODID);
    public static final DeferredRegister<Item> BLOCK_ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DreamEatery.MODID);

    public static final AnimatedBlockEntry<MixingBowlBlockEntity> MIXING_BOWL = KitchenAnimatedBlocks.MIXING_BOWL;
    public static final AnimatedBlockEntry<JamPotBlockEntity> JAM_POT = KitchenAnimatedBlocks.JAM_POT;
    public static final AnimatedBlockEntry<OvenBlockEntity> OVEN = KitchenAnimatedBlocks.OVEN;
    public static final AnimatedBlockEntry<PestleBowlBlockEntity> PESTLE_BOWL = KitchenAnimatedBlocks.PESTLE_BOWL;
    public static final AnimatedBlockEntry<HalfHalfPotBlockEntity> HALF_HALF_POT = KitchenAnimatedBlocks.HALF_HALF_POT;
    public static final AnimatedBlockEntry<KitchenCounterCabinetBlockEntity> KITCHEN_COUNTER_CABINET =
            KitchenAnimatedBlocks.KITCHEN_COUNTER_CABINET;
    public static final AnimatedBlockEntry<KitchenCounterBlockEntity> KITCHEN_COUNTER =
            KitchenAnimatedBlocks.KITCHEN_COUNTER;

    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
        BLOCK_ITEMS.register(modEventBus);
    }
}
