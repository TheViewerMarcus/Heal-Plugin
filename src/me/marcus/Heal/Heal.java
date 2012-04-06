package me.marcus.Heal;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Heal extends JavaPlugin {

	public static Heal plugin;
	public final Logger logger = Logger.getLogger("Minecraft");

	public void onDisable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " is now disabled.");
	}

	public void onEnable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " version " + pdfFile.getVersion() + " is now enabled.");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
	{
		
		Player player = (Player) sender;
		
		if(player.isOp()) {
		
			if(commandLabel.equalsIgnoreCase("heal"))if (player.hasPermission("heal.healplugin")) {
 
			{
				if(args.length == 0)
				{				
					player.setHealth(20);
					player.setFoodLevel(20);
					player.sendMessage(ChatColor.GREEN + "Healed");
				} 
				else if (args.length == 1) 
				{
					if(player.getServer().getPlayer(args[0]) != null) 
					{				
						Player targetPlayer = player.getServer().getPlayer(args[0]);
						targetPlayer.setHealth(20);
						targetPlayer.setFoodLevel(20);
						
						player.sendMessage(ChatColor.GREEN + "Healing " + targetPlayer.getDisplayName());
						targetPlayer.sendMessage(ChatColor.GREEN + "Healed by " + player.getDisplayName());
					} 
					else
					{
						player.sendMessage(ChatColor.RED + "They're offline!");
					}
				}
				else if(args.length >1)
				{
					player.sendMessage(ChatColor.RED + "You put too many arugments!");
				} 
			}
		} else {
			player.sendMessage(ChatColor.YELLOW + "You do not have Permission.");
		}
	}
	return false;
  }
}

	