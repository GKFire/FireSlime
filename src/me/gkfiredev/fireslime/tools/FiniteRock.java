package me.gkfiredev.fireslime.tools;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;

public class FiniteRock extends SlimefunItem {
	
	public static List<FiniteRock> rocks = new ArrayList<FiniteRock>();
	
	private ChatColor color;

	public FiniteRock(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, ChatColor color) {
		super(category, item, recipeType, recipe);
		this.color = color;
		rocks.add(this);
	}
	
	
	private ItemUseHandler getItemUseHandler() {
		return (e) -> {
			Player p = e.getPlayer();
			e.cancel();
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', SlimefunPlugin.getCfg().getString("options.chat-prefix")) + color
			+ "This Finite Rock cannot do anything by itself. But Maybe There is an item that can house"
			+ " all of the rocks into one weapon of mass destruction..");
			
		};
		
	}
	
	
	
	
	
	@Override
	public void preRegister() {
		super.preRegister();
		addItemHandler(getItemUseHandler());
		
	}
	
	
	public static ItemStack[] getRecipe(int value) {
		Material[] mats = {Material.REDSTONE_BLOCK, Material.DIAMOND, Material.BLUE_ICE, Material.EMERALD, Material.LAVA_BUCKET, Material.GOLD_INGOT};
		return new ItemStack[] {new ItemStack(mats[value]), new ItemStack(Material.STONE), new ItemStack(mats[value]), new ItemStack(Material.STONE), SlimefunItems.CARBONADO, new ItemStack(Material.STONE), new ItemStack(mats[value]), new ItemStack(Material.STONE), new ItemStack(mats[value])};
	}

}
