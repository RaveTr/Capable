package com.slepmel.capable.common.data;

import com.slepmel.capable.common.registry.CapableBlocks;

import net.minecraft.block.Block;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.RandomValueRange;
import net.minecraft.util.IItemProvider;
import net.minecraftforge.fml.RegistryObject;

public class CapableBlockLootTableProvider extends BlockLootTables{
	
    protected static LootTable.Builder randomDropping(IItemProvider item, float random1, float random2) {
        return LootTable.lootTable().withPool(applyExplosionCondition(item, LootPool.lootPool().setRolls(RandomValueRange.between(random1, random2))).add(ItemLootEntry.lootTableItem(item)));
    }

    @Override
    protected void addTables() {
    	dropSelf(CapableBlocks.ZEEDRIUM_ORE.get());
    	
    }
    
    @Override
    protected Iterable<Block> getKnownBlocks() {
        return CapableBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
