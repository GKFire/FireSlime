package me.gkfiredev.fireslime.tools;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.core.attributes.Rechargeable;
import io.github.thebusybiscuit.slimefun4.core.handlers.EntityInteractHandler;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import net.md_5.bungee.api.ChatColor;

public class MobDex extends SlimefunItem implements Rechargeable {
	
	public static final float COST = 0.3f;
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
			if(MobDex.getByItem(item) == null) return;
			MobDex dex = (MobDex) MobDex.getByItem(item);
			if(dex.getItemCharge(item) <= 0.0f) return;
			switch (entity.getType()) {
			case MUSHROOM_COW:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": ");
				break;
			case BAT:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case BEE:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case BLAZE:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case CAT:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Friendly little felions. Taming one of them requires patience and a fish. However they may bring something to you when your sleeping");
				break;
			case CAVE_SPIDER:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case CHICKEN:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case COD:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case COW:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case CREEPER:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case DOLPHIN:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case DONKEY:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case DROWNED:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case ELDER_GUARDIAN:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case ENDERMAN:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case ENDERMITE:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case ENDER_DRAGON:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case EVOKER:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case FOX:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case GHAST:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case GIANT:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Unnatural, Unknown, Not from this world. HOW THE HELL DID YOU FIND ONE!?");
				break;
			case GUARDIAN:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case HOGLIN:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case HORSE:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case HUSK:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case ILLUSIONER:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case IRON_GOLEM:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case LLAMA:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case MAGMA_CUBE:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case MULE:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case OCELOT:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case PANDA:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case PARROT:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case PHANTOM:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case PIG:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case PIGLIN:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case PIGLIN_BRUTE:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case PILLAGER:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case PLAYER:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Able to chop down trees with its bear hands. Able to survive any disease with advanced brewing. Will die of hunger");
				break;
			case POLAR_BEAR:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case PUFFERFISH:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case RABBIT:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case RAVAGER:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case SALMON:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case SHEEP:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case SHULKER:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case SILVERFISH:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case SKELETON:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case SKELETON_HORSE:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case SLIME:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case SNOWMAN:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case SPIDER:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case SQUID:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case STRAY:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case STRIDER:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case TRADER_LLAMA:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case TROPICAL_FISH:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case TURTLE:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case VEX:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case VILLAGER:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case VINDICATOR:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case WANDERING_TRADER:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Throughout the land. The Wandering Trader looks for unsuspecting Players to trade items for emeralds. But his trades are not all too good.");
				break;
			case WITCH:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": A Being so Strong, that only a moral being can summon this beast. It Shoots Wither Heads that explode upon impact");
				break;
			case WITHER:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case WITHER_SKELETON:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case WOLF:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Steve's Best Friend. Taming one of these");
				break;
			case ZOGLIN:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + "");
				break;
			case ZOMBIE:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": A former fellow Player, before it was killed by an undead entity.");
				break;
			case ZOMBIE_HORSE:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Very rare to find out in the wild. It is unknown about the origin of the Zombie Horse");
				break;
			case ZOMBIE_VILLAGER:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": This Mob use to be a normal Villager, but after an encounter with a Zombie or another Zombie Villager, it became undead");
				break;
			case ZOMBIFIED_PIGLIN:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": This Mob originally was a Piglin, however the sun of the overworld burned it to the point of death. Now Revived to a undead version of its former self.");
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
		return 15.0f;
	}
	
}
