package com.slepmel.capable.client;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class ClientStuff {
	
    public static void init() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(ClientStuff::onFMLClientSetupEvent);
    }
    
    public static void onFMLClientSetupEvent(FMLClientSetupEvent event) {
    	
    }
	
}
