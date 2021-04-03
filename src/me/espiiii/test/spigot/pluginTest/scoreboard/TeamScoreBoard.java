package me.espiiii.test.spigot.pluginTest.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;
import me.espiiii.test.spigot.pluginTest.scoreboard.*;



public class TeamScoreBoard
{
	public Scoreboard TeamScoreBoard(Player player, int teamType/*0 : Fire - 1 : Wood*/)
	{
		
		Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
		Objective obj = board.registerNewObjective("ServerName", "dummy", "Test Server");
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		
		Score onlineName = obj.getScore(ChatColor.GRAY + ">> Online");
		onlineName.setScore(15);
		
		Team onlineCounter = board.registerNewTeam("onlineCounter");
		onlineCounter.addEntry(ChatColor.BLACK+""+ChatColor.WHITE);
		
		if(teamType == 1) 
		{
			Team woodTeam = board.registerNewTeam("Bois");
			Score team = obj.getScore("your team is " + ChatColor.GREEN + "Wood");
			team.setScore(13);
		}
		if(teamType==0)
		{
			Team fireTeam = board.registerNewTeam("Feu");	
			Score team = obj.getScore("your team is " + ChatColor.DARK_RED + "Fire");
			team.setScore(13);
		}
		
		
		
		if(Bukkit.getOnlinePlayers().size() == 0) 
		{
			
			onlineCounter.setPrefix(ChatColor.DARK_RED + "0" + ChatColor.RED + "/" +ChatColor.DARK_RED + Bukkit.getMaxPlayers());
		
		}else 
		{
			
			onlineCounter.setPrefix("" + ChatColor.DARK_RED + Bukkit.getOnlinePlayers().size() + ChatColor.RED + "/" + ChatColor.DARK_RED + Bukkit.getMaxPlayers());
			
			
		}
		obj.getScore(ChatColor.BLACK + "" + ChatColor.WHITE).setScore(14);
		
		return board;
	}
}
