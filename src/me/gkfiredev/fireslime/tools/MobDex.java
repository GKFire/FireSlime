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
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Rare to find. Mooshrooms are Used to obtain either milk or mushroom stew.");
				break;
			case BAT:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Annoying, Useless. Why is this in the game?");
				break;
			case BEE:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": You Like Jazz?");
				break;
			case BLAZE:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": One of the most important mobs in the game. Without its blaze rod. It is nearly impossible to enter the end");
				break;
			case CAT:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Friendly little felions. Taming one of them requires patience and a fish. However they may bring something to you when your sleeping");
				break;
			case CAVE_SPIDER:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Poisonous, Smaller Spiders. They are hard to deal with.");
				break;
			case CHICKEN:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": A Great resource for gathering eggs to make food.");
				break;
			case COD:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Just keep swimming. Just keep swimming. Just keep swimming, swimming swimming");
				break;
			case COW:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": The Cow Jumped over Mars, or was it The Moon?");
				break;
			case CREEPER:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Awww man.");
				break;
			case DOLPHIN:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Having one of these creatures following you in water will give you Dolphin's Grace, which allows faster movement in water");
				break;
			case DONKEY:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": DONKEY! -Shrek");
				break;
			case DROWNED:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Originally a Zombie that didn't know how to swim.");
				break;
			case ELDER_GUARDIAN:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Can you really consider this a boss?");
				break;
			case ENDERMAN:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Useful for gathering pearls from. Or XP. both are useful.");
				break;
			case ENDERMITE:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Annoying ender version of the Silverfish");
				break;
			case ENDER_DRAGON:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": One of the most feared Bosses in Minecraft. Before the dark times. Before beds");
				break;
			case EVOKER:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Killing one of these will grant you a Totem of Undying. Saving the user before death. but you must be holding it.");
				break;
			case FOX:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": They will steal your items if they get the chance, but only one at a time. BUT THEIR SO CUTE WITH THAT DIAMOND IN THEIR MOUTH 0w0");
				break;
			case GHAST:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": White floating heads of the nether. They shoot fireballs if they see a player. They Drop Ghast Tears when killed. Which can later be used for regeneration potions");
				break;
			case GIANT:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Unnatural, Unknown, Not from this world. HOW THE HELL DID YOU FIND ONE!?");
				break;
			case GUARDIAN:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": With their lazer eye. They can do medium damage from a distance.");
				break;
			case HOGLIN:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Big pigs of the nether. They will slam into you a throw you into the air to deal massive damage");
				break;
			case HORSE:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Great for long distance travel. Dont get tired and can be healed with either potions or apples");
				break;
			case HUSK:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": These Zombies will inflict hunger to you if it hits you.");
				break;
			case ILLUSIONER:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Able to summon copies of itself. it will use any method it has of killing you. Good thing Mojang never fully added it into the game.");
				break;
			case IRON_GOLEM:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Protector of the villagers. This Iron Giant will become aggressive if anything attacks a villager. Even you.");
				break;
			case LLAMA:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Will spit at you if you injure them. So will their friends. and their friends. and their friends. and their friends. and their friends.");
				break;
			case MAGMA_CUBE:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Fire infested Slimes. they can do some damage to you if you aren't careful about your surroundings.");
				break;
			case MULE:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": The Result of cross breeding a horse with a donkey. It cannot be breed with even another mule.");
				break;
			case OCELOT:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": The precursor to cats.");
				break;
			case PANDA:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": They like Bamboo to munch on. And their so cute while eating.");
				break;
			case PARROT:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Will repeat any noise that they hear. Which can lead to many false alarms.");
				break;
			case PHANTOM:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Attracted to Players who havent slept in 3 days or more.");
				break;
			case PIG:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Food. Nothing else. Just food.");
				break;
			case PIGLIN:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Traders of the nether. They will trade with gold. But the results are what ever they feel like giving you.");
				break;
			case PIGLIN_BRUTE:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Buffed Piglins. They can be considered a boss in its own. Dealing massive damage and having insane health. You will need some great skill and gear to defeat them");
				break;
			case PILLAGER:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Will stop at no cost to defeat the villagers and take over the village.");
				break;
			case PLAYER:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Able to chop down trees with its bare hands. Able to survive any disease with advanced brewing. Will die of hunger");
				break;
			case POLAR_BEAR:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Living in the snow biomes. They will protect their young if it is ever injured.");
				break;
			case PUFFERFISH:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Will expand and give you poison if you get near them. But they can be used for some deadly traps..");
				break;
			case RABBIT:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": SHHHH. Im hunting wabbits.");
				break;
			case RAVAGER:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Unknown about their origin. But i dont think you'll like it.");
				break;
			case SALMON:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Very tasty compared to cod.");
				break;
			case SHEEP:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Useful for beds. which can kill a dragon. I know right? So realistic");
				break;
			case SHULKER:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Will summon bullets to levitate you into the atmosphere.");
				break;
			case SILVERFISH:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Found in the stronghold where the end portal is. They dont do much damage. But are hard to hit.");
				break;
			case SKELETON:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": With there bow and arrows. They will annoy every Player til the end of time");
				break;
			case SKELETON_HORSE:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Rare to find. If approched, a wave of skeleton riders with spawn and try to kill you.");
				break;
			case SLIME:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Cute and funny. They can only jump around.");
				break;
			case SNOWMAN:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Do you want to build a snowman?");
				break;
			case SPIDER:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": They will jump on you to deal damage. And will climb walls to get to your location");
				break;
			case SQUID:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Its a Squid. Its dream is to take over the world, and there is nothing we can do to stop it.");
				break;
			case STRAY:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": More powerful Skeletons. They shoot slowness arrows to prevent their target from escaping");
				break;
			case STRIDER:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": They can walk on lava. and are rideable. Useful for traveling in the nether");
				break;
			case TRADER_LLAMA:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": A Wandering trader's companion. It will protect its owner if they are ever injured");
				break;
			case TROPICAL_FISH:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Under Da Sea!");
				break;
			case TURTLE:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": When their babies grow up. They drop turtle sheels that can be used to make a turtle helmet. which offers water breathing for a limited time.");
				break;
			case VEX:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Spirits Summoned by an Evoker. They can travel through walls and are annoying to deal with.");
				break;
			case VILLAGER:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Useful Entities that trade items for emeralds and vice versa. However it is a pain to transport these Mobs");
				break;
			case VINDICATOR:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": HERES JOHNNY!");
				break;
			case WANDERING_TRADER:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Throughout the land. The Wandering Trader looks for unsuspecting Players to trade items for emeralds. But his trades are not all too good.");
				break;
			case WITCH:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": A Villager that became obsessed with brewing. Outcased as a Witch. It became insane and turned on its kind. It throws potions at players to injure them");
				break;
			case WITHER:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": A Being so Strong, that only a moral being can summon this beast. It Shoots Wither Heads that explode upon impact");
				break;
			case WITHER_SKELETON:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Gathering Heads from these mobs can be used to spawn the Wither, the most powerful boss in Minecraft");
				break;
			case WOLF:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": Steve's Best Friend. Taming one of these");
				break;
			case ZOGLIN:
				p.sendMessage(prefix + entity.getType().name().toUpperCase() + ": A former Piglin that became a Zoglin when it was exposed to the sun for too long.");
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
