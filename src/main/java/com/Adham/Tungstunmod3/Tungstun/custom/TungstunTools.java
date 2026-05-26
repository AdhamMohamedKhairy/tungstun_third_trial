package com.Adham.Tungstunmod3.Tungstun.custom;

import com.Adham.Tungstunmod3.Tungstun.TungstunOre;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

public enum TungstunTools implements Tier {
    TUNGSTUN;

    @Override
    public int getUses() {
        return 3000;
    }

    @Override
    public float getSpeed() {
        return 11.0F;
    }

    @Override
    public float getAttackDamageBonus() {
        return 6.0F;
    }

    @Override
    public TagKey<Block> getIncorrectBlocksForDrops() {
        return BlockTags.create(
                ResourceLocation.fromNamespaceAndPath(
                        "tungstunmod", "incorrect_for_tungstun_tool"
                )
        );
    }

    @Override
    public int getEnchantmentValue() {
        return 15;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.of(TungstunOre.Tungstun.get());
    }

}
