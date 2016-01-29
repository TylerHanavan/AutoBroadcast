package com.TylerHanavan.AutoBroadcast;

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
			
			player.sendMessage(this.autoBroadcast.interpret(this.autoBroadcast.getPrefix() + this.autoBroadcast.getMessages().get(this.count)));
			
		}
		
		this.count++;
		
		if(this.count == this.autoBroadcast.getMessages().size()){
			
			this.count = 0;
			
		}
		
	}

}
