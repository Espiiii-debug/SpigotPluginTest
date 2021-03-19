package me.espiiii.test.spigot.pluginTest.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class CommandKit implements CommandExecutor
{
	
	public boolean onCommand( CommandSender sender, Command command, String label, String[] args ) 
	{
		if( sender instanceof Player ) 
		{
			if(args.length != 1) return true;
			Player player = (Player) sender;
			if(args[0].equalsIgnoreCase("db")) {
				Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"db passed");
				
				ItemStack diamond = new ItemStack( Material.DIAMOND );
				ItemStack bricks = new ItemStack( Material.BRICK );
				
				bricks.setAmount(20);
				
				player.getInventory().addItem(bricks, diamond);
				player.sendMessage(ChatColor.GREEN+"Vous avez recu le kit Diamond Builder");
				
			}else if(args[0].equalsIgnoreCase("pvp")) {
				Bukkit.getConsoleSender().sendMessage(ChatColor.RED+"pvp passed");
				ItemStack diamondHelmet = new ItemStack(Material.DIAMOND_HELMET);
				ItemStack diamondChestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
				ItemStack diamondLeggings = new ItemStack(Material.DIAMOND_LEGGINGS);
				ItemStack diamondBoots = new ItemStack(Material.DIAMOND_BOOTS);
						
				
				
				player.getInventory().addItem(diamondHelmet, diamondChestplate, diamondLeggings, diamondBoots);
				player.getInventory().setChestplate(diamondChestplate);
				player.getInventory().setHelmet(diamondHelmet);
				player.getInventory().setLeggings(diamondLeggings);
				player.getInventory().setBoots(diamondBoots);
				player.getInventory().getBoots().addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
				player.getInventory().getBoots().addEnchantment(Enchantment.DURABILITY, 3);
				player.getInventory().getLeggings().addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
				player.getInventory().getChestplate().addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
				player.getInventory().getHelmet().addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
				
				
			}
			Bukkit.getConsoleSender().sendMessage(args[0]);
			player.sendMessage(ChatColor.DARK_GREEN+ "VOUS AVEZ UTILIS2 LA COMMANDE KIT");
		}
		
		return true;
	}
	
}
