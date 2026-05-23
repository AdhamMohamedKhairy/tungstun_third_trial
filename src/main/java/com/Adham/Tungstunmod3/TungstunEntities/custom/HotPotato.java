package com.Adham.Tungstunmod3.TungstunEntities.custom;

import com.Adham.Tungstunmod3.Tungstun.TungstunOre;
import com.Adham.Tungstunmod3.TungstunEntities.TungstunEntities;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.ItemSupplier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec2;

public class HotPotato extends AbstractArrow implements ItemSupplier {

    private float rotation;
    public Vec2 grounded0ffset;

    public HotPotato(EntityType<? extends AbstractArrow> pEntityType, Level pLevel) {
        super (pEntityType, pLevel);
    }

    public HotPotato(LivingEntity shooter, Level level){
        super(TungstunEntities.HOT_POTATO.get(), shooter, level, new ItemStack(TungstunOre.HOT_POTATO.get()), null);
    }

    @Override
    protected ItemStack getDefaultPickupItem() {
        return new ItemStack(TungstunOre.HOT_POTATO.get());
    }

    @Override
    public ItemStack getItem() {
        return new ItemStack(TungstunOre.HOT_POTATO.get());
    }

    public boolean isGrounded(){
        return inGround;
    }

    private boolean hasExploded = false;

    private void  doExplode(){
        if (hasExploded) return;
        hasExploded = true;
        if (!this.level().isClientSide){
            this.level().explode(
                    this, this.getX(), this.getY(), this.getZ(), 5.0f, true, Level.ExplosionInteraction.TNT
            );
            this.discard();
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult result){
        super.onHitEntity(result);
        if(result.getEntity() instanceof  LivingEntity target){
            target.hurt(this.damageSources()
                            .thrown(this,
                            this.getOwner()),
                            20.0f);
            target.igniteForSeconds(5);
        }
        doExplode();
    }

    @Override
    protected void onHit(HitResult result){
        super.onHit(result);
        doExplode();
    }
}
