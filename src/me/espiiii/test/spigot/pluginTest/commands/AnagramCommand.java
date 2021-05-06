package me.espiiii.test.spigot.pluginTest.commands;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

import me.espiiii.test.spigot.pluginTest.type.AnagramType;

public class AnagramCommand implements CommandExecutor
{
	
	public static AnagramType anagramChoice = null;
	public static Player player;
	static ArrayList<AnagramType> anagramList = AnagramType.defaultListAnagram();
	static ArrayList<AnagramType> anagramListUnactivated = new ArrayList<AnagramType>();
	static int randomNumber;
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(sender instanceof Player)
		{
			
			player = (Player) sender;
			
			if(args.length == 0) 
			{
				randomNumber = AnagramType.random(0, anagramList.size()-1);
				anagramChoice = anagramList.get(randomNumber);
				player.sendMessage(ChatColor.BLUE+"Trouvez l'anagram de "+ ChatColor.YELLOW + anagramChoice.anagram);
				
			}else if(args[0].equalsIgnoreCase("add"))
			{
				if(args.length != 2) 
					{
					
						player.sendMessage(ChatColor.RED+"[ERROR]: Vous devez respecter la structure de la commande /anagram add <word>");
						return true;
					}
				
				String word = args[1];
				anagramList.add(new AnagramType(word));
				player.sendMessage(ChatColor.BLUE+"L'anagrame " + ChatColor.YELLOW + word + ChatColor.BLUE + " a été ajouté.");
				
			}else if(args[0].equalsIgnoreCase("help"))
			{
				player.sendMessage("------| Help 'anagram' |------");
				player.sendMessage("/anagram add <word>");
				player.sendMessage("------------------------------");
			}
			
			
		}
		
		return true;
	}

	public static boolean anagramTester(AnagramType anagramChoose, Player anagramPlayer, String m) 
	{
	
		if(m.equalsIgnoreCase(anagramChoose.defaultWorld))
		{
			
			anagramPlayer.sendMessage(ChatColor.GREEN + "Bravo, tu as trouvé le bon anagrame !");
			anagramChoose.activity = false;
			anagramListUnactivated.add(anagramChoose);
			anagramList.remove(randomNumber);
			
			
		} else 
		{
		
			anagramPlayer.sendMessage(ChatColor.RED+"Mauvaise réponse, retente ta chance avec un autre mot !");
			
		}
		anagramChoice = null;
		return true;
	}

}
