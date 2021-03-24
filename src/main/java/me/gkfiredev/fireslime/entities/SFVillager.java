package me.gkfiredev.fireslime.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Villager.Profession;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.VillagerAcquireTradeEvent;
import org.bukkit.event.entity.VillagerCareerChangeEvent;
import org.bukkit.event.entity.VillagerCareerChangeEvent.ChangeReason;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.persistence.PersistentDataType;

import io.github.thebusybiscuit.slimefun4.core.categories.SeasonalCategory;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;
import me.gkfiredev.fireslime.FireSlime;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import net.md_5.bungee.api.ChatColor;

public class SFVillager implements Listener {
	
	private static final String KEY = "slimefunvillager";
	
	private static List<Category> cheapSelection = new ArrayList<>();
	private static List<Category> selection = new ArrayList<>();
	
	@EventHandler
	public void villagerGainProfession(VillagerCareerChangeEvent event) {
		Villager vil = event.getEntity();
		if(event.getReason().equals(ChangeReason.EMPLOYED)) {
			if(event.getProfession().equals(Profession.TOOLSMITH)) {
				int chance = new Random().nextInt(100) + 1;
				if(chance <= FireSlime.getCfg().getInt("options.slimefunVillagerChance")) {
					Category category = getRandomCategory();
					vil.getPersistentDataContainer().set(new NamespacedKey(FireSlime.getPlugin(), KEY), PersistentDataType.STRING, getIDName(category));
					// vil.setMetadata(KEY, new FixedMetadataValue(FireSlime.getPlugin(), 1));
					List<MerchantRecipe> trades = getRandomTrades(getIDName(category), vil.getRecipeCount(), ((vil.getVillagerLevel() * 5) + 1));
					vil.setRecipes(trades);
				}
			} else if(event.getProfession().equals(Profession.NONE)) {
				if(vil.getPersistentDataContainer().has(new NamespacedKey(FireSlime.getPlugin(), KEY), PersistentDataType.STRING)) {
					vil.getPersistentDataContainer().remove(new NamespacedKey(FireSlime.getPlugin(), KEY));
					// vil.removeMetadata(KEY, FireSlime.getPlugin());
				}
			}
		}
	}
	
	@EventHandler
	public void sfVillagerAcquireTrade(VillagerAcquireTradeEvent ev) {
		Villager vil = (Villager) ev.getEntity();
		if(vil.getPersistentDataContainer().has(new NamespacedKey(FireSlime.getPlugin(), KEY), PersistentDataType.STRING)) {
			String id = vil.getPersistentDataContainer().get(new NamespacedKey(FireSlime.getPlugin(), KEY), PersistentDataType.STRING);
			MerchantRecipe trade = getRandomTrade(id, (vil.getVillagerLevel() * 5) + 1);
			ev.setRecipe(trade);
			
		}
	}
	
	private List<MerchantRecipe> getRandomTrades(String id, int size, int xp) {
		List<MerchantRecipe> recipes = new ArrayList<>();
		for(int i = 0; i < size; i++) {
			recipes.add(getRandomTrade(id, xp));
		}
		return recipes;
	}
	
	private MerchantRecipe getRandomTrade(String id, int xp) {
		Category category = getCategoryFromUnlocalizedName(id);
		boolean cheap = isCheapCategory(category);
		int maxUses;
		if(cheap) {
			maxUses = new Random().nextInt(48) + 8;
		} else {
			maxUses = new Random().nextInt(8) + 1;		
		}

		SlimefunItem sfItem;
		do {
			sfItem = category.getItems().get(new Random().nextInt(category.getItems().size()));
		} while (sfItem.getRecipeType().equals(RecipeType.MULTIBLOCK));
		ItemStack item = new ItemStack(sfItem.getItem());
		boolean isFood = false;
		
		if(sfItem.getItem().hasItemMeta()) {
			if(sfItem.getItem().getItemMeta().hasLore()) {
				List<String> lore = sfItem.getItem().getItemMeta().getLore();
				for(String s : lore) {
					if(s.contains("hunger")) {
						isFood = true;
						break;
					}
				}
			}
		}
		if(isFood && !sfItem.getItem().getType().equals(Material.POTION)) {
			item.setAmount(new Random().nextInt(3) + 1);
		}
		
		if(sfItem.getItemName().toLowerCase().contains("dust")) {
			item.setAmount(new Random().nextInt(5) + 1);
		}
		MerchantRecipe trade = new MerchantRecipe(item, maxUses);
		List<ItemStack> payment = new ArrayList<>();
		if(cheap) {
			if(sfItem.getItemName().toLowerCase().contains("dust")) {
				payment.add(new ItemStack(Material.EMERALD));
				trade.setIngredients(payment);
			} else if(isFood) {
				payment.add(new ItemStack(Material.EMERALD, (new Random().nextInt(6) + 1)));
				trade.setIngredients(payment);
			} else {
				payment.add(new ItemStack(Material.EMERALD, (new Random().nextInt(16) + 1)));
				trade.setIngredients(payment);
			}
		} else {
			payment.add(new ItemStack(Material.EMERALD_BLOCK, (new Random().nextInt(42) + 16)));
			trade.setIngredients(payment);
		}
		trade.setExperienceReward(true);
		trade.setVillagerExperience(xp);
		return trade;
		
	}
	
	public static Category getRandomCategory() {
		int option = new Random().nextInt(2) + 1;
		List<Category> categories;
		if(option == 2) {
			categories = new ArrayList<>(cheapSelection);
		} else {
			categories = new ArrayList<>(selection);
		}
		Category category = categories.get(new Random().nextInt(categories.size()));
		return category;
	}
	
	
	public static void updateCategoryList() {
		cheapSelection.clear();
		selection.clear();
		for(Category category : SlimefunPlugin.getRegistry().getCategories()) {
			if(category instanceof SeasonalCategory) {
				cheapSelection.add(category);
				continue;
			}
			String name = ChatColor.stripColor(category.getUnlocalizedName()).toLowerCase();
			if(name.contains("useful items") || name.contains("food") || name.contains("resources") || name.contains("magical items") || name.contains("drinks") || name.contains("gear") || name.contains("storage") || name.contains("talismans") || name.contains("garden")) {
				cheapSelection.add(category);
			} else if(name.contains("energy") || name.contains("machines") || name.contains("gadgets")) {
				selection.add(category);
			}
		}
		Bukkit.broadcastMessage("------ Selected Categories [cheap] -------");
		for(Category category : cheapSelection) {
			Bukkit.getLogger().info(category.getUnlocalizedName());
		}
		Bukkit.broadcastMessage("------ Selected Categories [expencive] -------");
		for(Category category : selection) {
			Bukkit.getLogger().info(category.getUnlocalizedName());
		}
	}
	
	public static Category getCategoryFromUnlocalizedName(String unlocalizedName) {
		for(Category category : cheapSelection) {
			String name = getIDName(category);
			if(name.equals(unlocalizedName)) {
				return category;
			}
		}
		for(Category category : selection) {
			String name = getIDName(category);
			if(name.equals(unlocalizedName)) {
				return category;
			}
		}
		return null;
	}
	public static String getIDName(Category category) {
		String name = "";
		name = ChatColor.stripColor(category.getUnlocalizedName());
		name = name.toLowerCase();
		name.replaceAll(" ", "_");
		
		return name;
	}
	
	public static boolean isCheapCategory(Category category) {
		for(Category cheap : cheapSelection) {
			String cheapID = getIDName(cheap);
			if(cheapID.equals(getIDName(category))) return true;
		}
		return false;
	}
	
	
}
