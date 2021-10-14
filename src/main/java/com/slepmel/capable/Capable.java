package com.slepmel.capable;

import net.minecraft.data.DataGenerator;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import software.bernie.example.GeckoLibMod;
import software.bernie.geckolib3.GeckoLib;

import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.slepmel.capable.api.CapableReflection;
import com.slepmel.capable.client.ClientStuff;
import com.slepmel.capable.client.ToolTips;
import com.slepmel.capable.common.data.CapableAdvancementProvider;
import com.slepmel.capable.common.data.CapableBlockModelProvider;
import com.slepmel.capable.common.data.CapableBlockStateProvider;
import com.slepmel.capable.common.data.CapableItemModelProvider;
import com.slepmel.capable.common.data.CapableLootTableProvider;
import com.slepmel.capable.common.data.CapableRecipeProvider;
import com.slepmel.capable.common.data.CapableTagProvider;
import com.slepmel.capable.common.registry.CapableBlocks;
import com.slepmel.capable.common.registry.CapableEnchantments;
import com.slepmel.capable.common.registry.CapableItems;
import com.slepmel.capable.config.CapableConfig;
import com.slepmel.capable.config.CapableConfig.Common;
import com.slepmel.capable.setupandevents.BiomeLoadingStuff;
import com.slepmel.capable.setupandevents.CommonSetup;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Capable.MODID)
public class Capable
{
    // Directly reference a log4j logger.
	public static final String MODNAME = "Capable";
	public static final String MODID = "capable";
	public static final String VERSION = "0.1";
    public static final Logger LOGGER = LogManager.getLogger();
    public static Capable INSTANCE;

    public Capable() {
    	INSTANCE = this;
		GeckoLibMod.DISABLE_IN_DEV = true;
		GeckoLib.initialize();
		
		CapableReflection.classLoad("com.slepmel.common.registry.CapableTags");
    	
        IEventBus eBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        eBus.addListener(CommonSetup::onFMLCommonSetupEvent);
        eBus.addListener(this::gatherData);
        
		if (FMLEnvironment.dist == Dist.CLIENT) {
			eBus.addListener(ClientStuff::onFMLClientSetupEvent);
			MinecraftForge.EVENT_BUS.addListener(ToolTips::onToolTipEvent);
		}
        
        CapableItems.ITEMS.register(eBus);
        CapableBlocks.BLOCKS.register(eBus);
        CapableBlocks.ITEM_BLOCKS.register(eBus);
      //  if(Common.enableCustomEnchantments.get()) {
        	CapableEnchantments.ENCHANTMENTS.register(eBus);
      //  }
        
        MinecraftForge.EVENT_BUS.addListener(EventPriority.HIGH, BiomeLoadingStuff::onBiomeLoadingEvent);
        MinecraftForge.EVENT_BUS.register(this);
        
       
        
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, CapableConfig.COMMON_CONFIG_SPEC);
    }
    
	public static ResourceLocation locPrefix(String name) {
		return new ResourceLocation(MODID, name.toLowerCase(Locale.ROOT));
	}
    
    private void gatherData(final GatherDataEvent event) {
		DataGenerator dataGen = event.getGenerator();
		final ExistingFileHelper exists = event.getExistingFileHelper();
		if(event.includeServer()) {
			dataGen.addProvider(new CapableTagProvider(dataGen, exists));
			dataGen.addProvider(new CapableTagProvider.CapableBlockTagProvider(dataGen, exists));
			dataGen.addProvider(new CapableAdvancementProvider(dataGen));
			dataGen.addProvider(new CapableBlockModelProvider(dataGen, MODID, exists));
			dataGen.addProvider(new CapableItemModelProvider(dataGen, exists));
			dataGen.addProvider(new CapableBlockStateProvider(dataGen, MODID, exists));
			dataGen.addProvider(new CapableRecipeProvider(dataGen));
			dataGen.addProvider(new CapableLootTableProvider(dataGen));
		}
    }
    
    public static <D> void debug(String domain, D message) {
		LOGGER.debug("[" + domain + "]: " + (message == null ? "null" : message.toString()));
	}

	public static <I> void info(String domain, I message) {
		LOGGER.info("[" + domain + "]: " + (message == null ? "null" : message.toString()));
	}

	public static <W> void warn(String domain, W message) {
		LOGGER.warn("[" + domain + "]: " + (message == null ? "null" : message.toString()));
	}

	public static <E> void error(String domain, E message) {
		LOGGER.error("[" + domain + "]: " + (message == null ? "null" : message.toString()));
	}
}
