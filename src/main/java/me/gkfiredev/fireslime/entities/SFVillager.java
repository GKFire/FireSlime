package me.gkfiredev.fireslime.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Villager.Profession;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.VillagerAcquireTradeEvent;
import org.bukkit.event.entity.VillagerCareerChangeEvent;
import org.bukkit.event.entity.VillagerCareerChangeEvent.ChangeReason;
import org.bukkit.event.hanging.HangingBreakEvent.RemoveCause;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.MerchantRecipe;
import org.bukkit.metadata.FixedMetadataValue;

import io.github.thebusybiscuit.slimefun4.core.categories.SeasonalCategory;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunPlugin;
import me.gkfiredev.fireslime.FireSlime;
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
					vil.setMetadata(KEY, new FixedMetadataValue(FireSlime.getPlugin(), 1));
					List<MerchantRecipe> trades = getRandomTrades(vil.getRecipeCount(), ((vil.getVillagerLevel() * 5) + 1));
					vil.setRecipes(trades);
				}
			} else if(event.getProfession().equals(Profession.NONE)) {
				if(vil.hasMetadata(KEY)) {
					vil.removeMetadata(KEY, FireSlime.getPlugin());
				}
			}
		}
	}
	
	@EventHandler
	public void sfVillagerAcquireTrade(VillagerAcquireTradeEvent ev) {
		Villager vil = (Villager) ev.getEntity();
		if(vil.hasMetadata(KEY)) {
			MerchantRecipe trade = getRandomTrade((vil.getVillagerLevel() * 5) + 1);
			ev.setRecipe(trade);
			
		}
	}
	
	private List<MerchantRecipe> getRandomTrades(int size, int xp) {
		List<MerchantRecipe> recipes = new ArrayList<>();
		for(int i = 0; i < size; i++) {
			recipes.add(getRandomTrade(xp));
		}
		return recipes;
	}
	
	private MerchantRecipe getRandomTrade(int xp) {
		List<Category> categories;
		boolean cheap = false;
		int maxUses;
		if((new Random().nextInt(2) + 1) == 1) {
			categories = new ArrayList<>(selection);
			cheap = false;
			maxUses = new Random().nextInt(8) + 1;
		} else {
			categories = new ArrayList<>(cheapSelection);
			cheap = true;
			maxUses = new Random().nextInt(40) + 24;
		}
		Category category = categories.get(new Random().nextInt(categories.size()));
		SlimefunItem sfItem = category.getItems().get(new Random().nextInt(category.getItems().size()));
		ItemStack item = new ItemStack(sfItem.getItem());
		if(sfItem.getItemName().toLowerCase().contains("dust")) {
			item.setAmount(new Random().nextInt(5) + 1);
		}
		MerchantRecipe trade = new MerchantRecipe(item, maxUses);
		List<ItemStack> payment = new ArrayList<>();
		if(cheap) {
			if(sfItem.getItemName().toLowerCase().contains("dust")) {
				payment.add(new ItemStack(Material.EMERALD));
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
	
	
	public static void updateCategoryList() {
		cheapSelection.clear();
		selection.clear();
		for(Category category : SlimefunPlugin.getRegistry().getCategories()) {
			if(category instanceof SeasonalCategory) {
				cheapSelection.add(category);
				continue;
			}
			String name = ChatColor.stripColor(category.getUnlocalizedName()).toLowerCase();
			if(name.contains("weapons") || name.contains("tools") || name.contains("useful items") || name.contains("food") || name.contains("armor") || name.contains("resources") || name.contains("magical items") || name.contains("drinks") || name.contains("tools") || name.contains("gear") || name.contains("strorage") || name.contains("talismans")) {
				cheapSelection.add(category);
			} else if(name.contains("energy") || name.contains("machines") || name.contains("gadgets")) {
				selection.add(category);
			}
		}
	}
	
	
}
