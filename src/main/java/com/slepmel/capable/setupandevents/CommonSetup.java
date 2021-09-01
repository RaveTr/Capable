package com.slepmel.capable.setupandevents;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import com.slepmel.capable.api.FeatureWrapper;
import com.slepmel.capable.networking.PacketHandler;

import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class CommonSetup {
	
    public static List<FeatureWrapper> configFeatures = new ArrayList<>();

    private static Method codecMethod;
    
    public static void onFMLCommonSetupEvent(final FMLCommonSetupEvent event) {
    	PacketHandler.init();
    	
        event.enqueueWork(() -> {
        	
            configFeatures.forEach((wrapper) -> Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, wrapper.getIdentifier(), wrapper.getFeatureType()));
        });
    	
    }

}
