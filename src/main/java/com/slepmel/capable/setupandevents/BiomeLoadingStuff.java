package com.slepmel.capable.setupandevents;

import java.util.Objects;

import com.slepmel.capable.common.registry.CapableFeatures;
import com.slepmel.capable.config.CapableConfig;
import com.slepmel.capable.config.CapableConfig.Common;

import net.minecraft.util.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.common.world.MobSpawnInfoBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class BiomeLoadingStuff {
    public static void onBiomeLoadingEvent(final BiomeLoadingEvent event) {
        StructureHandler.addfeatures(event);
        MobSpawns.addMobSpawns(event);
    }
    
    private static class MobSpawns {
    	
        public static void addMobSpawns(BiomeLoadingEvent event) {
            MobSpawnInfoBuilder spawnInfoBuilder = event.getSpawns();
            RegistryKey<Biome> biome = RegistryKey.create(ForgeRegistries.Keys.BIOMES, Objects.requireNonNull(event.getName(), "Null biome moment"));
        }
    	
    }
    
    private static class StructureHandler {

        public static void addfeatures(BiomeLoadingEvent event) {
            BiomeGenerationSettingsBuilder gen = event.getGeneration();
            
            RegistryKey<Biome> biome = RegistryKey.create(ForgeRegistries.Keys.BIOMES, Objects.requireNonNull(event.getName(), "Null biome moment"));
            
            if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.OVERWORLD)) {
                if (Common.enableOreGen.get())
                    addOverworldOres(gen);
            }
            
        }
    }
    
    private static void addOverworldOres(BiomeGenerationSettingsBuilder gen) {
    	if(Common.enableZeedriumOreGen.get()) {
    		 gen.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, CapableFeatures.ORE_ZEEDRIUM);
    	}
    }

}
