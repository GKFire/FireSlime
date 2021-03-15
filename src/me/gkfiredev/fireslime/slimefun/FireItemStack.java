package me.gkfiredev.fireslime.slimefun;

import org.bukkit.Material;

import io.github.thebusybiscuit.slimefun4.utils.HeadTexture;
import io.github.thebusybiscuit.slimefun4.utils.LoreBuilder;
import me.gkfiredev.fireslime.FireSlimeHeads;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;

public class FireItemStack {
	
	public static final SlimefunItemStack MAGIC_ROD_I = new SlimefunItemStack("MAGIC_ROD_I", Material.BLAZE_ROD, "&6Magical Rod &7- &eI");
	public static final SlimefunItemStack MAGIC_ROD_II = new SlimefunItemStack("MAGIC_ROD_II", Material.BLAZE_ROD, "&6Magical Rod &7- &eII");
	
	public static final SlimefunItemStack LUCK_STONE = new SlimefunItemStack("LUCK_STONE", HeadTexture.SAPPHIRE, "&bLuck Stone");
	
	public static final SlimefunItemStack MOB_DEX = new SlimefunItemStack("MOB_DEX", Material.BOOK, "&cMob&fDex", "", "&eRight Click &7A Mob to recieve", "&7information about it", "", LoreBuilder.powerCharged(0, 15));
	
	
	//Finite Stones
	public static final SlimefunItemStack FINITE_GAUNTLET = new SlimefunItemStack("FINITE_GAUNTLET", FireSlimeHeads.GAUNTLET, "&eFinite Gauntlet", "", "&7A Weapon of Massive Destruction. &eRight Click &7", "&7To Wipe out half of the server's active players", "&7But With a Cost..", "", "&7Uses Left: &e3");
	public static final SlimefunItemStack REALITY_ROCK = new SlimefunItemStack("REALITY_ROCK", FireSlimeHeads.REALITY_ROCK, "&cReality Rock", "", "&7A Rock with the ability to alter reality itself");
	public static final SlimefunItemStack SPACE_ROCK = new SlimefunItemStack("SPACE_ROCK", FireSlimeHeads.SPACE_ROCK, "&bSpace Rock", "", "&7A Rock with the ability to travel through space");
	public static final SlimefunItemStack POWER_ROCK = new SlimefunItemStack("POWER_ROCK", FireSlimeHeads.POWER_ROCK, "&dPower Rock", "", "&7A Rock that gives great power and strength to its user");
	public static final SlimefunItemStack TIME_ROCK = new SlimefunItemStack("TIME_ROCK", FireSlimeHeads.TIME_ROCK, "&aTime Rock", "", "&7A Rock with the ability to alter any timeline");
	public static final SlimefunItemStack MIND_ROCK = new SlimefunItemStack("MIND_ROCK", FireSlimeHeads.MIND_ROCK, "&eMind Rock", "", "&7A Rock with the ability to control any player");
	public static final SlimefunItemStack SOUL_ROCK = new SlimefunItemStack("SOUL_ROCK", FireSlimeHeads.SOUL_ROCK, "&eSoul Rock", "", "&7A Rock that can bring back players from the dead");
	
}