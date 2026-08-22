package org.lanye.dream_eatery.bootstrap.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.lanye.dream_eatery.DreamEatery;
import org.lanye.dream_eatery.bootstrap.block.ModBlocks;

public final class ModCreativeTabs {

    private ModCreativeTabs() {}

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DreamEatery.MODID);

    public static final RegistryObject<CreativeModeTab> MAIN =
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
                        output.accept(ModBlocks.BAR_COUNTER.item().get());
                        output.accept(ModBlocks.CORNER_BAR.item().get());
                    })
                    .build());

    public static void register(IEventBus modEventBus) {
        CREATIVE_MODE_TABS.register(modEventBus);
    }
}
