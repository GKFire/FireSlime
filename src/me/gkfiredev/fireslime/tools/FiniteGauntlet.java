package me.gkfiredev.fireslime.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.chat.ChatColors;

public class FiniteGauntlet extends SlimefunItem {
	
	private static final NamespacedKey usageKey = new NamespacedKey(SlimefunPlugin.instance(), "finitegauntlet_usage");
	public static final int MAX_USES = 2;
	public static final int delay = 3;
	
	
	public FiniteGauntlet(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
		super(category, item, recipeType, recipe);
	}
	
	
	@Override
	public void preRegister() {
		super.preRegister();
		ItemUseHandler ItemUse = this::getItemHandler;
		addItemHandler(ItemUse);
		
	}
	
	
	
	
	private ItemUseHandler getItemHandler(PlayerRightClickEvent event) {
		Player p = event.getPlayer();
		ItemStack item = event.getItem();
		event.cancel();
		if(p.getHealth() != p.getHealthScale()) {
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', SlimefunPlugin.getCfg().getString("options.chat-prefix") + "&cYou are Too Weak to use the finite gauntlet again! You must be at full health to use the Gauntlet!"));
			return null;
		}
		if(Bukkit.getOnlinePlayers().size() == 1) {
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', SlimefunPlugin.getCfg().getString("options.chat-prefix") + "&cThere is no one else on the server! Why would you waste the power of the Finite Gauntlet?"));
			return null;
		}
		useGauntlet(p, item);
		return null;
	}


	private void useGauntlet(Player p, ItemStack item) {
		if(p.getGameMode() != GameMode.CREATIVE) {
			EntityDamageEvent event = new EntityDamageEvent(p, DamageCause.CUSTOM, 1.0);
			Bukkit.getPluginManager().callEvent(event);
			
			if(!event.isCancelled()) {
				p.setHealth(event.getDamage());
			}
		}

		ItemMeta meta = item.getItemMeta();
		int usesLeft = meta.getPersistentDataContainer().getOrDefault(usageKey, PersistentDataType.INTEGER, MAX_USES);
		if(usesLeft == 1) {
			p.playSound(p.getLocation(), Sound.ENTITY_ITEM_BREAK, 1, 1);
			item.setAmount(0);
		}
		for(Player target : Bukkit.getOnlinePlayers()) target.playSound(p.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_IMPACT, 2, 1);
		Bukkit.broadcastMessage(ChatColors.color(SlimefunPlugin.getCfg().getString("options.chat-prefix") + ChatColor.GOLD + p.getName() + ChatColor.LIGHT_PURPLE + " snapped their fingers!"));
		List<Player> DustPlayers = new ArrayList<Player>();
		List<Player> players = new ArrayList<Player>();
		for(Player target : Bukkit.getOnlinePlayers()) { players.add(target); }
		players.remove(p);
		for(int i = 0; i <= Math.round((players.size() / 2)); i++) {
			int ran = new Random().nextInt(players.size());
			DustPlayers.add(players.get(ran));
			players.get(ran).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, (delay+2)*20, 1));
			players.remove(ran);
		}
		Bukkit.getScheduler().scheduleSyncDelayedTask(SlimefunPlugin.instance(), new Runnable() {

			@Override
			public void run() {
				for(Player target : DustPlayers) {
					target.kickPlayer("You should of aimed for the head.");
				}

			}
		}, delay*20);

		usesLeft--;
		meta.getPersistentDataContainer().set(usageKey, PersistentDataType.INTEGER, usesLeft);

		List<String> lore = meta.getLore();
		lore.set(5, ChatColors.color("&7Uses Left: &e" + usesLeft));
		meta.setLore(lore);
		item.setItemMeta(meta);

	}
	
	
	
	
}
