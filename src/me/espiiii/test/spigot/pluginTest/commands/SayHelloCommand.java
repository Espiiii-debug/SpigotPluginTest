package me.espiiii.test.spigot.pluginTest.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class SayHelloCommand implements CommandExecutor
{

	public boolean onCommand( CommandSender sender, Command cmd, String label, String[] args ) {
		
		if(args.length != 1) return true;
		if(sender instanceof Player)
		{
			Player player = (Player) sender;
			
			if(args.length != 1) return true;
			Bukkit.getConsoleSender().sendMessage(player.getDisplayName() + " a dit bonjour à " + args[0]);
			Bukkit.broadcastMessage(ChatColor.BOLD + "Le joueur " + player.getDisplayName() + " dit bonjour à " + args[0]);
			
		}
		if(sender instanceof ConsoleCommandSender) 
		{
		
			Bukkit.getConsoleSender().sendMessage("La console a dit bonjour à " + args[0]);
			Bukkit.broadcastMessage(ChatColor.BOLD + "Le console a dit bonjour à " + args[0]);
			
		}
		
		return true;
	}
	
}
