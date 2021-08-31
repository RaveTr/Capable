package com.slepmel.capable;

import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.example.GeckoLibMod;
import software.bernie.geckolib3.GeckoLib;

import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Capable.MODID)
public class Capable
{
    // Directly reference a log4j logger.
	public static final String MODNAME = "Capable";
	public static final String MODID = "capable";
	public static final String VERSION = "0.1";
    private static final Logger LOGGER = LogManager.getLogger();
    public static Capable INSTANCE;

    public Capable() {
    	INSTANCE = this;
		GeckoLibMod.DISABLE_IN_DEV = true;
		GeckoLib.initialize();
    	
        IEventBus eBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        eBus.addListener(this::gatherData);
        
        MinecraftForge.EVENT_BUS.register(this);
    }
    
	public static ResourceLocation locPrefix(String name) {
		return new ResourceLocation(MODID, name.toLowerCase(Locale.ROOT));
	}
    
    
    private void gatherData(final GatherDataEvent event) {
		DataGenerator dataGen = event.getGenerator();
		final ExistingFileHelper exists = event.getExistingFileHelper();
		if(event.includeServer()) {
			
		}
    }
}
