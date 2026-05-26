package com.Adham.Tungstunmod3.Tungstun.custom;

import com.Adham.Tungstunmod3.Tungstun.TungstunOre;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

public enum CrystallizedNetheriteTools implements Tier {
    CRYSTALLIZED_NETHERITE;

    @Override
    public int getUses() {
        return 2500;
    }

    @Override
    public float getSpeed() {
        return 9.0F;
    }

    @Override
    public float getAttackDamageBonus() {
        return 4.0F;
    }

    @Override
    public TagKey<Block> getIncorrectBlocksForDrops() {
        return BlockTags.INCORRECT_FOR_NETHERITE_TOOL;
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
