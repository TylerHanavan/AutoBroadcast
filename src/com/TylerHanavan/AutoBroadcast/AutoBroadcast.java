package com.TylerHanavan.AutoBroadcast;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class AutoBroadcast extends JavaPlugin {
	
	private List<String> messages = null;
	
	private String prefix = null;
	
	private int interval = 90;

	@Override
	public void onEnable(){
		
		File file = new File(this.getDataFolder().getAbsolutePath() + File.separator + "config.yml");
		
		(new File(this.getDataFolder().getAbsolutePath())).mkdirs();
		
		YamlConfiguration yaml = YamlConfiguration.loadConfiguration(file);
		
		boolean save = false;
		
		if(!yaml.contains("interval")){
			
			yaml.set("interval", 90);
			
			save = true;
			
		}
		
		if(!yaml.contains("prefix")){
			
			yaml.set("prefix", "&f[&aAutoBroadcast&f] ");
			
			save = true;
			
		}
		
		if(!yaml.contains("messages")){
			
			List<String> messages = new ArrayList<String>();
			
			messages.add("Hello server! We hope you are enjoying your time!");
			messages.add("Did you know that 10/10 Minecraft players are AWESOME!");
			messages.add("Contact a staff member for help!");
			
			yaml.set("messages", messages);
			
			save = true;
			
		}
		
		this.messages = yaml.getStringList("messages");
		
		this.prefix = yaml.getString("prefix");
		
		this.interval = yaml.getInt("interval");
		
		if(save){
		
			try {
				
				yaml.save(file);
				
			} catch (IOException e) {
				
				e.printStackTrace();
				
			}
			
		}
		
		this.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Broadcaster(this), this.getInterval() * 20, this.getInterval() * 20);
		
	}
	
	@Override
	public void onDisable(){
		
		
		
	}
	
	public List<String> getMessages(){
		
		return this.messages;
		
	}
	
	public String getPrefix(){
		
		return this.prefix;
		
	}
	
	public int getInterval(){
		
		return this.interval;
		
	}
	
}
