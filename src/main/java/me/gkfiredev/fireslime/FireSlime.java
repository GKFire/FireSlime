package me.gkfiredev.fireslime;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.utils.ChatUtils;
import me.gkfiredev.fireslime.slimefun.FireCategories;
import me.gkfiredev.fireslime.slimefun.FireRegistry;
import me.gkfiredev.fireslime.tools.FiniteRock;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.collections.Pair;

public class FireSlime extends JavaPlugin implements SlimefunAddon {
	
	
	
	@Override
	public void onEnable() {
		getLogger().info("FireSlime Active!");
		getLogger().info("Version: " + getDescription().getVersion());
		getLogger().info("Setting up Items...");
		FireCategories.FIRESLIME.register(this);
		FireCategories.FIREMACHINES.register(this);
		FireCategories.SDMC.register(this);
		registerFireSlimeItems();
		registerFireMachines();
		registerSDMCItems();
		registerMoreTools();
		for(FiniteRock rock : FiniteRock.rocks) { rock.register(this);}
	}

	@Override
	public void onDisable() {
		
	}
	
	@Override
	public JavaPlugin getJavaPlugin() {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public String getBugTrackerURL() {
		// TODO Auto-generated method stub
		return "https://github.com/GKFire/FireSlime/issues";
	}
	
	public void registerFireSlimeItems() {
		FireRegistry.HYLIAN_SHIELD.register(this);
		FireRegistry.MASTER_SWORD.register(this);
		FireRegistry.MOB_DEX.register(this);
		FireRegistry.FINITE_GAUNTLET.register(this);
	}
	
	public void registerFireMachines() {
		
	}
	
	public void registerSDMCItems() {
		FireRegistry.LUCKSTONE.register(this);
		FireRegistry.MAGIC_ROD_I.register(this);
		FireRegistry.MAGIC_ROD_II.register(this);
	}
	
	
	private void registerPickaxe(Material type, String component, ItemStack item, List<Pair<Enchantment, Integer>> enchantments) {
        SlimefunItemStack is = new SlimefunItemStack(component + "_PICKAXE", type, "&r" + ChatUtils.humanize(component) + " Pickaxe");

        for (Pair<Enchantment, Integer> enchantment : enchantments) {
            is.addUnsafeEnchantment(enchantment.getFirstValue(), enchantment.getSecondValue());
        }

        SlimefunItem slimefunItem = new SlimefunItem(FireCategories.FIRESLIME, is, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] { item, item, item, null, new ItemStack(Material.STICK), null, null, new ItemStack(Material.STICK), null });
        slimefunItem.register(this);
    }
	
	private void registerAxe(Material type, String component, ItemStack item, List<Pair<Enchantment, Integer>> enchantments) {
        SlimefunItemStack is = new SlimefunItemStack(component + "_AXE", type, "&r" + ChatUtils.humanize(component) + " Axe");

        for (Pair<Enchantment, Integer> enchantment : enchantments) {
            is.addUnsafeEnchantment(enchantment.getFirstValue(), enchantment.getSecondValue());
        }

        SlimefunItem slimefunItem = new SlimefunItem(FireCategories.FIRESLIME, is, RecipeType.ENHANCED_CRAFTING_TABLE, new ItemStack[] { item, item, null, item, new ItemStack(Material.STICK), null, null, new ItemStack(Material.STICK), null });
        slimefunItem.register(this);
    }
	
	private void registerMoreTools() {
		registerPickaxe(Material.GOLDEN_PICKAXE, "COPPER", SlimefunItems.COPPER_INGOT, Arrays.asList(new Pair<>(Enchantment.DIG_SPEED, 3), new Pair<>(Enchantment.DURABILITY, 2)));
		registerPickaxe(Material.IRON_PICKAXE, "TIN", SlimefunItems.COPPER_INGOT, Arrays.asList(new Pair<>(Enchantment.DIG_SPEED, 4), new Pair<>(Enchantment.DURABILITY, 1)));
		registerPickaxe(Material.IRON_PICKAXE, "SILVER", SlimefunItems.COPPER_INGOT, Arrays.asList(new Pair<>(Enchantment.DIG_SPEED, 4), new Pair<>(Enchantment.DURABILITY, 5)));
		registerPickaxe(Material.IRON_PICKAXE, "ALUMINUM", SlimefunItems.COPPER_INGOT, Arrays.asList(new Pair<>(Enchantment.DIG_SPEED, 7)));
		registerPickaxe(Material.IRON_PICKAXE, "LEAD", SlimefunItems.COPPER_INGOT, Arrays.asList(new Pair<>(Enchantment.DIG_SPEED, 3), new Pair<>(Enchantment.DURABILITY, 2)));
		registerPickaxe(Material.IRON_PICKAXE, "ZINC", SlimefunItems.COPPER_INGOT, Arrays.asList(new Pair<>(Enchantment.DIG_SPEED, 2), new Pair<>(Enchantment.DURABILITY, 4)));
		registerPickaxe(Material.IRON_PICKAXE, "MAGNESUIM", SlimefunItems.COPPER_INGOT, Arrays.asList(new Pair<>(Enchantment.DIG_SPEED, 5), new Pair<>(Enchantment.DURABILITY, 2)));
		
		registerPickaxe(Material.IRON_PICKAXE, "STEEL", SlimefunItems.COPPER_INGOT, Arrays.asList(new Pair<>(Enchantment.DIG_SPEED, 5), new Pair<>(Enchantment.DURABILITY, 4)));
		registerPickaxe(Material.GOLDEN_PICKAXE, "BRONZE", SlimefunItems.COPPER_INGOT, Arrays.asList(new Pair<>(Enchantment.DIG_SPEED, 3), new Pair<>(Enchantment.DURABILITY, 3)));
		registerPickaxe(Material.IRON_PICKAXE, "BILLON", SlimefunItems.COPPER_INGOT, Arrays.asList(new Pair<>(Enchantment.DIG_SPEED, 4), new Pair<>(Enchantment.DURABILITY, 2)));
		registerPickaxe(Material.GOLDEN_PICKAXE, "BRASS", SlimefunItems.COPPER_INGOT, Arrays.asList(new Pair<>(Enchantment.DIG_SPEED, 4), new Pair<>(Enchantment.DURABILITY, 3)));
		registerPickaxe(Material.GOLDEN_PICKAXE, "ALUMINUM_BRASS", SlimefunItems.COPPER_INGOT, Arrays.asList(new Pair<>(Enchantment.DIG_SPEED, 5), new Pair<>(Enchantment.DURABILITY, 2)));
		
		registerAxe(Material.GOLDEN_AXE, "COPPER", SlimefunItems.COPPER_INGOT, Arrays.asList(new Pair<>(Enchantment.DIG_SPEED, 2), new Pair<>(Enchantment.DURABILITY, 2)));
		registerAxe(Material.IRON_AXE, "TIN", SlimefunItems.COPPER_INGOT, Arrays.asList(new Pair<>(Enchantment.DIG_SPEED, 2), new Pair<>(Enchantment.DURABILITY, 1)));
		registerAxe(Material.IRON_AXE, "SILVER", SlimefunItems.COPPER_INGOT, Arrays.asList(new Pair<>(Enchantment.DIG_SPEED, 2), new Pair<>(Enchantment.DURABILITY, 5)));
		registerAxe(Material.IRON_AXE, "ALUMINUM", SlimefunItems.COPPER_INGOT, Arrays.asList(new Pair<>(Enchantment.DIG_SPEED, 5)));
		registerAxe(Material.IRON_AXE, "LEAD", SlimefunItems.COPPER_INGOT, Arrays.asList(new Pair<>(Enchantment.DIG_SPEED, 2), new Pair<>(Enchantment.DURABILITY, 2)));
		registerAxe(Material.IRON_AXE, "ZINC", SlimefunItems.COPPER_INGOT, Arrays.asList(new Pair<>(Enchantment.DIG_SPEED, 2), new Pair<>(Enchantment.DURABILITY, 4)));
		registerAxe(Material.IRON_AXE, "MAGNESUIM", SlimefunItems.COPPER_INGOT, Arrays.asList(new Pair<>(Enchantment.DIG_SPEED, 3), new Pair<>(Enchantment.DURABILITY, 2)));
		
		registerAxe(Material.IRON_AXE, "STEEL", SlimefunItems.COPPER_INGOT, Arrays.asList(new Pair<>(Enchantment.DIG_SPEED, 3), new Pair<>(Enchantment.DURABILITY, 4)));
		registerAxe(Material.GOLDEN_AXE, "BRONZE", SlimefunItems.COPPER_INGOT, Arrays.asList(new Pair<>(Enchantment.DIG_SPEED, 1), new Pair<>(Enchantment.DURABILITY, 3)));
		registerAxe(Material.IRON_AXE, "BILLON", SlimefunItems.COPPER_INGOT, Arrays.asList(new Pair<>(Enchantment.DIG_SPEED, 2), new Pair<>(Enchantment.DURABILITY, 2)));
		registerAxe(Material.GOLDEN_AXE, "BRASS", SlimefunItems.COPPER_INGOT, Arrays.asList(new Pair<>(Enchantment.DIG_SPEED, 2), new Pair<>(Enchantment.DURABILITY, 3)));
		registerAxe(Material.GOLDEN_AXE, "ALUMINUM_BRASS", SlimefunItems.COPPER_INGOT, Arrays.asList(new Pair<>(Enchantment.DIG_SPEED, 3), new Pair<>(Enchantment.DURABILITY, 2)));
	}

}
