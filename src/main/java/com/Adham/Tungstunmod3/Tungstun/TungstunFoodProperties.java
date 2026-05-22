package com.Adham.Tungstunmod3.Tungstun;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class TungstunFoodProperties {
    public  static final FoodProperties Tungstun_Batatis =
            new FoodProperties.Builder()
                    .nutrition(8)
                    .saturationModifier(0.6f)
                    .effect(new MobEffectInstance(MobEffects.ABSORPTION, 6000, 2), 1.0f)
                    .effect(new MobEffectInstance(MobEffects.REGENERATION, 6000, 2), 1.0f)
                    .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 6000, 2), 1.0f)
                    .effect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 6000, 2), 1.0f)
                    .effect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 6000, 2), 1.0f)
                    .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 6000, 2), 1.0f)
                    .effect(new MobEffectInstance(MobEffects.CONFUSION, 100,3), 1.0f)
                    .alwaysEdible()
                    .build();
}
