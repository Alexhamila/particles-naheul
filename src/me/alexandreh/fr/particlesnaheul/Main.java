package me.alexandreh.fr.particlesnaheul;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public class Main extends JavaPlugin {
	
	public static Main plugin;
	public static Plugin pl;
	public static PluginManager pm;
	public static BukkitScheduler bs;
	
		@Override
		public void onEnable() {
			getLogger().info(" ON!");
			pl = this;
			bs = Bukkit.getScheduler();
			regListeners();
			registerCommands();
		    }

		@Override
		public void onDisable(){
			getLogger().info("Plugin off");
		}
		
		public void regListeners(){
			Bukkit.getPluginManager().registerEvents(new Particles(), Main.pl);
		}
		
		public void registerCommands(){
			getCommand("partspe").setExecutor(new Particles());
			
			
		}
		public static Main instance;

}
