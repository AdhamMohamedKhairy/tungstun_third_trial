package com.Adham.Tungstunmod3.TungstunBlocks;

import com.Adham.Tungstunmod3.Tungstun.TungstunOre;
import com.Adham.Tungstunmod3.Tungstunmod3;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class TungstunBlock {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Tungstunmod3.MOD_ID);

    public static final RegistryObject<Block> TungstunBlocko =
            registerBlock("tungstunblock", () ->
                    new Block(BlockBehaviour.Properties.of()
                            .strength(50.0f,2000f)
                            .requiresCorrectToolForDrops()
                            .sound(SoundType.DEEPSLATE_BRICKS)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block){
        TungstunOre.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
