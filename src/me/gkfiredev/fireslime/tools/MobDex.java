package me.gkfiredev.fireslime.tools;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.core.attributes.Rechargeable;
import io.github.thebusybiscuit.slimefun4.core.handlers.EntityInteractHandler;
import me.gkfiredev.fireslime.slimefun.FireRegistry;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.Slimefun;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import net.md_5.bungee.api.ChatColor;

public class MobDex extends SlimefunItem implements Rechargeable {
	
	public static final float COST = 0.5f;
	private static final String prefix = ChatColor.translateAlternateColorCodes('&', "&7[&fMob&cDex&7] &r");
	
	
	
	public MobDex(Category category, ItemStack item, String id, RecipeType recipeType, ItemStack[] recipe) {
		super(category, item, id, recipeType, recipe);

	}
	
	public MobDex(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
		super(category, item, recipeType, recipe);
	}






	private EntityInteractHandler getEntityInteractionHandler() {
		return (e, item, offhand) -> {
			Player p = e.getPlayer();
			Entity entity = e.getRightClicked();
			e.setCancelled(true);
			if(Slimefun.hasUnlocked(p, FireRegistry.MOB_DEX, true))
			switch (entity.getType()) {
			case MUSHROOM_COW:
				p.sendMessage(prefix + "");
				break;
			case BAT:
				p.sendMessage(prefix + "");
				break;
			case BEE:
				p.sendMessage(prefix + "");
				break;
			case BLAZE:
				p.sendMessage(prefix + "");
				break;
			case CAT:
				p.sendMessage(prefix + "");
				break;
			case CAVE_SPIDER:
				p.sendMessage(prefix + "");
				break;
			case CHICKEN:
				p.sendMessage(prefix + "");
				break;
			case COD:
				p.sendMessage(prefix + "");
				break;
			case COW:
				p.sendMessage(prefix + "");
				break;
			case CREEPER:
				p.sendMessage(prefix + "");
				break;
			case DOLPHIN:
				p.sendMessage(prefix + "");
				break;
			case DONKEY:
				p.sendMessage(prefix + "");
				break;
			case DROWNED:
				p.sendMessage(prefix + "");
				break;
			case ELDER_GUARDIAN:
				p.sendMessage(prefix + "");
				break;
			case ENDERMAN:
				p.sendMessage(prefix + "");
				break;
			case ENDERMITE:
				p.sendMessage(prefix + "");
				break;
			case ENDER_DRAGON:
				p.sendMessage(prefix + "");
				break;
			case EVOKER:
				p.sendMessage(prefix + "");
				break;
			case FOX:
				p.sendMessage(prefix + "");
				break;
			case GHAST:
				p.sendMessage(prefix + "");
				break;
			case GIANT:
				p.sendMessage(prefix + "");
				break;
			case GUARDIAN:
				p.sendMessage(prefix + "");
				break;
			case HOGLIN:
				p.sendMessage(prefix + "");
				break;
			case HORSE:
				p.sendMessage(prefix + "");
				break;
			case HUSK:
				p.sendMessage(prefix + "");
				break;
			case ILLUSIONER:
				p.sendMessage(prefix + "");
				break;
			case IRON_GOLEM:
				p.sendMessage(prefix + "");
				break;
			case LLAMA:
				p.sendMessage(prefix + "");
				break;
			case MAGMA_CUBE:
				p.sendMessage(prefix + "");
				break;
			case MULE:
				p.sendMessage(prefix + "");
				break;
			case OCELOT:
				p.sendMessage(prefix + "");
				break;
			case PANDA:
				p.sendMessage(prefix + "");
				break;
			case PARROT:
				p.sendMessage(prefix + "");
				break;
			case PHANTOM:
				p.sendMessage(prefix + "");
				break;
			case PIG:
				p.sendMessage(prefix + "");
				break;
			case PIGLIN:
				p.sendMessage(prefix + "");
				break;
			case PIGLIN_BRUTE:
				p.sendMessage(prefix + "");
				break;
			case PILLAGER:
				p.sendMessage(prefix + "");
				break;
			case PLAYER:
				p.sendMessage(prefix + "");
				break;
			case POLAR_BEAR:
				p.sendMessage(prefix + "");
				break;
			case PUFFERFISH:
				p.sendMessage(prefix + "");
				break;
			case RABBIT:
				p.sendMessage(prefix + "");
				break;
			case RAVAGER:
				p.sendMessage(prefix + "");
				break;
			case SALMON:
				p.sendMessage(prefix + "");
				break;
			case SHEEP:
				p.sendMessage(prefix + "");
				break;
			case SHULKER:
				p.sendMessage(prefix + "");
				break;
			case SILVERFISH:
				p.sendMessage(prefix + "");
				break;
			case SKELETON:
				p.sendMessage(prefix + "");
				break;
			case SKELETON_HORSE:
				p.sendMessage(prefix + "");
				break;
			case SLIME:
				p.sendMessage(prefix + "");
				break;
			case SNOWMAN:
				p.sendMessage(prefix + "");
				break;
			case SPIDER:
				p.sendMessage(prefix + "");
				break;
			case SQUID:
				p.sendMessage(prefix + "");
				break;
			case STRAY:
				p.sendMessage(prefix + "");
				break;
			case STRIDER:
				p.sendMessage(prefix + "");
				break;
			case TRADER_LLAMA:
				p.sendMessage(prefix + "");
				break;
			case TROPICAL_FISH:
				p.sendMessage(prefix + "");
				break;
			case TURTLE:
				p.sendMessage(prefix + "");
				break;
			case VEX:
				p.sendMessage(prefix + "");
				break;
			case VILLAGER:
				p.sendMessage(prefix + "");
				break;
			case VINDICATOR:
				p.sendMessage(prefix + "");
				break;
			case WANDERING_TRADER:
				p.sendMessage(prefix + "");
				break;
			case WITCH:
				p.sendMessage(prefix + "");
				break;
			case WITHER:
				p.sendMessage(prefix + "");
				break;
			case WITHER_SKELETON:
				p.sendMessage(prefix + "");
				break;
			case WOLF:
				p.sendMessage(prefix + "");
				break;
			case ZOGLIN:
				p.sendMessage(prefix + "");
				break;
			case ZOMBIE:
				p.sendMessage(prefix + "");
				break;
			case ZOMBIE_HORSE:
				p.sendMessage(prefix + "");
				break;
			case ZOMBIE_VILLAGER:
				p.sendMessage(prefix + "");
				break;
			case ZOMBIFIED_PIGLIN:
				p.sendMessage(prefix + "");
				break;
			default:
				p.sendMessage(prefix + "ERROR: Unknown Mob! Perhaps the Archives are Incomplete...");
				break;
			}
			removeItemCharge(item, COST);
		};
	}
	
	
	
	
	
	
	@Override
	public void preRegister() {
		super.preRegister();
		addItemHandler(getEntityInteractionHandler());
		
	}


	@Override
	public float getMaxItemCharge(ItemStack item) {
		// TODO Auto-generated method stub
		return 10.0f;
	}
	
}
