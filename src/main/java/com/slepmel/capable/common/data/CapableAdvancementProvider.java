package com.slepmel.capable.common.data;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Set;
import java.util.function.Consumer;

import org.apache.commons.lang3.Validate;

import com.google.common.collect.Sets;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.slepmel.capable.Capable;
import com.slepmel.capable.common.registry.CapableItems;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.FrameType;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.data.AdvancementProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IDataProvider;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;

public class CapableAdvancementProvider extends AdvancementProvider{
	  private static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(Capable.MODID, "textures/gui/advancement_tab_bg.png");
	    private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().create();
	    private final DataGenerator generator;

	public CapableAdvancementProvider(DataGenerator gen) {
		super(gen);
		this.generator = gen;
	}
	
    private static Path getPath(Path pathIn, Advancement adv) {
        return pathIn.resolve("data/" + adv.getId().getNamespace() + "/advancements/" + adv.getId().getPath() + ".json");
    }
    
    private static String id(String s) {
        return Capable.MODID + ":" + s;
    }
    
    @Override
    public String getName() {
    	return Capable.MODNAME + " Advancements";
    }
	
    @Override
    public void run(DirectoryCache cache) {
        Path path = this.generator.getOutputFolder();
        Set<ResourceLocation> set = Sets.newHashSet();
        Consumer<Advancement> consumer = (advancement) -> {
            if (!set.add(advancement.getId())) {
                throw new IllegalStateException("Duplicate advancement present " + advancement.getId());
            } else {
                Path path1 = getPath(path, advancement);
                try {
                    IDataProvider.save(GSON, cache, advancement.deconstruct().serializeToJson(), path1);
                } catch (IOException e) {
                    Capable.LOGGER.error("Failed to save advancement {}", path1, e);
                }
            }
        };
        this.register(consumer);
    }

	private void register(Consumer<Advancement> a) {
		Advancement zeedriumAcquired = registerAdvancement("zeedrium_acquired", FrameType.TASK, CapableItems.ZEEDRIUM_INGOT.get()).addCriterion("zeedrium_acquired", 
				InventoryChangeTrigger.Instance.hasItems(CapableItems.ZEEDRIUM_INGOT.get())).save(a, id("zeedrium_acquired"));
	}
	
	 private Advancement.Builder registerAdvancement(String name, FrameType type, IItemProvider... items) {
	        Validate.isTrue(items.length > 0);
	        return Advancement.Builder.advancement().display(items[0], new TranslationTextComponent("advancements.capable." + name + ".title"),
	                new TranslationTextComponent("advancements.capable." + name + ".description"), BACKGROUND_TEXTURE, type, true, true, false);
	    }

}
