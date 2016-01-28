package com.TylerHanavan.AutoBroadcast;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Broadcaster implements Runnable {
	
	private AutoBroadcast autoBroadcast = null;
	
	private int count = 0;
	
	public Broadcaster(AutoBroadcast autoBroadcast){
		
		this.autoBroadcast = autoBroadcast;
		
	}

	@Override
	public void run() {

		for(Player player : this.autoBroadcast.getServer().getOnlinePlayers()){
			
			player.sendMessage(this.interpret(this.autoBroadcast.getPrefix() + this.autoBroadcast.getMessages().get(this.count)));
			
		}
		
		this.count++;
		
		if(this.count == this.autoBroadcast.getMessages().size()){
			
			this.count = 0;
			
		}
		
	}
	
	public String interpret(String message){
		
		return message.replaceAll("&1", ChatColor.DARK_BLUE + "").replaceAll("&2", ChatColor.DARK_GREEN + "").replaceAll("&3", ChatColor.DARK_AQUA + "")
				.replaceAll("&4", ChatColor.DARK_RED + "").replaceAll("&5", ChatColor.DARK_PURPLE + "").replaceAll("&6", ChatColor.GOLD + "")
				.replaceAll("&7", ChatColor.GRAY + "").replaceAll("&8", ChatColor.DARK_GRAY + "").replaceAll("&9", ChatColor.DARK_BLUE + "")
				.replaceAll("&0", ChatColor.BLACK + "").replaceAll("&a", ChatColor.GREEN + "").replaceAll("&b", ChatColor.AQUA + "")
				.replaceAll("&c", ChatColor.RED + "").replaceAll("&d", ChatColor.LIGHT_PURPLE + "").replaceAll("&e", ChatColor.YELLOW + "")
				.replaceAll("&f", ChatColor.WHITE + "").replaceAll("&r", ChatColor.RESET + "").replaceAll("&l", ChatColor.BOLD + "")
				.replaceAll("&m", ChatColor.STRIKETHROUGH + "").replaceAll("&n", ChatColor.UNDERLINE + "").replaceAll("&k", ChatColor.MAGIC + "");
		
	}

}
