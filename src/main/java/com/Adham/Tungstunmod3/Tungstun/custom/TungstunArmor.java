package com.Adham.Tungstunmod3.Tungstun.custom;

import com.Adham.Tungstunmod3.Tungstun.TungstunOre;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class TungstunArmor {
    public static final Holder<ArmorMaterial> TUNGSTUN = Registry.registerForHolder(
            BuiltInRegistries.ARMOR_MATERIAL,
            ResourceLocation.fromNamespaceAndPath("tungstunmod", "tungsten"),
            new ArmorMaterial(
                    new EnumMap<>(Map.of(
                            ArmorItem.Type.HELMET, 7,
                            ArmorItem.Type.CHESTPLATE, 18,
                            ArmorItem.Type.LEGGINGS, 13,
                            ArmorItem.Type.BOOTS, 6
                    )),
                    15,
                    SoundEvents.ARMOR_EQUIP_NETHERITE,
                    () -> Ingredient.of(TungstunOre.Tungstun.get()),
                    List.of(new ArmorMaterial.Layer(
                            ResourceLocation.fromNamespaceAndPath("tungstunmod", "tungstun")
                    )),
                    5.0f,
                    0.7f
            )
    );

    public static final Holder<ArmorMaterial> CRYSTALLIZED_NETHERITE = Registry.registerForHolder(
            BuiltInRegistries.ARMOR_MATERIAL,
            ResourceLocation.fromNamespaceAndPath("tungstunmod", "crystallized_netherite"),
            new ArmorMaterial(
                    new EnumMap<>(Map.of(
                            ArmorItem.Type.HELMET, 3,
                            ArmorItem.Type.CHESTPLATE, 8,
                            ArmorItem.Type.LEGGINGS, 6,
                            ArmorItem.Type.BOOTS, 3
                    )),
                    15,
                    SoundEvents.ARMOR_EQUIP_NETHERITE,
                    () -> Ingredient.of(TungstunOre.Tungstun.get()),
                    List.of(new ArmorMaterial.Layer(
                            ResourceLocation.fromNamespaceAndPath("tungstunmod", "crystallized_netherite")
                    )),
                    3.0f,
                    0.1f
            )
    );
}