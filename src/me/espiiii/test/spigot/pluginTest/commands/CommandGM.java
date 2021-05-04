package me.espiiii.test.spigot.pluginTest.commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandGM implements CommandExecutor
{

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) 
	{
	
		if(sender instanceof Player)
		{
			if(args.length != 1) return true;
			
			Player player = (Player) sender;
			player.getName();
			switch(args[0])
			{
			
			case "0":
				player.setGameMode(GameMode.SURVIVAL);
				break;
			case "1":
				player.setGameMode(GameMode.CREATIVE);
				break;
			case "2":
				player.setGameMode(GameMode.ADVENTURE);
				break;
			case "3":
				player.setGameMode(GameMode.SPECTATOR);
				break;
			
			}
			
		}
		return true;

	}
	
}
