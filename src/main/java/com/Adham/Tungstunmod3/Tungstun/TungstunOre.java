package com.Adham.Tungstunmod3.Tungstun;

import com.Adham.Tungstunmod3.Tungstun.custom.*;
import com.Adham.Tungstunmod3.Tungstunmod3;
import net.minecraft.world.item.*;
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
                    new Item.Properties().fireResistant().stacksTo(1)
            ));

    public static final RegistryObject<Item> TUNGSTUN_CHESTPLATE =
            ITEMS.register("tungstun_chestplate", () -> new ArmorItem(
                    TungstunArmor.TUNGSTUN,
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().fireResistant().stacksTo(1)
            ));

    public static final RegistryObject<Item> TUNGSTUN_LEGGINGS =
            ITEMS.register("tungstun_leggings", () -> new ArmorItem(
                    TungstunArmor.TUNGSTUN,
                    ArmorItem.Type.LEGGINGS,
                    new Item.Properties().fireResistant().stacksTo(1)
            ));

    public static final RegistryObject<Item> TUNGSTUN_BOOTS =
            ITEMS.register("tungstun_boots", () -> new ArmorItem(
                    TungstunArmor.TUNGSTUN,
                    ArmorItem.Type.BOOTS,
                    new Item.Properties().fireResistant().stacksTo(1)
            ));

    public static final RegistryObject<Item> CRY_HELMET =
            ITEMS.register("crystallized_netherite_helmet", () -> new ArmorItem(
                    TungstunArmor.CRYSTALLIZED_NETHERITE,
                    ArmorItem.Type.HELMET,
                    new Item.Properties().fireResistant().stacksTo(1)
            ));

    public static final RegistryObject<Item> CRY_CHESTPLATE =
            ITEMS.register("crystallized_netherite_chestplate", () -> new ArmorItem(
                    TungstunArmor.CRYSTALLIZED_NETHERITE,
                    ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().fireResistant().stacksTo(1)
            ));

    public static final RegistryObject<Item> CRY_LEGGINGS =
            ITEMS.register("crystallized_netherite_leggings", () -> new ArmorItem(
                    TungstunArmor.CRYSTALLIZED_NETHERITE,
                    ArmorItem.Type.LEGGINGS,
                    new Item.Properties().fireResistant().stacksTo(1)
            ));

    public static final RegistryObject<Item> CRY_BOOTS =
            ITEMS.register("crystallized_netherite_boots", () -> new ArmorItem(
                    TungstunArmor.CRYSTALLIZED_NETHERITE,
                    ArmorItem.Type.BOOTS,
                    new Item.Properties().fireResistant().stacksTo(1)
            ));

    public static final RegistryObject<Item> HOT_POTATO =
            ITEMS.register("hotpotato", () -> new HotPotatoItem(
                    new Item.Properties()
                            .stacksTo(16)
                            .fireResistant()
            ));

    public static final RegistryObject<Item> TUNGSTUN_SWORD =
            ITEMS.register("tungstun_sword", () -> new SwordItem(
                    TungstunTools.TUNGSTUN,
                    new Item.Properties()
                            .fireResistant()
                            .stacksTo(1)
                            .durability(3000)
                            .attributes(SwordItem.createAttributes(TungstunTools.TUNGSTUN, 3, -2.4F))
            ));
    public static final RegistryObject<Item> TUNGSTUN_PICKAXE =
            ITEMS.register("tungstun_pickaxe", () -> new PickaxeItem(
                    TungstunTools.TUNGSTUN,
                    new Item.Properties()
                            .fireResistant()
                            .stacksTo(1)
                            .durability(3000)
                            .attributes(PickaxeItem.createAttributes(TungstunTools.TUNGSTUN, 1, -2.8F))
            ));

    public static final RegistryObject<Item> TUNGSTUN_AXE =
            ITEMS.register("tungstun_axe", () -> new AxeItem(
                    TungstunTools.TUNGSTUN,
                    new Item.Properties()
                            .fireResistant()
                            .stacksTo(1)
                            .durability(3000)
                            .attributes(AxeItem.createAttributes(TungstunTools.TUNGSTUN, 5, -3.0F))
            ));

    public static final RegistryObject<Item> TUNGSTUN_SHOVEL =
            ITEMS.register("tungstun_shovel", () -> new ShovelItem(
                    TungstunTools.TUNGSTUN,
                    new Item.Properties()
                            .fireResistant()
                            .stacksTo(1)
                            .durability(3000)
                            .attributes(ShovelItem.createAttributes(TungstunTools.TUNGSTUN, 1, -3.0F))
            ));

    public static final RegistryObject<Item> TUNGSTUN_HOE =
            ITEMS.register("tungstun_hoe", () -> new HoeItem(
                    TungstunTools.TUNGSTUN,
                    new Item.Properties()
                            .fireResistant()
                            .stacksTo(1)
                            .durability(3000)
                            .attributes(HoeItem.createAttributes(TungstunTools.TUNGSTUN, 3, -2.4F))
            ));

    public static final RegistryObject<Item> CRYSTALLIZED_NETHERITE_SWORD =
            ITEMS.register("crystallized_netherite_sword", () -> new SwordItem(
                    CrystallizedNetheriteTools.CRYSTALLIZED_NETHERITE,
                    new Item.Properties()
                            .fireResistant()
                            .stacksTo(1)
                            .durability(2500)
                            .attributes(SwordItem.createAttributes(CrystallizedNetheriteTools.CRYSTALLIZED_NETHERITE, 3, -2.4F))
            ));
    public static final RegistryObject<Item> CRYSTALLIZED_NETHERITE_PICKAXE =
            ITEMS.register("crystallized_netherite_pickaxe", () -> new PickaxeItem(
                    CrystallizedNetheriteTools.CRYSTALLIZED_NETHERITE,
                    new Item.Properties()
                            .fireResistant()
                            .stacksTo(1)
                            .durability(2500)
                            .attributes(PickaxeItem.createAttributes(CrystallizedNetheriteTools.CRYSTALLIZED_NETHERITE, 1, -2.8F))
            ));

    public static final RegistryObject<Item> CRYSTALLIZED_NETHERITE_AXE =
            ITEMS.register("crystallized_netherite_axe", () -> new AxeItem(
                    CrystallizedNetheriteTools.CRYSTALLIZED_NETHERITE,
                    new Item.Properties()
                            .fireResistant()
                            .stacksTo(1)
                            .durability(2500)
                            .attributes(AxeItem.createAttributes(CrystallizedNetheriteTools.CRYSTALLIZED_NETHERITE, 5, -3.0F))
            ));

    public static final RegistryObject<Item> CRYSTALLIZED_NETHERITE_SHOVEL =
            ITEMS.register("crystallized_netherite_shovel", () -> new ShovelItem(
                    CrystallizedNetheriteTools.CRYSTALLIZED_NETHERITE,
                    new Item.Properties()
                            .fireResistant()
                            .stacksTo(1)
                            .durability(2500)
                            .attributes(ShovelItem.createAttributes(CrystallizedNetheriteTools.CRYSTALLIZED_NETHERITE, 1, -3.0F))
            ));

    public static final RegistryObject<Item> CRYSTALLIZED_NETHERITE_HOE =
            ITEMS.register("crystallized_netherite_hoe", () -> new HoeItem(
                    CrystallizedNetheriteTools.CRYSTALLIZED_NETHERITE,
                    new Item.Properties()
                            .fireResistant()
                            .stacksTo(1)
                            .durability(2500)
                            .attributes(HoeItem.createAttributes(CrystallizedNetheriteTools.CRYSTALLIZED_NETHERITE, 3, -2.4F))
            ));

    public static final RegistryObject<Item> TUNGSTUN_DRILL =
            ITEMS.register("tungstun_drill", () -> new TungstunDrill(
                   TungstunTools.TUNGSTUN, new Item.Properties()
                    .fireResistant().durability(5000)
                    .attributes(PickaxeItem.createAttributes(TungstunTools.TUNGSTUN, 6, -4.0F))
            ));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
