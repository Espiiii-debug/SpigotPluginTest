package me.espiiii.test.spigot.pluginTest.events;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.espiiii.test.spigot.pluginTest.gui.TeamSelectorGUI;
import me.espiiii.test.spigot.pluginTest.scoreboard.TeamScoreBoard;

/* Description :
   Cette classe à pour but de Teleporter un joueur à un endroit aléatoire 
   du monde en lui donnant un effet de forceII pendant 256s dès 
   qu'il est connecté.
 */
public class JoinEvent implements  Listener {
	
	public static Inventory inventory;
	public static Server plugin;
	public static List<Player> woodTeamList = new ArrayList();
	public static List<Player> fireTeamList = new ArrayList();
	TeamSelectorGUI guiconnect = new TeamSelectorGUI();
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event)
	{
		Player player = event.getPlayer();
		ItemStack woodTeam = createGuiItem(Material.BIRCH_WOOD, "§l§6Equipe Bois", "§l§5/20 personnes", "§o§aClique pour rejoindre");
		ItemStack fireTeam = createGuiItem(Material.BLAZE_ROD, "§l§6Equipe Feu", "§l§5/20 personnes", "§o§aClique pour rejoindre");

								
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
		
		inventory = Bukkit.createInventory(null, 27, "Team Selector");
		
		inventory.setItem(11, fireTeam);
		inventory.setItem(15, woodTeam);
		
		player.openInventory(inventory);
		

		
		
	}
	TeamScoreBoard scoreboard;
	@EventHandler
public void onClick(InventoryClickEvent event)
{
	
	Inventory eventInventory = event.getInventory();
	Player player = (Player) event.getWhoClicked();
	ItemStack current = event.getCurrentItem();
	

	
	if(current == null)return;
	
	//ref=me.espiiii.test.spigot.pluginTest.events.JoinEvent
	if(event.getInventory() != inventory) return;
	
		
		if(current.getType()== Material.DARK_OAK_WOOD)
		{
			player.sendMessage("Team Bois frr");
			if(JoinEvent.woodTeamList.size() == 20) { player.sendMessage("Cette team est pleine."); return;}
			JoinEvent.woodTeamList.add(player);
			player.setScoreboard(scoreboard.TeamScoreBoard(player, 1));
		}
		if(current.getType()== Material.BLAZE_POWDER)
		{
			player.sendMessage("Team feu frrrrr");
			if(JoinEvent.woodTeamList.size() == 20) { player.sendMessage("Cette team est pleine."); return;}
			JoinEvent.woodTeamList.add(player);
			player.setScoreboard(scoreboard.TeamScoreBoard(player, 0));
		}
		if(event.getSlot() == 12) player.sendMessage("Slot 12 clicked");
		if (event.getSlot()==16) player.sendMessage("Slot 16 clicked");
		
	
	
	
}
	
	protected ItemStack createGuiItem(final Material material, final String name, final String... lore) {
        final ItemStack item = new ItemStack(material, 1);
        final ItemMeta meta = item.getItemMeta();

        meta.setDisplayName(name);

        meta.setLore(Arrays.asList(lore));

        item.setItemMeta(meta);
        
        return item;
    }

}
