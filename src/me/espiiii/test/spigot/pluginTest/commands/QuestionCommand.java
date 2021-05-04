package me.espiiii.test.spigot.pluginTest.commands;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.espiiii.test.spigot.pluginTest.type.QuestionType;


public class QuestionCommand implements CommandExecutor
{
	
	QuestionType question1 = new QuestionType("Qui est le plus beau dans le Staff d'OnyxWorld ?", "Espiiii", true);
	QuestionType question2 = new QuestionType("Qui est la gentille personne qui nous apprends la programmation ?", "ViViCouBar", true);
	QuestionType question3 = new QuestionType("Quand est mort Louis14", "jsp", true);
	//creation de la liste de question
	ArrayList<QuestionType> questions = new ArrayList<QuestionType>();
	public static QuestionType playerChoose;
	public static Player player;
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) 
	{
		questions.clear();
		questions.add(question1);
		questions.add(question2);
		questions.add(question3);
		
		if(sender instanceof Player) 
		{
			Player player = (Player) sender;
			
			if(args == null) 
			{
				
				player.sendMessage(ChatColor.RED + "[INFO]: Vous devez choisir une question. Pour lister les questions : /question list"); 
				
				return true;
				
			} 
			
			else if(args[0].equalsIgnoreCase("list"))
			{
				
				Integer questionsTotal =  questions.size();
				player.sendMessage(ChatColor.GREEN + "Vous devez choisir une chanson entre 1 et " + questionsTotal.toString());
				
				return true;
				
			}
			else if((Integer.parseInt(args[0]) >= 1) && (Integer.parseInt(args[0]) <= questions.size()))
				
				if((questions.get(Integer.parseInt(args[0])-1)).validity == false) 
				{
					
					player.sendMessage(ChatColor.RED + "La question choisie n'est plus valable.");
					
					return true;
					
				}else 
				{
					
					playerChoose = questions.get(Integer.parseInt(args[0])-1);
					player.sendMessage(ChatColor.BLUE+"[INFO]: "+playerChoose.question);
				}
				
			}else 
			{
				
				player.sendMessage(ChatColor.RED+"[INFO]: Erreur de syntaxe /help question pour plus d'information.");
				
			}
			
		
		
		
		return true;
	}
	
	public static boolean questionTester(QuestionType q, Player p, String a) 
	{
	
		if(a.equalsIgnoreCase(q.answer))
		{
			
			p.sendMessage(ChatColor.GREEN+"[INFO]: Bravo, tu as trouvé la réponse. Voici ta récompense.");
			p.getInventory().addItem(new ItemStack(Material.DIAMOND_PICKAXE));
			playerChoose.validity = false;
			
		} else p.sendMessage("[INFO]: Mauvaise Réponse.");
		playerChoose = null;
		return true;
	}
	
	/*
	 * @EventHandler
	void PlayerChatEvent(AsyncPlayerChatEvent event	) 
	{
		
		
		
		
	}
	*/

}
