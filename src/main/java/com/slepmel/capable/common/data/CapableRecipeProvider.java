package com.slepmel.capable.common.data;

import java.io.IOException;

import java.nio.file.Path;
import java.util.Set;
import java.util.function.Consumer;

import com.google.common.collect.Sets;
import com.slepmel.capable.Capable;
import com.slepmel.capable.common.registry.CapableItems;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;

public class CapableRecipeProvider extends RecipeProvider{
	protected final DataGenerator generator;

	public CapableRecipeProvider(DataGenerator gen) {
		super(gen);
		this.generator = gen;
	}
	
	   protected Path getPath(ResourceLocation location) {
	       return this.generator.getOutputFolder().resolve("data/" + location.getNamespace() + "/recipes/" + location.getPath() + ".json");
	    }

	     public String getName() {
	        return Capable.MODNAME + " Recipes";
	     }
	     
	     @Override
	    public void run(DirectoryCache cache) throws IOException {
	    	 Path path = this.generator.getOutputFolder();
	         Set<ResourceLocation> set = Sets.newHashSet();
	         buildShapelessRecipes((builder) -> {
	            if (!set.add(builder.getId())) {
	               throw new IllegalStateException("Duplicate recipe " + builder.getId());
	            } else {
	               saveRecipe(cache, builder.serializeRecipe(), path.resolve("data/" + builder.getId().getNamespace() + "/recipes/" + builder.getId().getPath() + ".json"));
	            }
	         });
	    }
	     
	     
	     @Override
	    	protected void buildShapelessRecipes(Consumer<IFinishedRecipe> recipe) {
	    		//Insert recipes here(all types lmao)
	    	 ShapedRecipeBuilder.shaped(CapableItems.ZEEDRIUM_SWORD.get()).define('Z', CapableItems.ZEEDRIUM_INGOT.get()).define('S', Items.STICK).pattern("Z").pattern("Z").pattern("S").unlockedBy("has_zeedrium_ingot", has(CapableItems.ZEEDRIUM_INGOT.get())).save(recipe);
	    	 ShapedRecipeBuilder.shaped(CapableItems.ZEEDRIUM_AXE.get()).define('Z', CapableItems.ZEEDRIUM_INGOT.get()).define('S', Items.STICK).pattern("ZZ").pattern("ZS").pattern(" S").unlockedBy("has_zeedrium_ingot", has(CapableItems.ZEEDRIUM_INGOT.get())).save(recipe);
	    	 ShapedRecipeBuilder.shaped(CapableItems.ZEEDRIUM_SHOVEL.get()).define('Z', CapableItems.ZEEDRIUM_INGOT.get()).define('S', Items.STICK).pattern("Z").pattern("S").pattern("S").unlockedBy("has_zeedrium_ingot", has(CapableItems.ZEEDRIUM_INGOT.get())).save(recipe);
	    	 ShapedRecipeBuilder.shaped(CapableItems.ZEEDRIUM_HOE.get()).define('Z', CapableItems.ZEEDRIUM_INGOT.get()).define('S', Items.STICK).pattern("ZZ").pattern(" S").pattern(" S").unlockedBy("has_zeedrium_ingot", has(CapableItems.ZEEDRIUM_INGOT.get())).save(recipe);
	    	 ShapedRecipeBuilder.shaped(CapableItems.ZEEDRIUM_PICKAXE.get()).define('Z', CapableItems.ZEEDRIUM_INGOT.get()).define('S', Items.STICK).pattern("ZZZ").pattern(" S ").pattern(" S ").unlockedBy("has_zeedrium_ingot", has(CapableItems.ZEEDRIUM_INGOT.get())).save(recipe);
	    	 ShapedRecipeBuilder.shaped(CapableItems.ZEEDRIUM_INGOT.get()).define('Z', CapableItems.ZEEDRIUM_NUGGET.get()).pattern("ZZZ").pattern("ZZZ").pattern("ZZZ").unlockedBy("has_zeedrium_nugget", has(CapableItems.ZEEDRIUM_NUGGET.get())).save(recipe);
	    	 ShapelessRecipeBuilder.shapeless(CapableItems.ZEEDRIUM_NUGGET.get(), 9).requires(CapableItems.ZEEDRIUM_INGOT.get()).unlockedBy("has_zeedrium_ingot_for_nuggets", has(CapableItems.ZEEDRIUM_INGOT.get())).save(recipe);
	    	// CookingRecipeBuilder.smelting(Ingredient.of(CapableBlocks.ZEEDRIUM_ORE.get()), CapableItems.ZEEDRIUM_INGOT.get(), 1.35F, 400).unlockedBy("has_zeedrium_ore", has(CapableBlocks.ZEEDRIUM_ORE.get())).save(recipe);
	    	// CookingRecipeBuilder.blasting(Ingredient.of(CapableBlocks.ZEEDRIUM_ORE.get()), CapableItems.ZEEDRIUM_INGOT.get(), 1.45F, 200).unlockedBy("has_zeedrium_ore_for_blasting", has(CapableBlocks.ZEEDRIUM_ORE.get())).save(recipe);
	     }
	     
	     //Insert custom recipe methods here
	    
}