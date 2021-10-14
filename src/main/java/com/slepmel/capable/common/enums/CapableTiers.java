package com.slepmel.capable.common.enums;

import java.util.function.Supplier;

import net.minecraft.item.Items;
import com.slepmel.capable.common.registry.CapableItems;

import com.slepmel.capable.config.CapableConfig.Common;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

public enum CapableTiers implements IItemTier{
	
	TOOL_ZEEDRIUM(Common.zeedriumHarvestLevel.get(), Common.zeedriumDurability.get(), Common.zeedriumEfficiency.get(), 10, 64, () -> Ingredient.of(CapableItems.ZEEDRIUM_INGOT.get())),
	TOOL_CRASH(10, 1 , 1000F, 1F, 6420, () -> Ingredient.of(Items.DEAD_BUSH));

	
    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairMaterial;

    CapableTiers(int harvestLevel, int maxUses, float efficiency, float damage, int enchantability, Supplier<Ingredient> repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = damage;
        this.enchantability = enchantability;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.attackDamage;
    }

    @Override
    public float getSpeed() {
        return this.efficiency;
    }
    
    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    @Override
    public int getLevel() {
        return this.harvestLevel;
    }

    @Override
    public int getUses() {
        return this.maxUses;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }
}
