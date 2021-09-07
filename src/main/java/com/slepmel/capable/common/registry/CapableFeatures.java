package com.slepmel.capable.common.registry;

import com.slepmel.capable.api.FeatureWrapper;
import com.slepmel.capable.setupandevents.CommonSetup;

import net.minecraft.block.BlockState;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.DepthAverageConfig;
import net.minecraft.world.gen.placement.Placement;

public class CapableFeatures {
	
	public static final ConfiguredFeature<?, ?> ORE_ZEEDRIUM = register("ore_zeedrium", Feature.ORE.configured(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, States.ZEEDRIUM_ORE, 4)).decorated(Placement.DEPTH_AVERAGE.configured(new DepthAverageConfig(12, 4))).squared().count(28));
	
    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> configuredFeature) {
        CommonSetup.configFeatures.add(new FeatureWrapper(key, configuredFeature));
        return configuredFeature;
    }
	
	public static class States {
		protected static final BlockState ZEEDRIUM_ORE = CapableBlocks.ZEEDRIUM_ORE.get().defaultBlockState();
		
	}

}
