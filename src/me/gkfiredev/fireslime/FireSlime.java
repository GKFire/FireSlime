package me.gkfiredev.fireslime;

import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import me.gkfiredev.fireslime.slimefun.FireCategories;
import me.gkfiredev.fireslime.slimefun.FireRegistry;
import me.gkfiredev.fireslime.tools.FiniteRock;

public class FireSlime extends JavaPlugin implements SlimefunAddon {
	
	
	
	@Override
	public void onEnable() {
		getLogger().info("FireSlime Active!");
		getLogger().info("Version: " + getDescription().getVersion());
		getLogger().info("Setting up Items...");
		FireCategories.FIRESLIME.register(this);
		FireCategories.FIREMACHINES.register(this);
		FireCategories.SDMC.register(this);
		registerFireSlimeItems();
		registerFireMachines();
		registerSDMCItems();
		for(FiniteRock rock : FiniteRock.rocks) { rock.register(this);}
	}
	
	@Override
	public void onDisable() {
		
	}
	
	public JavaPlugin getJavaPlugin() {
		// TODO Auto-generated method stub
		return this;
	}

	public String getBugTrackerURL() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void registerFireSlimeItems() {
		FireRegistry.MAGIC_ROD_I.register(this);
		FireRegistry.MAGIC_ROD_II.register(this);
		FireRegistry.MOB_DEX.register(this);
		
		FireRegistry.FINITE_GAUNTLET.register(this);
	}
	
	public void registerFireMachines() {
		
	}
	
	public void registerSDMCItems() {
		FireRegistry.LUCKSTONE.register(this);
	}

}
