package me.espiiii.test.spigot.pluginTest.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.espiiii.test.spigot.pluginTest.commands.QuestionCommand;

public class ChatEvent implements Listener 
{
	
	@EventHandler
	public void PlayerChatEvent(AsyncPlayerChatEvent e)
	{
		e.getPlayer().sendMessage(e.getMessage());
		
		e.getPlayer().sendMessage(QuestionCommand.playerChoose.question);
		if(QuestionCommand.playerChoose.question == null) return;
		e.getPlayer().sendMessage("statut valide");
		if(e.getPlayer() != QuestionCommand.player) return;
		e.getPlayer().sendMessage("player verifié");
		String m = e.getMessage();
		
		e.setCancelled(QuestionCommand.questionTester(QuestionCommand.playerChoose, QuestionCommand.player, m));
		
	}
	
}
