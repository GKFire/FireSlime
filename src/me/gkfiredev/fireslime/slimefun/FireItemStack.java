package me.gkfiredev.fireslime.slimefun;

import org.bukkit.Material;

import io.github.thebusybiscuit.slimefun4.utils.HeadTexture;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;

public class FireItemStack {
	
	public static final SlimefunItemStack MAGIC_ROD_I = new SlimefunItemStack("MAGIC_ROD_I", Material.BLAZE_ROD, "&6Magical Rod &7- &eI");
	public static final SlimefunItemStack MAGIC_ROD_II = new SlimefunItemStack("MAGIC_ROD_II", Material.BLAZE_ROD, "&6Magical Rod &7- &eII");
	
	public static final SlimefunItemStack LUCK_STONE = new SlimefunItemStack("LUCK_STONE", HeadTexture.SAPPHIRE, "&bLuck Stone");
	
	public static final SlimefunItemStack MOB_DEX = new SlimefunItemStack("MOB_DEX", Material.BOOK, "&cMob &fDex", LoreBuilder.powerCharged(0, 10));
	
}