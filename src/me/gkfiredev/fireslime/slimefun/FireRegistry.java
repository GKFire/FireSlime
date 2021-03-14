package me.gkfiredev.fireslime.slimefun;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;

public class FireRegistry {
	
	public static SlimefunItem MAGIC_ROD_I = new SlimefunItem(FireCategories.FIRESLIME, FireItemStack.MAGIC_ROD_I, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {SlimefunItems.MAGIC_LUMP_3, null, null, SlimefunItems.MAGIC_LUMP_3, null, null, null, null, null});
	public static SlimefunItem MAGIC_ROD_II = new SlimefunItem(FireCategories.FIRESLIME, FireItemStack.MAGIC_ROD_II, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {FireItemStack.MAGIC_ROD_I, null, null, FireItemStack.MAGIC_ROD_I, null, null, null, null, null});
	
	
	public static SlimefunItem LUCKSTONE = new SlimefunItem(FireCategories.SDMC, FireItemStack.LUCK_STONE, RecipeType.ANCIENT_ALTAR, new ItemStack[] {SlimefunItems.SYNTHETIC_SAPPHIRE, SlimefunItems.MAGIC_LUMP_2, SlimefunItems.SYNTHETIC_SAPPHIRE, SlimefunItems.MAGIC_LUMP_2, new ItemStack(Material.DIAMOND), SlimefunItems.MAGIC_LUMP_2, SlimefunItems.SYNTHETIC_SAPPHIRE, SlimefunItems.MAGIC_LUMP_2, SlimefunItems.SYNTHETIC_SAPPHIRE});
	
}