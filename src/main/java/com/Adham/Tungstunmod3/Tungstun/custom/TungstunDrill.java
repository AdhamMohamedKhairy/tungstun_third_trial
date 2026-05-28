package com.Adham.Tungstunmod3.Tungstun.custom;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class TungstunDrill extends PickaxeItem implements GeoItem {
    public TungstunDrill(TungstunTools material, Properties properties){
        super(material, properties);
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    }

    private List<BlockPos> get3x3Blocks(BlockPos center, Player player){
        List<BlockPos> blocks = new ArrayList<>();

        Direction.Axis axis;
        if (player.getXRot() > 45) {
            axis = Direction.Axis.Y;
        }
        else if (player.getXRot() < -45) {
            axis = Direction.Axis.Y;
        }
        else {
            axis = player.getDirection().getAxis();
        }

        for (int i = -1; i <= 1; i++)
            for (int j = -1; j <= 1; j++){
                if (i == 0 && j == 0) {continue;}

                BlockPos offset;
                if (axis == Direction.Axis.X){
                    offset = center.offset(0,i,j);
                }
                else if (axis == Direction.Axis.Z){
                    offset = center.offset(i,j,0);
                }
                else {
                    offset = center.offset(i,0,j);
                }
                blocks.add(offset);
            }

        return blocks;
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state,
                             BlockPos pos, net.minecraft.world.entity.LivingEntity miningEntity){
        if (!level.isClientSide && miningEntity instanceof ServerPlayer player){
            triggerAnim(player, GeoItem.getOrAssignId(stack, (ServerLevel) level),
                    "drill_controller", "drill");

            List<BlockPos> blocks = get3x3Blocks(pos, player);
            for(BlockPos extraPos : blocks){
                BlockState extraState = level.getBlockState(extraPos);
                if(!extraState.isAir() && extraState.getDestroySpeed(level, extraPos) >= 0){
                    level.destroyBlock(extraPos, true, player);
                    stack.hurtAndBreak(1, player, EquipmentSlot.MAINHAND);
                }
            }
        }
        return super.mineBlock(stack, level, state, pos, miningEntity);
    }

    @Override
    public boolean canAttackBlock(BlockState state, Level level, BlockPos pos, Player player) {
        return !player.isCreative();
    }

    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "drill_controller", 0, state -> {
            return PlayState.STOP;
        }).triggerableAnim("drill", RawAnimation.begin().thenLoop("drill"))
                .triggerableAnim("stop", RawAnimation.begin().then("drill", Animation.LoopType.PLAY_ONCE)));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer){
        consumer.accept(new GeoRenderProvider() {
            private static TungstunDrillRenderer renderer;

            @Override
            public BlockEntityWithoutLevelRenderer getGeoItemRenderer() {
                if (renderer == null) renderer = new TungstunDrillRenderer();
                return renderer;
            }
        });
    }

    @Override
    public boolean onEntitySwing(ItemStack stack, LivingEntity entity){
        return true;
    }
}
