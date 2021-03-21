package me.espiiii.test.spigot.pluginTest.events;

import java.util.Random;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class JoinEvent implements  Listener {
	
	public static Server plugin;
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event)
	{
	
		Player player = event.getPlayer();
								
		int min = 300;
		int max = 2500;
		
		int x = new Random().nextInt(max - min) + min;
		int z = new Random().nextInt(max - min) + min;
		
		Location loc = new Location(player.getWorld(), x, 0, z);
		
		int y = loc.getWorld().getHighestBlockYAt(loc);
		
		loc.setY(y);
		
		player.teleport(loc);
		
		if(player.getGameMode() != GameMode.SURVIVAL) player.setGameMode(GameMode.SURVIVAL);
		player.getInventory().clear();
		player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 256, 2));

		
		
	}

}
