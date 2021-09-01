package com.slepmel.capable.data;

import java.util.Collection;

import javax.annotation.Nonnull;

import com.slepmel.capable.Capable;
import com.slepmel.capable.common.registry.CapableBlocks;
import com.slepmel.capable.common.registry.CapableItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelFile.ExistingModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

public class CapableItemModelProvider extends ItemModelProvider{

	public CapableItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, Capable.MODID, existingFileHelper);
	}

    @Override
    protected void registerModels() {
        generate(CapableItems.ITEMS.getEntries());
        generateBlockItems(CapableBlocks.ITEM_BLOCKS.getEntries());
    }

    @Nonnull
    @Override
    public String getName() {
        return Capable.MODNAME + " Item models";
    }

    private void generate(final Collection<RegistryObject<Item>> items) {
        final ModelFile parentGenerated = getExistingFile(mcLoc("item/generated"));
        final ExistingModelFile parentHandheld = getExistingFile(mcLoc("item/handheld"));

        for (RegistryObject<Item> item : items) {
            String name = item.getId().getPath();

            if (name.startsWith("enchanted"))
                name = name.substring(name.indexOf("_") + 1);

            /*
             *  Skip elements that have no texture at assets/chaosawakens/textures/item
             *  or already have an existing model at assets/chaosawakens/models/item
             */
            if (!existingFileHelper.exists(new ResourceLocation(Capable.MODID, "item/" + name), TEXTURE) || existingFileHelper.exists(new ResourceLocation(Capable.MODID, "item/" + name), MODEL))
                continue;

            Capable.LOGGER.info(item.getId());

            getBuilder(item.getId().getPath()).parent(item.get().getMaxDamage(ItemStack.EMPTY) > 0 && !(item.get() instanceof ArmorItem) ? parentHandheld : parentGenerated).texture("layer0", ItemModelProvider.ITEM_FOLDER + "/" + name);
        }
    }

    private void generateBlockItems(final Collection<RegistryObject<Item>> itemBlocks) {
        for (RegistryObject<Item> item : itemBlocks) {
            String name = item.getId().getPath();

            /*
             *  Skip elements that have no block model inside of assets/chaosawakens/models/block
             *  or already have an existing item model at assets/chaosawakens/models/item
             */

            if (!existingFileHelper.exists(new ResourceLocation(Capable.MODID, "block/" + name), MODEL) || existingFileHelper.exists(new ResourceLocation(Capable.MODID, "item/" + name), MODEL))
                continue;

            Capable.LOGGER.info(item.getId());

            withExistingParent(name, new ResourceLocation(Capable.MODID, "block/" + name));

        }
    }
}