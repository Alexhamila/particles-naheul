package me.alexandreh.fr.particlesnaheul;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_11_R1.command.CraftConsoleCommandSender;
import org.bukkit.craftbukkit.v1_11_R1.command.CraftRemoteConsoleCommandSender;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_11_R1.entity.CraftSnowball;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;

import net.minecraft.server.v1_11_R1.BlockAir;
import net.minecraft.server.v1_11_R1.PacketPlayOutEntityDestroy;

public class Particles implements CommandExecutor, Listener{

	Plugin plugin = Main.pl;
	static BukkitScheduler scheduler = Bukkit.getScheduler();
	Location previous_loc;
	static String damage_1;
	static String damage_2;
	static float damage;
	static int task2;
	static Snowball sb;
	
    private Map<UUID, Integer> runnableMap = new HashMap<UUID, Integer>();
	
	@Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(cmd.getName().equalsIgnoreCase("partspec")){
			
			if(sender instanceof Player){
				
				sender.sendMessage(ChatColor.RED + "Utilise /partspe pour les joueurs !");
				
			}else{

				if(args.length < 6){
					sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "NaheulCraft" + ChatColor.GRAY + "] "+ ChatColor.RED +  "Il manque des arguments, utilisation de la commande: /partspec <joueur> <type> <vitesse> <nombre de particules> <dommage> <force>" );
				}
				if(args.length == 6){
				
				String player_name = args[0];
				Player p = Bukkit.getPlayer(player_name);
				String effect_string = args[1];
				Particle particle = Converter.VanillatoBukkit(effect_string);
				int speed = Integer.parseInt(args[2]);
				int volume = Integer.parseInt(args[3]);
				damage_1 = args[4];
				damage_2 = args[4].replace("+", "");
				damage = Float.parseFloat(args[4].replace("-", ""));
				float power = Float.parseFloat(args[5]);
				
				Snowball sb = p.launchProjectile(Snowball.class);
				sb.setVelocity(p.getLocation().getDirection().multiply(speed));
				   
				for (Player pl : Bukkit.getOnlinePlayers()) {
					((CraftPlayer)pl).getHandle().playerConnection.sendPacket(new PacketPlayOutEntityDestroy(((CraftSnowball) sb).getHandle().getId()));
		        }
				
		        if(!runnableMap.containsKey(p.getUniqueId())) {
		            
		        	
		        	int taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
		 
		                @Override
		                public void run() {
		                  
		                	Bukkit.getWorld(sb.getWorld().getName()).spawnParticle(particle, sb.getLocation().getX(), sb.getLocation().getY(), sb.getLocation().getZ(), volume, 0, 0, 0, power);
		                			                	
		                	if(sb.isDead()){
		                		cancelRunnable(p);
		                	}
		                	
		                }
		 
		            }, 0, 1);
		        	runnableMap.put(p.getUniqueId(), taskID);
		        }
				
				
				}
				if(args.length > 6){
					sender.sendMessage(ChatColor.GRAY + "[" + ChatColor.AQUA + "NaheulCraft" + ChatColor.GRAY + "] " + ChatColor.RED + "Il y a trop d'arguments, utilisation de la commande: /partspec <joueur> <type> <vitesse> <nombre de particules> <dommage> <force>" );
				}
				
			}
		}
		
	return false;
		
	
	}
	
	public void cancelRunnable(Player player) {
        if(runnableMap.containsKey(player.getUniqueId())) {
            Bukkit.getScheduler().cancelTask(runnableMap.get(player.getUniqueId()));
            runnableMap.remove(player.getUniqueId());
        }
    }
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onHit(ProjectileHitEvent e){
		if(e.getEntity() instanceof Snowball){
			if(e.getEntity().getShooter() instanceof Player){			   
			if(e.getHitEntity() != null && e.getHitEntity() instanceof LivingEntity){
				if(Converter.DamageConvert(damage_1) == "-"){
				((LivingEntity)e.getHitEntity()).damage(damage);
				}
				
				else if(Converter.DamageConvert(damage_1) == "+"){
						
							double health_actual = ((LivingEntity)e.getHitEntity()).getHealth();
							double health_heal = damage;
							double health_max = ((LivingEntity)e.getHitEntity()).getMaxHealth();
							if(health_actual + health_heal > health_max){
								((LivingEntity)e.getHitEntity()).setHealth(health_max);
							}else{
								((LivingEntity)e.getHitEntity()).setHealth(health_actual + health_heal);
							}		
				}else{
			
				}
				
			}
			e.getEntity().remove();
			
		}
		}
		
	}
}