package me.espiiii.test.spigot.pluginTest;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import me.espiiii.test.spigot.pluginTest.commands.CommandGM;
import me.espiiii.test.spigot.pluginTest.commands.CommandKit;
import me.espiiii.test.spigot.pluginTest.commands.QuestionCommand;
import me.espiiii.test.spigot.pluginTest.commands.SayHelloCommand;
import me.espiiii.test.spigot.pluginTest.events.ChatEvent;
import me.espiiii.test.spigot.pluginTest.events.JoinEvent;
import me.espiiii.test.spigot.pluginTest.events.OnClickInventoryEvent;
import me.espiiii.test.spigot.pluginTest.gui.TeamSelectorGUI;

public class Main extends JavaPlugin
{

	final static public String name = "TestPlugin";
	final static public String author = "Espiiii";
	final static public String version = "1.0.0 SNAPSHOT";
	final static public String description = "Plugin utilisé pour des tests.";
	
	@Override
	public void onEnable() 
	{
		
		Bukkit.getConsoleSender().sendMessage(ChatColor.GOLD + "Vous avez installé le plugin d'Espiiii. Il est nommé "+name);
		this.getCommand("kit").setExecutor(new CommandKit());
		this.getCommand("welcome").setExecutor(new SayHelloCommand());
		this.getCommand("gm").setExecutor(new CommandGM());
		this.getCommand("question").setExecutor(new QuestionCommand());
		
		Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
		Bukkit.getPluginManager().registerEvents(new TeamSelectorGUI(), this);
		Bukkit.getPluginManager().registerEvents(new OnClickInventoryEvent(), this);
		Bukkit.getPluginManager().registerEvents(new ChatEvent(), this);
		
		
		
		super.onDisable();
	}
	@Override
	public void onDisable() 
	{
		
		Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE + "Bonne journée, J'espère que le plugin " + name + " vous aura plu !");
		super.onDisable();
		
	}
	
	

	
	
	
	
}
