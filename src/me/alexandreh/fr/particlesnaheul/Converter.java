package me.alexandreh.fr.particlesnaheul;

import org.bukkit.Bukkit;
import org.bukkit.Particle;

public class Converter {

	public static Particle VanillatoBukkit(String effect){
		switch(effect){
		case "angryVillager":
		return Particle.VILLAGER_ANGRY;
		case "barrier":	
		return Particle.BARRIER;
		case "blockcrack":	
		return Particle.BLOCK_CRACK;
		case "blockdust":	
		return Particle.BLOCK_DUST;
		case "bubble":
		return Particle.WATER_BUBBLE;	
		case "cloud":	
		return Particle.CLOUD;
		case "crit":
		return Particle.CRIT;
		case "damageIndicator":
		return Particle.DAMAGE_INDICATOR;	
		case "depthsuspend":
		return Particle.SUSPENDED_DEPTH;	
		case "dragonbreath":
		return Particle.DRAGON_BREATH;
		case "dripLava":
		return Particle.DRIP_LAVA;	
		case "dripWater":
		return Particle.DRIP_WATER;
		case "droplet":
		return Particle.WATER_DROP;	
		case "enchantmenttable":
		return Particle.ENCHANTMENT_TABLE;	
		case "endRod":
		return Particle.END_ROD;	
		case "explode":
		return Particle.EXPLOSION_NORMAL;	
		case "fallingdust":
		return Particle.FALLING_DUST;	
		case "fireworksSpark":
		return Particle.FIREWORKS_SPARK;	
		case "flame":
		return Particle.FLAME;	
		case "footstep":
		return Particle.FOOTSTEP;	
		case "happyVillager":
		return Particle.VILLAGER_HAPPY;	
		case "heart":
		return Particle.HEART;	
		case "hugeexplosion":
		return Particle.EXPLOSION_HUGE;	
		case "iconcrack":
		return Particle.ITEM_CRACK;	
		case "instantSpell":
		return Particle.SPELL_INSTANT;
		case "largeexplode":
		return Particle.EXPLOSION_LARGE;
		case "largesmoke":
		return Particle.SMOKE_LARGE;
		case "lava":
		return Particle.LAVA;
		case "magicCrit":
		return Particle.CRIT_MAGIC;	
		case "mobSpell":
		return Particle.SPELL_MOB;
		case "mobSpellAmbient":
		return Particle.SPELL_MOB_AMBIENT;	
		case "mobappearance":
		return Particle.MOB_APPEARANCE;	
		case "note":
		return Particle.NOTE;	
		case "portal":
		return Particle.PORTAL;	
		case "reddust":
		return Particle.REDSTONE;	
		case "slime":
		return Particle.SLIME;	
		case "smoke":
		return Particle.SMOKE_NORMAL;	
		case "snowballpoof":
		return Particle.SNOWBALL;	
		case "snowshovel":
		return Particle.SNOW_SHOVEL;	
		case "spell":
		return Particle.SPELL;	
		case "spit":
		return Particle.SPIT;	
		case "splash":
		return Particle.WATER_SPLASH;	
		case "suspended":
		return Particle.SUSPENDED;	
		case "sweepAttack":
		return Particle.SWEEP_ATTACK;
		case "take":
		return Particle.ITEM_TAKE;	
		case "totem":
		return Particle.TOTEM;	
		case "townaura":
		return Particle.TOWN_AURA;	
		case "wake":
		return Particle.WATER_WAKE;	
		case "witchMagic":
		return Particle.SPELL_WITCH;	
		}
		return Particle.FLAME;
		
			
		
	}
	
	public static String DamageConvert(String damage_1){
		
		if(damage_1.contains("-")){
			return "-";
		}else if(damage_1.contains("+")){
			return "+";
		}else{
			return "none";
		}
		}
		
		
		
	}
	
	

