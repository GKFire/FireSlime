package me.gkfiredev.fireslime.machines;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.Damageable;

import io.github.thebusybiscuit.slimefun4.core.attributes.EnergyNetComponent;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import me.gkfiredev.fireslime.FireSlime;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.Category;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.SlimefunItem;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.interfaces.InventoryBlock;
import me.mrCookieSlime.Slimefun.Objects.handlers.BlockTicker;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import me.mrCookieSlime.Slimefun.cscorelib2.item.CustomItem;

@SuppressWarnings("deprecation")
public class Decompiler extends SlimefunItem implements InventoryBlock, EnergyNetComponent {
	
	private final int[] border = {0,1,2,3,9,18,27,36,37,38,39};
	private final int[] inputBorder = {10,11,12,19,21,28,29,30};
	private final int[] outputBorder = {4,5,6,7,8,13,17,22,26,31,35,40,41,42,43,44};
	
	private final int[] input = {20};
	private final int[] output = {14,15,16, 23,24,25, 32,33,34};
	
	private static final int ENERGY_CONSUPTION = 120;
	
	
	public Decompiler(Category category, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
		super(category, item, recipeType, recipe);
		
		createPreset(this, this::constructMenu);
	}
	
    protected void constructMenu(BlockMenuPreset preset) {
        for (int i : border) {
            preset.addItem(i, new CustomItem(new ItemStack(Material.GRAY_STAINED_GLASS_PANE), " "), (p, slot, item, action) -> false);
        }
        for (int i : inputBorder) {
        	preset.addItem(i, new CustomItem(new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE), " "), (p, slot, item, action) -> false);
        }
        for (int i : outputBorder) {
        	preset.addItem(i, new CustomItem(new ItemStack(Material.ORANGE_STAINED_GLASS_PANE), " "), (p, slot, item, action) -> false);
        }
    }

	@Override
	public EnergyNetComponentType getEnergyComponentType() {
		return EnergyNetComponentType.CONSUMER;
	}

	@Override
	public int getCapacity() {
		return 600;
	}

	@Override
	public int[] getInputSlots() {
		return input;
	}

	@Override
	public int[] getOutputSlots() {
		return output;
	}

	@Override
	public void preRegister() {
		addItemHandler(new BlockTicker() {

			@Override
			public void tick(Block b, SlimefunItem sf, Config data) {
				Decompiler.this.tick(b);
			}

			@Override
			public boolean isSynchronized() {
				return true;
			}

		});
	}

	protected void tick(Block b) {
		BlockMenu inv = BlockStorage.getInventory(b);
		ItemStack inputItem = inv.getItemInSlot(input[0]);
		if(inputItem == null || inputItem.getType() == Material.AIR) return;
		if(getCharge(b.getLocation()) < ENERGY_CONSUPTION) return;
		if(inputItem.getItemMeta() instanceof Damageable) {
			if(FireSlime.getCfg().getBoolean("options.decompiler-acceptDamagableItems") == false) return;
			Damageable weapon = (Damageable) inputItem.getItemMeta();
			if(weapon.hasDamage()) return;
		}
		if(inputItem.getEnchantments().size() != 0) return;
		if(SlimefunItem.getByItem(inputItem) != null) return;
		List<Recipe> recipes = Bukkit.getRecipesFor(inputItem);
		ShapedRecipe selectedRecipe = null;
		for(Recipe recipe : recipes) {
			if(recipe instanceof ShapedRecipe) {
				ShapedRecipe shaped = (ShapedRecipe) recipe;
				if(shaped.getResult().getAmount() > 1) continue;
				selectedRecipe = shaped;
				break;
			}
		}
		if(selectedRecipe == null) return;
		if(isOutputEmpty(inv)) {
			removeCharge(b.getLocation(), ENERGY_CONSUPTION);
			inputItem.setAmount(inputItem.getAmount() -1);
			ItemStack[] matrix = createMatrix(selectedRecipe);
			for(int i = 0; i < matrix.length && i < output.length; i++) {
				if(matrix[i] == null) continue;
				if(matrix[i].getType() == Material.AIR) continue;
				inv.pushItem(matrix[i], output[i]);
			}
			
		}
	}
	
	private boolean isOutputEmpty(BlockMenu inv) {
		for(int slot : output) {
			if(inv.getItemInSlot(slot) != null) return false;
		}
		return true;
	}
	
	private ItemStack[] createMatrix(ShapedRecipe recipe) {
		List<ItemStack> matrix = new ArrayList<>();
		String list = "";
		for(String part : recipe.getShape()) {
			list = list + part;
		}
		for(int i = 0; i < list.length(); i++) {
			if(list.charAt(i) == ' ') {
				matrix.add(i, new ItemStack(Material.AIR));
				continue;
			}
			matrix.add(i, recipe.getIngredientMap().get(list.charAt(i)));
		}
		return matrix.toArray(new ItemStack[matrix.size()]);
	}

}
