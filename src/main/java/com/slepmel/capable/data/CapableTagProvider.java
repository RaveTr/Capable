package com.slepmel.capable.data;

import java.nio.file.Path;

import com.slepmel.capable.Capable;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;

public class CapableTagProvider extends BlockTagsProvider{

	public CapableTagProvider(DataGenerator gen, ExistingFileHelper existingFileHelper) {
		super(gen, Capable.MODID, existingFileHelper);
	}
	
	@Override
	public String getName() {
		return "Capable Item-Block Tags";
	}
	
    protected Path getPath(ResourceLocation resourceLocation) {
        return this.generator.getOutputFolder().resolve("data/" + resourceLocation.getNamespace() + "/tags/items/" + resourceLocation.getPath() + ".json");
    }
	
	@Override
	protected void addTags() {

	}

	public static class CapableBlockTagProvider extends BlockTagsProvider {
		
		public CapableBlockTagProvider(DataGenerator gen, ExistingFileHelper existingFileHelper) {
			super(gen, Capable.MODID, existingFileHelper);
		}
		
	    protected Path getPath(ResourceLocation resourceLocation) {
	        return this.generator.getOutputFolder().resolve("data/" + resourceLocation.getNamespace() + "/tags/blocks/" + resourceLocation.getPath() + ".json");
	    }
		
	    @Override
	    public String getName() {
	    	return "Capable Block Tags";
	    }
	    
	    @Override
	    protected void addTags() {
	    	
	    }
	}

}
