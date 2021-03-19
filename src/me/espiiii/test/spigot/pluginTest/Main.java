package me.espiiii.test.spigot.pluginTest;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import me.espiiii.test.spigot.pluginTest.commands.CommandKit;
import me.espiiii.test.spigot.pluginTest.commands.SayHelloCommand;

public class Main extends JavaPlugin
{

	final static public String name = "TestPlugin";
	final static public String author = "Espiiii";
	final static public String version = "1.0.0 SNAPSHOT";
	final static public String description = "Plugin utilis� pour des tests.";
	
	@Override
	public void onEnable() 
	{
		
		Bukkit.getConsoleSender().sendMessage(ChatColor.GOLD + "Vous avez install� le plugin d'Espiiii. Il est nomm� "+name);
		this.getCommand("kit").setExecutor(new CommandKit());
		this.getCommand("welcome").setExecutor(new SayHelloCommand());
		
		super.onDisable();
	}
	@Override
	public void onDisable() 
	{
		
		Bukkit.getConsoleSender().sendMessage(ChatColor.BLUE + "Bonne journ�e, J'esp�re que le plugin " + name + " vous aura plu !");
		super.onDisable();
		
	}
	
	
	
}
