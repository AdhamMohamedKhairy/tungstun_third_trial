package com.Adham.Tungstunmod3;

import com.Adham.Tungstunmod3.Tungstun.TungstunCreativeMode;
import com.Adham.Tungstunmod3.Tungstun.TungstunOre;
import com.Adham.Tungstunmod3.TungstunBlocks.TungstunBlock;
import com.Adham.Tungstunmod3.TungstunEntities.TungstunEntities;
import com.Adham.Tungstunmod3.TungstunEntities.custom.HotPotato;
import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;
import net.minecraftforge.event.TickEvent;

// The value here should match an entry in the META-IoulnNF/mods.toml file
@Mod(Tungstunmod3.MOD_ID)
public class Tungstunmod3
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "tungstunmod";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();


    public Tungstunmod3(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        TungstunCreativeMode.register(modEventBus);

        TungstunEntities.register(modEventBus);

        TungstunOre.register(modEventBus);
        TungstunBlock.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");

        if (Config.logDirtBlock)
            LOGGER.info("DIRT BLOCK >> {}", ForgeRegistries.BLOCKS.getKey(Blocks.DIRT));

        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber);

        Config.items.forEach((item) -> LOGGER.info("ITEM >> {}", item.toString()));
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){
            event.accept(TungstunOre.Tungstun);
            event.accept(TungstunOre.RawTungstun);
        }
        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS){
            event.accept(TungstunBlock.TungstunBlocko);
        }
        if(event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS){
            event.accept(TungstunBlock.TungstunOree);
        }
        if(event.getTabKey() == CreativeModeTabs.COMBAT){
            event.accept(TungstunOre.Tungstun_Mace);
            event.accept(TungstunOre.HOT_POTATO);
            event.accept(TungstunOre.TUNGSTUN_BOOTS.get());
            event.accept(TungstunOre.TUNGSTUN_CHESTPLATE.get());
            event.accept(TungstunOre.TUNGSTUN_HELMET.get());
            event.accept(TungstunOre.TUNGSTUN_LEGGINGS.get());
            event.accept(TungstunOre.CRYSTALLIZED_NETHERITE_SWORD.get());
            event.accept(TungstunOre.TUNGSTUN_SWORD.get());
        }
        if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS){
            event.accept(TungstunOre.TungstunBatatis);
        }
        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES){
            event.accept(TungstunOre.CRYSTALLIZED_NETHERITE_HOE.get());
            event.accept(TungstunOre.CRYSTALLIZED_NETHERITE_SHOVEL.get());
            event.accept(TungstunOre.CRYSTALLIZED_NETHERITE_AXE.get());
            event.accept(TungstunOre.CRYSTALLIZED_NETHERITE_PICKAXE.get());
            event.accept(TungstunOre.TUNGSTUN_HOE.get());
            event.accept(TungstunOre.TUNGSTUN_SHOVEL.get());
            event.accept(TungstunOre.TUNGSTUN_AXE.get());
            event.accept(TungstunOre.TUNGSTUN_PICKAXE.get());
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }

        @SubscribeEvent
        public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event){
            event.registerEntityRenderer(TungstunEntities.HOT_POTATO.get(),
                    pContext -> new ThrownItemRenderer<HotPotato>(pContext, 1.0f, true));
        }
    }
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class ServerModEvents{
        @SubscribeEvent
        public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
            if (event.phase == TickEvent.Phase.END) {
               net.minecraft.world.entity.player.Player player = event.player;

                boolean helmetOn =  player.getItemBySlot(EquipmentSlot.HEAD).is(TungstunOre.TUNGSTUN_HELMET.get()) ||
                        player.getItemBySlot(EquipmentSlot.HEAD).is(TungstunOre.CRY_HELMET.get());

                boolean chestOn =  player.getItemBySlot(EquipmentSlot.CHEST).is(TungstunOre.TUNGSTUN_CHESTPLATE.get()) ||
                        player.getItemBySlot(EquipmentSlot.CHEST).is(TungstunOre.CRY_CHESTPLATE.get());

                boolean legOn =  player.getItemBySlot(EquipmentSlot.LEGS).is(TungstunOre.TUNGSTUN_LEGGINGS.get()) ||
                        player.getItemBySlot(EquipmentSlot.LEGS).is(TungstunOre.CRY_LEGGINGS.get());

                boolean bootsOn =  player.getItemBySlot(EquipmentSlot.FEET).is(TungstunOre.TUNGSTUN_BOOTS.get()) ||
                        player.getItemBySlot(EquipmentSlot.FEET).is(TungstunOre.CRY_BOOTS.get());

                if (helmetOn && chestOn && legOn && bootsOn){
                    player.addEffect(new MobEffectInstance(
                            MobEffects.DAMAGE_RESISTANCE, 40, 1,false,false
                    ));
                    player.addEffect(new MobEffectInstance(
                            MobEffects.FIRE_RESISTANCE, 40, 0,false,false
                    ));
                }
            }
        }
    }
}
