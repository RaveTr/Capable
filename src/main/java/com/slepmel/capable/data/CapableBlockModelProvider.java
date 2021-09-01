package com.slepmel.capable.data;

import com.slepmel.capable.Capable;

import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class CapableBlockModelProvider extends BlockModelProvider{

	public CapableBlockModelProvider(DataGenerator generator, String modid, ExistingFileHelper existingFileHelper) {
		super(generator, modid, existingFileHelper);
	}
	
	@Override
	public String getName() {
		return Capable.MODNAME + " Block Models";
	}

	@Override
	protected void registerModels() {
		
	}

    private ResourceLocation chaosRL(String texture) {
        return new ResourceLocation(Capable.MODID, BLOCK_FOLDER + "/" + texture);
    }

    private ResourceLocation otherRL(String modid, String texture) {
        return new ResourceLocation(modid, BLOCK_FOLDER + "/" + texture);
    }

    public BlockModelBuilder cubeAll(String name, ResourceLocation texture) {
        return singleTexture(name, mcLoc(BLOCK_FOLDER), "all", texture);
    }

    public BlockModelBuilder cubeColumn(String name, ResourceLocation side, ResourceLocation end) {
        Capable.debug("DATAGEN", side.getPath());
        return withExistingParent(name, BLOCK_FOLDER)
                .texture("side", side)
                .texture("end", end);
    }

    public BlockModelBuilder cubeColumnHorizontal(String name, ResourceLocation side, ResourceLocation end) {
        return withExistingParent(name, BLOCK_FOLDER)
                .texture("side", side)
                .texture("end", end);
    }
	
}
