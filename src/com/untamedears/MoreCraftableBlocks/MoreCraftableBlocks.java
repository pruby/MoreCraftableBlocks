package com.untamedears.MoreCraftableBlocks;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class MoreCraftableBlocks extends JavaPlugin {

    public static Logger log;
    public static String pluginName = "CraftableDoubleslabs";
    public static String version = "0.1.0";
    
    public void onEnable() {
		log = this.getLogger();
		
		ShapedRecipe stoneToDoubleSlab = new ShapedRecipe(new ItemStack(44, 6, (short) 0, (byte) 6));
		stoneToDoubleSlab.shape("sss", "sss").setIngredient('s', Material.STONE);
		Bukkit.addRecipe(stoneToDoubleSlab);
		
		ShapedRecipe slabToDoubleSlab = new ShapedRecipe(new ItemStack(44, 1, (short) 0, (byte) 6));
		slabToDoubleSlab.shape("s", "s").setIngredient('s', Material.STEP);
		Bukkit.addRecipe(slabToDoubleSlab);
		
		log.info(pluginName+" v"+version+" enabled!");
	}
	
	public void onDisable() {
		log.info(pluginName+" v"+version+" disabled!");
	}
    
}
