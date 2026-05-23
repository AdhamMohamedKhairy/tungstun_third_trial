package com.Adham.Tungstunmod3.Tungstun.custom;

import com.Adham.Tungstunmod3.Tungstun.TungstunOre;
import com.Adham.Tungstunmod3.TungstunEntities.TungstunEntities;
import com.Adham.Tungstunmod3.TungstunEntities.custom.HotPotato;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;

public class HotPotatoItem extends Item {
    public HotPotatoItem(Properties properties){
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand){
        ItemStack stack = player.getItemInHand(hand);

        level.playSound(
                null, player.getX(), player.getY(), player.getZ(),
                SoundEvents.EGG_THROW, SoundSource.NEUTRAL, 0.5f, 0.4f);

        if (!level.isClientSide){
            HotPotato entity = new HotPotato(player, level);
            entity.shootFromRotation(player, player.getXRot(), player.getYRot(),
                    0.0f,1.5f, 1.0f);
            level.addFreshEntity(entity);
        }

        if (!player.getAbilities().instabuild){
            stack.shrink(1);
        }
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide);
    }
}
