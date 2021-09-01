package com.slepmel.capable.api;

import net.minecraft.world.gen.feature.ConfiguredFeature;

public class FeatureWrapper {
	
	//This class is inspired by the Chaos Awakens feature wrapper
	
    private final String identifier;
    private final ConfiguredFeature<?, ?> featureType;

    public FeatureWrapper(String identifier, ConfiguredFeature<?, ?> featureType) {
        this.identifier = identifier;
        this.featureType = featureType;
    }

    @Override
    public String toString() {
        return identifier + ":" + featureType.toString();
    }

    public String getIdentifier() {
        return identifier;
    }

    public ConfiguredFeature<?, ?> getFeatureType() {
        return featureType;
    }

}
