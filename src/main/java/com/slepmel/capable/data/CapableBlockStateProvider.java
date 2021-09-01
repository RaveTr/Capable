package com.slepmel.capable.data;

import com.slepmel.capable.Capable;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class CapableBlockStateProvider extends BlockStateProvider{

	public CapableBlockStateProvider(DataGenerator gen, String modid, ExistingFileHelper exFileHelper) {
		super(gen, modid, exFileHelper);
	}
	
	@Override
	public String getName() {
		return Capable.MODNAME + " Blockstates";
	}

	@Override
	protected void registerStatesAndModels() {
		
	}

}
