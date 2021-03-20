package me.gkfiredev.fireslime.slimefun;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import me.gkfiredev.fireslime.tools.FiniteGauntlet;
import me.gkfiredev.fireslime.tools.FiniteRock;
import me.gkfiredev.fireslime.tools.MobDex;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;

public class FireRegistry {
	
	public static SlimefunItem MAGIC_ROD_I = new SlimefunItem(FireCategories.SDMC, FireItemStack.MAGIC_ROD_I, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {SlimefunItems.MAGIC_LUMP_3, null, null, SlimefunItems.MAGIC_LUMP_3, null, null, null, null, null});
	public static SlimefunItem MAGIC_ROD_II = new SlimefunItem(FireCategories.SDMC, FireItemStack.MAGIC_ROD_II, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {FireItemStack.MAGIC_ROD_I, null, null, FireItemStack.MAGIC_ROD_I, null, null, null, null, null});
	
	
	public static SlimefunItem LUCKSTONE = new SlimefunItem(FireCategories.SDMC, FireItemStack.LUCK_STONE, RecipeType.ANCIENT_ALTAR, new ItemStack[] {SlimefunItems.SYNTHETIC_SAPPHIRE, SlimefunItems.MAGIC_LUMP_2, SlimefunItems.SYNTHETIC_SAPPHIRE, SlimefunItems.MAGIC_LUMP_2, new ItemStack(Material.DIAMOND), SlimefunItems.MAGIC_LUMP_2, SlimefunItems.SYNTHETIC_SAPPHIRE, SlimefunItems.MAGIC_LUMP_2, SlimefunItems.SYNTHETIC_SAPPHIRE});
	public static MobDex MOB_DEX = new MobDex(FireCategories.FIRESLIME, FireItemStack.MOB_DEX, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] {SlimefunItems.ELECTRO_MAGNET, SlimefunItems.HOLOGRAM_PROJECTOR, SlimefunItems.ELECTRO_MAGNET, SlimefunItems.BRASS_INGOT, SlimefunItems.ANDROID_MEMORY_CORE, SlimefunItems.BRASS_INGOT, SlimefunItems.BRASS_INGOT, SlimefunItems.SMALL_CAPACITOR, SlimefunItems.BRASS_INGOT});
	
	
	//Finite Rocks
	public static FiniteRock REALITY_ROCK = new FiniteRock(FireCategories.SDMC, FireItemStack.REALITY_ROCK, RecipeType.ANCIENT_ALTAR, FiniteRock.getRecipe(0), ChatColor.RED);
	public static FiniteRock SPACE_ROCK = new FiniteRock(FireCategories.SDMC, FireItemStack.SPACE_ROCK, RecipeType.ANCIENT_ALTAR, FiniteRock.getRecipe(2), ChatColor.BLUE);
	public static FiniteRock POWER_ROCK = new FiniteRock(FireCategories.SDMC, FireItemStack.POWER_ROCK, RecipeType.ANCIENT_ALTAR, FiniteRock.getRecipe(1), ChatColor.DARK_PURPLE);
	public static FiniteRock TIME_ROCK = new FiniteRock(FireCategories.SDMC, FireItemStack.TIME_ROCK, RecipeType.ANCIENT_ALTAR, FiniteRock.getRecipe(3), ChatColor.GREEN);
	public static FiniteRock MIND_ROCK = new FiniteRock(FireCategories.SDMC, FireItemStack.MIND_ROCK, RecipeType.ANCIENT_ALTAR, FiniteRock.getRecipe(5), ChatColor.YELLOW);
	public static FiniteRock SOUL_ROCK = new FiniteRock(FireCategories.SDMC, FireItemStack.SOUL_ROCK, RecipeType.ANCIENT_ALTAR, FiniteRock.getRecipe(4), ChatColor.GOLD);
	
	public static FiniteGauntlet FINITE_GAUNTLET = new FiniteGauntlet(FireCategories.FIRESLIME, FireItemStack.FINITE_GAUNTLET, RecipeType.ANCIENT_ALTAR, new ItemStack[] {FireItemStack.REALITY_ROCK, FireItemStack.POWER_ROCK, FireItemStack.SPACE_ROCK, FireItemStack.TIME_ROCK, FireItemStack.MIND_ROCK, FireItemStack.SOUL_ROCK, SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.REINFORCED_ALLOY_INGOT});
	
	
	//Zelda
	public static SlimefunItem HYLIAN_SHIELD = new SlimefunItem(FireCategories.FIRESLIME, FireItemStack.HYLIAN_SHIELD, RecipeType.ARMOR_FORGE, new ItemStack[] {SlimefunItems.STEEL_INGOT, SlimefunItems.SYNTHETIC_DIAMOND, SlimefunItems.STEEL_INGOT, SlimefunItems.STEEL_INGOT, SlimefunItems.STEEL_INGOT, SlimefunItems.STEEL_INGOT, null, SlimefunItems.STEEL_INGOT, null});
	public static SlimefunItem MASTER_SWORD = new SlimefunItem(FireCategories.FIRESLIME, FireItemStack.MASTER_SWORD, RecipeType.MAGIC_WORKBENCH, new ItemStack[] {SlimefunItems.MAGIC_LUMP_3, SlimefunItems.CARBONADO, SlimefunItems.MAGIC_LUMP_3, new ItemStack(Material.OBSIDIAN), SlimefunItems.CARBONADO, new ItemStack(Material.OBSIDIAN), SlimefunItems.MAGIC_LUMP_3, FireItemStack.MAGIC_ROD_II, SlimefunItems.MAGIC_LUMP_3});
}
