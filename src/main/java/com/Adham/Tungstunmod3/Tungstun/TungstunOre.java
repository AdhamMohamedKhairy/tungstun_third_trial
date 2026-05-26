package com.Adham.Tungstunmod3.Tungstun;

import com.Adham.Tungstunmod3.Tungstun.custom.HotPotatoItem;
import com.Adham.Tungstunmod3.Tungstun.custom.TungstunArmor;
import com.Adham.Tungstunmod3.Tungstun.custom.TungstunMace;
import com.Adham.Tungstunmod3.Tungstunmod3;
import net.minecraft.world.item.ArmorItem;
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
            ITEMS.register("tungstun", () -> new Item(new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> RawTungstun =
            ITEMS.register("rawtungstun", () -> new Item(new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> Tungstun_Mace =
            ITEMS.register("tungstunmace", () -> new TungstunMace(new Item.Properties().fireResistant().durability(600).attributes(TungstunMace.createAttributes())));

    public static final RegistryObject<Item> TungstunBatatis =
            ITEMS.register("tungstunbatatis", () -> new Item(new Item.Properties().food(TungstunFoodProperties.Tungstun_Batatis).fireResistant()));

    public static final RegistryObject<Item> TUNGSTUN_HELMET =
            ITEMS.register("tungstun_helmet", () -> new ArmorItem(
                    TungstunArmor.TUNGSTUN,
                    ArmorItem.Type.HELMET,
                    new Item.Properties().fireResistant()
            ));

    public static final RegistryObject<Item> TUNGSTUN_CHESTPLATE =
            ITEMS.register("tungstun_chestplate", () -> new ArmorItem(
                    TungstunArmor.TUNGSTUN,
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().fireResistant()
            ));

    public static final RegistryObject<Item> TUNGSTUN_LEGGINGS =
            ITEMS.register("tungstun_leggings", () -> new ArmorItem(
                    TungstunArmor.TUNGSTUN,
                    ArmorItem.Type.LEGGINGS,
                    new Item.Properties().fireResistant()
            ));

    public static final RegistryObject<Item> TUNGSTUN_BOOTS =
            ITEMS.register("tungstun_boots", () -> new ArmorItem(
                    TungstunArmor.TUNGSTUN,
                    ArmorItem.Type.BOOTS,
                    new Item.Properties().fireResistant()
            ));

    public static final RegistryObject<Item> CRY_HELMET =
            ITEMS.register("crystallized_netherite_helmet", () -> new ArmorItem(
                    TungstunArmor.CRYSTALLIZED_NETHERITE,
                    ArmorItem.Type.HELMET,
                    new Item.Properties().fireResistant()
            ));

    public static final RegistryObject<Item> CRY_CHESTPLATE =
            ITEMS.register("crystallized_netherite_chestplate", () -> new ArmorItem(
                    TungstunArmor.CRYSTALLIZED_NETHERITE,
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().fireResistant()
            ));

    public static final RegistryObject<Item> CRY_LEGGINGS =
            ITEMS.register("crystallized_netherite_leggings", () -> new ArmorItem(
                    TungstunArmor.CRYSTALLIZED_NETHERITE,
                    ArmorItem.Type.LEGGINGS,
                    new Item.Properties().fireResistant()
            ));

    public static final RegistryObject<Item> CRY_BOOTS =
            ITEMS.register("crystallized_netherite_boots", () -> new ArmorItem(
                    TungstunArmor.CRYSTALLIZED_NETHERITE,
                    ArmorItem.Type.BOOTS,
                    new Item.Properties().fireResistant()
            ));

    public static final RegistryObject<Item> HOT_POTATO =
            ITEMS.register("hotpotato", () -> new HotPotatoItem(
                    new Item.Properties()
                            .stacksTo(16)
                            .fireResistant()
            ));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
