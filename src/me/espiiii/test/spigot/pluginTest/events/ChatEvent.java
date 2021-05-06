package me.espiiii.test.spigot.pluginTest.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.espiiii.test.spigot.pluginTest.commands.AnagramCommand;
import me.espiiii.test.spigot.pluginTest.commands.QuestionCommand;
import me.espiiii.test.spigot.pluginTest.type.AnagramType;
import me.espiiii.test.spigot.pluginTest.type.QuestionType;

public class ChatEvent implements Listener 
{
	
	@EventHandler
	public void PlayerChatEvent(AsyncPlayerChatEvent e)
	{
		QuestionType questionChoose = QuestionCommand.playerChoose;
		Player questionPlayer = QuestionCommand.player;
		
		AnagramType anagramChoose = AnagramCommand.anagramChoice;
		Player anagramPlayer = AnagramCommand.player;
		
		if(anagramChoose != null)
		{
			
			if(e.getPlayer() != anagramPlayer) return;
			String m = e.getMessage();
			e.setCancelled(AnagramCommand.anagramTester(anagramChoose, anagramPlayer, m));
			
		}
		
		if(questionChoose != null) 
		{
		
			if(e.getPlayer() != questionPlayer) return;
			String m = e.getMessage();
			e.setCancelled(QuestionCommand.questionTester(questionChoose, questionPlayer, m));
			
		}
		return;
		
	}
	
}
