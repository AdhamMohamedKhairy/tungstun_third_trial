package com.Adham.Tungstunmod3.Tungstun.custom;

import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoItemRenderer;

public class TungstunDrillRenderer extends GeoItemRenderer<TungstunDrill> {
    public TungstunDrillRenderer(){
        super(new GeoModel<TungstunDrill>() {
            @Override
            public ResourceLocation getModelResource(TungstunDrill animatable) {
                return ResourceLocation.fromNamespaceAndPath("tungstunmod", "geo/drill.geo.json");
            }

            @Override
            public ResourceLocation getTextureResource(TungstunDrill animatable) {
                return ResourceLocation.fromNamespaceAndPath("tungstunmod", "textures/item/drill.png");
            }

            @Override
            public ResourceLocation getAnimationResource(TungstunDrill animatable) {
                return ResourceLocation.fromNamespaceAndPath("tungstunmod", "animations/drill.animation.json");
            }
        });
    }
}
