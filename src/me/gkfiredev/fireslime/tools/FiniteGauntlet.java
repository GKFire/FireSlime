package me.gkfiredev.fireslime.tools;

import java.util.List;

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

import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;
import io.github.thebusybiscuit.slimefun4.implementation.items.SimpleSlimefunItem;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.cscorelib2.chat.ChatColors;

public class FiniteGauntlet extends SimpleSlimefunItem<ItemUseHandler> {
	
	private static final NamespacedKey usageKey = new NamespacedKey(SlimefunPlugin.instance(), "finitegauntlet_usage");
	public static final int MAX_USES = 3;
	
	
	public FiniteGauntlet(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
		super(category, item, recipeType, recipe);
	}


	@Override
	public ItemUseHandler getItemHandler() {
		return e -> {
			Player p = e.getPlayer();
			ItemStack item = e.getItem();
			
			if(p.getHealth() != p.getHealthScale()) {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', SlimefunPlugin.getCfg().getString("options.chat-prefix") + "&cYou are Too Weak to use the finite gauntlet again! You must be at full health to use the Gauntlet!"));
				return;
			}
			if(Bukkit.getOnlinePlayers().size() == 1) {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', SlimefunPlugin.getCfg().getString("options.chat-prefix") + "&cThere is no one else on the server! Why would you waste the power of the Finite Gauntlet?"));
				return;
			}
			useGauntlet(p, item);
		};
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
		} else {
			p.playSound(p.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_IMPACT, 2, 1);
			for(Player player : Bukkit.getOnlinePlayers()) {
				player.sendMessage(ChatColors.color(SlimefunPlugin.getCfg().getString("options.chat-prefix") + ChatColor.LIGHT_PURPLE + "GKFire snapped their fingers!"));
			}
			usesLeft--;
			meta.getPersistentDataContainer().set(usageKey, PersistentDataType.INTEGER, usesLeft);
			
			List<String> lore = meta.getLore();
			lore.set(5, ChatColors.color("&7Uses Left: &e" + usesLeft));
			meta.setLore(lore);
			item.setItemMeta(meta);
		}
		
	}
	
	
	
	
}
