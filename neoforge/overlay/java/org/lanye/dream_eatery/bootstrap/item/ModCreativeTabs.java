package org.lanye.dream_eatery.bootstrap.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import org.lanye.dream_eatery.DreamEatery;
import org.lanye.dream_eatery.bootstrap.block.ModBlocks;
import org.lanye.reverie_core.loader.ModBus;
import org.lanye.reverie_core.loader.ModRegistry;
import org.lanye.reverie_core.loader.RegistryRef;

public final class ModCreativeTabs {

    private ModCreativeTabs() {}

    public static final ModRegistry<CreativeModeTab> CREATIVE_MODE_TABS =
            ModRegistry.creativeTabs(DreamEatery.MODID);

    public static final RegistryRef<CreativeModeTab> MAIN =
            CREATIVE_MODE_TABS.register("main", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.dream_eatery.main"))
                    .icon(() -> new ItemStack(ModBlocks.MIXING_BOWL.item().get()))
                    .withTabsBefore(CreativeModeTabs.SPAWN_EGGS)
                    .displayItems((params, output) -> {
                        output.accept(ModBlocks.MIXING_BOWL.item().get());
                        output.accept(ModBlocks.JAM_POT.item().get());
                        output.accept(ModBlocks.OVEN.item().get());
                        output.accept(ModBlocks.PESTLE_BOWL.item().get());
                        output.accept(ModBlocks.HALF_HALF_POT.item().get());
                        output.accept(ModBlocks.KITCHEN_COUNTER.item().get());
                        output.accept(ModBlocks.KITCHEN_COUNTER_CABINET.item().get());
                    })
                    .build());

    public static void register(ModBus modEventBus) {
        CREATIVE_MODE_TABS.attach(modEventBus);
    }
}
