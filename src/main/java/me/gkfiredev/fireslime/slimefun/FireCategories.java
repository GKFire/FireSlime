package me.gkfiredev.fireslime.slimefun;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;

import me.gkfiredev.fireslime.FireSlime;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;

public class FireCategories {
	
	public static Category FIRESLIME = new Category(new NamespacedKey(FireSlime.getPlugin(FireSlime.class), "FireSlime"), new CustomItem(Material.BLAZE_POWDER, "&cFire&6Slime"), 1);
	public static Category FIREMACHINES = new Category(new NamespacedKey(FireSlime.getPlugin(FireSlime.class), "FireMachine"), new CustomItem(Material.FURNACE, "&cFire&7Machines"), 1);
	public static Category SDMC = new Category(new NamespacedKey(FireSlime.getPlugin(FireSlime.class), "SDMC"), new CustomItem(Material.BOOKSHELF, "&6SDMC"), 2);
	
}
