package org.lanye.dream_eatery.bootstrap.block;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import org.lanye.dream_eatery.DreamEatery;
import org.lanye.dream_eatery.content.kitchen.block.BarCounterBlock;
import org.lanye.dream_eatery.content.kitchen.block.CornerBarBlock;
import org.lanye.dream_eatery.content.kitchen.block.HalfHalfPotBlock;
import org.lanye.dream_eatery.content.kitchen.block.JamPotBlock;
import org.lanye.dream_eatery.content.kitchen.block.KitchenCounterBlock;
import org.lanye.dream_eatery.content.kitchen.block.KitchenCounterCabinetBlock;
import org.lanye.dream_eatery.content.kitchen.block.MixingBowlBlock;
import org.lanye.dream_eatery.content.kitchen.block.OvenBlock;
import org.lanye.dream_eatery.content.kitchen.block.PestleBowlBlock;
import org.lanye.dream_eatery.content.kitchen.blockentity.BarCounterBlockEntity;
import org.lanye.dream_eatery.content.kitchen.blockentity.CornerBarBlockEntity;
import org.lanye.dream_eatery.content.kitchen.blockentity.HalfHalfPotBlockEntity;
import org.lanye.dream_eatery.content.kitchen.blockentity.JamPotBlockEntity;
import org.lanye.dream_eatery.content.kitchen.blockentity.KitchenCounterBlockEntity;
import org.lanye.dream_eatery.content.kitchen.blockentity.KitchenCounterCabinetBlockEntity;
import org.lanye.dream_eatery.content.kitchen.blockentity.MixingBowlBlockEntity;
import org.lanye.dream_eatery.content.kitchen.blockentity.OvenBlockEntity;
import org.lanye.dream_eatery.content.kitchen.blockentity.PestleBowlBlockEntity;
import org.lanye.dream_eatery.bootstrap.blockentity.ModBlockEntities;
import org.lanye.reverie_core.geolib.AnimatedBlockEntry;
import org.lanye.reverie_core.geolib.AnimatedBlockRegistration;
import org.lanye.reverie_core.geolib.AnimatedBlockSpec;
import org.lanye.reverie_core.geolib.GeolibBlockItem;
import org.lanye.reverie_core.geolib.GeolibItemAssets;

public final class KitchenAnimatedBlocks {

    private KitchenAnimatedBlocks() {}

    private static BiFunction<Block, Item.Properties, Item> defaultGeolibBlockItem(String assetBasename) {
        return (block, p) ->
                new GeolibBlockItem(block, p, GeolibItemAssets.blockAsset(DreamEatery.MODID, assetBasename));
    }

    private static <BE extends BlockEntity> AnimatedBlockSpec<BE> defaultAnimatedSpec(
            String id,
            Supplier<BlockBehaviour.Properties> propertiesSupplier,
            Function<BlockBehaviour.Properties, ? extends Block> blockFactory,
            BlockEntityType.BlockEntitySupplier<BE> beFactory) {
        return AnimatedBlockRegistration.spec(
                id, propertiesSupplier, blockFactory, beFactory, defaultGeolibBlockItem(id));
    }

    private static final List<AnimatedBlockEntry<?>> ENTRIES =
            AnimatedBlockRegistration.registerSpecs(
                    ModBlocks.BLOCKS,
                    ModBlocks.BLOCK_ITEMS,
                    ModBlockEntities.BLOCK_ENTITY_TYPES,
                    List.of(
                            defaultAnimatedSpec(
                                    "mixing_bowl",
                                    () -> KitchenBlockProperties.kitchenCeramic(MapColor.TERRACOTTA_WHITE),
                                    MixingBowlBlock::new,
                                    MixingBowlBlockEntity::new),
                            defaultAnimatedSpec(
                                    "jam_pot",
                                    () -> KitchenBlockProperties.kitchenCeramic(MapColor.COLOR_RED),
                                    JamPotBlock::new,
                                    JamPotBlockEntity::new),
                            defaultAnimatedSpec(
                                    "oven",
                                    KitchenBlockProperties::metalNoOcclusion,
                                    OvenBlock::new,
                                    OvenBlockEntity::new),
                            defaultAnimatedSpec(
                                    "pestle_bowl",
                                    () -> KitchenBlockProperties.kitchenCeramic(MapColor.TERRACOTTA_WHITE),
                                    PestleBowlBlock::new,
                                    PestleBowlBlockEntity::new),
                            defaultAnimatedSpec(
                                    "half_half_pot",
                                    () -> KitchenBlockProperties.kitchenCeramic(MapColor.TERRACOTTA_WHITE),
                                    HalfHalfPotBlock::new,
                                    HalfHalfPotBlockEntity::new),
                            defaultAnimatedSpec(
                                    "kitchen_counter_cabinet",
                                    KitchenBlockProperties::woodCabinetNoOcclusion,
                                    KitchenCounterCabinetBlock::new,
                                    KitchenCounterCabinetBlockEntity::new),
                            defaultAnimatedSpec(
                                    "kitchen_counter",
                                    KitchenBlockProperties::woodCabinetNoOcclusion,
                                    KitchenCounterBlock::new,
                                    KitchenCounterBlockEntity::new),
                            defaultAnimatedSpec(
                                    "bar_counter",
                                    KitchenBlockProperties::woodCabinetNoOcclusion,
                                    BarCounterBlock::new,
                                    BarCounterBlockEntity::new),
                            defaultAnimatedSpec(
                                    "corner_bar",
                                    KitchenBlockProperties::woodCabinetNoOcclusion,
                                    CornerBarBlock::new,
                                    CornerBarBlockEntity::new)));

    private static final int I_MIXING_BOWL = 0;
    private static final int I_JAM_POT = 1;
    private static final int I_OVEN = 2;
    private static final int I_PESTLE_BOWL = 3;
    private static final int I_HALF_HALF_POT = 4;
    private static final int I_KITCHEN_COUNTER_CABINET = 5;
    private static final int I_KITCHEN_COUNTER = 6;
    private static final int I_BAR_COUNTER = 7;
    private static final int I_CORNER_BAR = 8;

    @SuppressWarnings("unchecked")
    private static <BE extends BlockEntity> AnimatedBlockEntry<BE> animatedEntry(int index) {
        return (AnimatedBlockEntry<BE>) ENTRIES.get(index);
    }

    public static final AnimatedBlockEntry<MixingBowlBlockEntity> MIXING_BOWL = animatedEntry(I_MIXING_BOWL);
    public static final AnimatedBlockEntry<JamPotBlockEntity> JAM_POT = animatedEntry(I_JAM_POT);
    public static final AnimatedBlockEntry<OvenBlockEntity> OVEN = animatedEntry(I_OVEN);
    public static final AnimatedBlockEntry<PestleBowlBlockEntity> PESTLE_BOWL = animatedEntry(I_PESTLE_BOWL);
    public static final AnimatedBlockEntry<HalfHalfPotBlockEntity> HALF_HALF_POT = animatedEntry(I_HALF_HALF_POT);
    public static final AnimatedBlockEntry<KitchenCounterCabinetBlockEntity> KITCHEN_COUNTER_CABINET =
            animatedEntry(I_KITCHEN_COUNTER_CABINET);
    public static final AnimatedBlockEntry<KitchenCounterBlockEntity> KITCHEN_COUNTER =
            animatedEntry(I_KITCHEN_COUNTER);
    public static final AnimatedBlockEntry<BarCounterBlockEntity> BAR_COUNTER = animatedEntry(I_BAR_COUNTER);
    public static final AnimatedBlockEntry<CornerBarBlockEntity> CORNER_BAR = animatedEntry(I_CORNER_BAR);
}
