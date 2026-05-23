package org.lanye.dream_eatery.bootstrap.block;

import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

/** 厨房方块 {@link BlockBehaviour.Properties} 组合。 */
public final class KitchenBlockProperties {

    private KitchenBlockProperties() {}

    public static BlockBehaviour.Properties ceramicBody(MapColor mapColor) {
        return BlockBehaviour.Properties.of()
                .mapColor(mapColor)
                .strength(1.2f, 6.0f)
                .sound(SoundType.DEEPSLATE_TILES);
    }

    public static BlockBehaviour.Properties kitchenCeramic(MapColor mapColor) {
        return ceramicBody(mapColor).noOcclusion();
    }

    public static BlockBehaviour.Properties metalNoOcclusion() {
        return BlockBehaviour.Properties.of()
                .mapColor(MapColor.METAL)
                .strength(1.5f, 6.0f)
                .sound(SoundType.METAL)
                .noOcclusion();
    }

    public static BlockBehaviour.Properties woodCabinetNoOcclusion() {
        return BlockBehaviour.Properties.of()
                .mapColor(MapColor.WOOD)
                .strength(1.0f, 6.0f)
                .sound(SoundType.WOOD)
                .noOcclusion();
    }
}
