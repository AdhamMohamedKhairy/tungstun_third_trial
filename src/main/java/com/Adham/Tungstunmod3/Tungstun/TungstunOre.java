package com.Adham.Tungstunmod3.Tungstun;

import com.Adham.Tungstunmod3.Tungstunmod3;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TungstunOre {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Tungstunmod3.MOD_ID);

    // Most of the time ---> public static final

    public static final RegistryObject<Item> Tungstun =
            ITEMS.register("tungstun", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RawTungstun =
            ITEMS.register("rawtungstun", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
