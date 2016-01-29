package com.TylerHanavan.AutoBroadcast;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class BroadcastCommand implements CommandExecutor {
	
	private AutoBroadcast autoBroadcast = null;
	
	public BroadcastCommand(AutoBroadcast autoBroadcast){
		
		this.autoBroadcast = autoBroadcast;
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(label.equalsIgnoreCase("broadcast")){
			
			if(sender.hasPermission("AutoBroadcast.broadcast")){
				
				String message = "";
				
				for(String s : args){
					
					message += s;
					
				}
				
				Bukkit.broadcastMessage(this.autoBroadcast.interpret(this.autoBroadcast.getPrefix() + "&f" + message));
				
			}else{
				
				sender.sendMessage(this.autoBroadcast.interpret("&4You lack permission to send a manual broadcast."));
				
			}
			
		}
		
		return true;
	}

}
