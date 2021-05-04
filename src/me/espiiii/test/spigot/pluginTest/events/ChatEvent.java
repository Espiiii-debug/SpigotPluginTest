package me.espiiii.test.spigot.pluginTest.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.espiiii.test.spigot.pluginTest.commands.QuestionCommand;
import me.espiiii.test.spigot.pluginTest.type.QuestionType;

public class ChatEvent implements Listener 
{

	private QuestionType questionStatut = QuestionCommand.playerChoose;
	private Player p = QuestionCommand.player;
	
	@EventHandler
	public void PlayerChatEvent(AsyncPlayerChatEvent e)
	{
		e.getPlayer().sendMessage(e.getMessage());
		
		e.getPlayer().sendMessage(questionStatut.question);
		if(questionStatut == null) return;
		e.getPlayer().sendMessage("statut valide");
		if(e.getPlayer() != p) return;
		e.getPlayer().sendMessage("player verifié");
		String m = e.getMessage();
		
		e.setCancelled(QuestionCommand.questionTester(questionStatut, p, m));
		
	}
	
}
