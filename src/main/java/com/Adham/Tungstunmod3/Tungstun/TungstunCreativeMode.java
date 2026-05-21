package com.Adham.Tungstunmod3.Tungstun;

import com.Adham.Tungstunmod3.TungstunBlocks.TungstunBlock;
import com.Adham.Tungstunmod3.Tungstunmod3;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.Adham.Tungstunmod3.TungstunBlocks.TungstunBlock.TungstunBlocko;
import static com.Adham.Tungstunmod3.TungstunBlocks.TungstunBlock.TungstunOree;

public class TungstunCreativeMode {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Tungstunmod3.MOD_ID);

    public static final RegistryObject<CreativeModeTab> TUNGSTUN_TAB =
            CREATIVE_MODE_TABS.register("tungstun_tab", () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(TungstunOre.Tungstun.get()))
                    .title(Component.translatable("creativetab.tungstunmod.tungstun_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(TungstunOre.Tungstun.get());
                        output.accept(TungstunOre.RawTungstun.get());
                        output.accept(TungstunOre.Tungstun_Mace.get());
                        output.accept(TungstunBlocko.get());
                        output.accept(TungstunOree.get());
                    }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
