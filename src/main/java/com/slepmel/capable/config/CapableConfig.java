package com.slepmel.capable.config;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

public class CapableConfig {
	public static final ForgeConfigSpec COMMON_CONFIG_SPEC;
	public static final Common COMMON;
	
	static {
        final Pair<Common, ForgeConfigSpec> commonSpecPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON_CONFIG_SPEC = commonSpecPair.getRight();
        COMMON = commonSpecPair.getLeft();
	}
	
	public static class Common {
		
		public static ConfigValue<Boolean> enableOreGen;
		public static ConfigValue<Boolean> enableToolTips;
		
		 Common(ForgeConfigSpec.Builder builder) {
			 
			 builder.push("ToolTips");
			 enableToolTips = builder.define("Enable custom tooltips for items and blocks", true);
			 
			 builder.push("World Gen");
	            enableOreGen = builder.define("Enable ore generation", true);
	            
	            builder.push("Specific Ore Spawning");
		 }
	}

}
