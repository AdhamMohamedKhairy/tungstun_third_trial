package com.Adham.Tungstunmod3.TungstunEntities;

import com.Adham.Tungstunmod3.Tungstun.custom.HotPotatoItem;
import com.Adham.Tungstunmod3.TungstunEntities.custom.HotPotato;
import com.Adham.Tungstunmod3.Tungstunmod3;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class TungstunEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Tungstunmod3.MOD_ID);

    public static final RegistryObject<EntityType<HotPotato>> HOT_POTATO =
            ENTITY_TYPES.register("hotpotato",
                    () -> EntityType.Builder
                            .<HotPotato>of(HotPotato::new, MobCategory.MISC)
                            .sized(0.25f,0.25f)
                            .build("hotpotato"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
