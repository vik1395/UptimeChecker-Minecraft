package me.vik1395.MojangUptime;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class PluginStart extends JavaPlugin
{
	public void onEnable()
	{
		plugin = this;	//JavaPlugin needs to be initialized, as shown here.
		String path = getConfig().getString("Interval");	//Gets the user-configured Interval from the plugin's config.yml
		String bc = getConfig().getString("Broadcast");		//Gets the user-configured Interval from the plugin's config.yml
		prefix = getConfig().getString("Prefix");
		logup = getConfig().getString("Broadcast for Login Servers Up");
		logdn = getConfig().getString("Broadcast for Login Servers Down");
		skinup = getConfig().getString("Broadcast for Skin Servers Up");
		skindn = getConfig().getString("Broadcast for Skin Servers Down");
		web = getConfig().getString("Broadcast for Minecraft Website Down");
		bothup = getConfig().getString("Broadcast when Skin and Login servers are both up");
		
        if(bc.equals("true"))	//checks if User wants the plugin to send a broadcast message if login and skin servers are up.
        {
        	bcyes = true;	
        }
        else
        {
        	bcyes = false;
        }
        int minTime = Integer.parseInt(path);	//gets the user-input Interval in an integer variable.
        if(minTime<=1)	//Checks if given Interval is less than 1. If it is, the Interval is automatically changed to 1.
        {
        	minTime = 1;
        	System.out.println("[UptimeChecker] Minimum ping interval is 2 minutes.");
        	System.out.println("[UptimeChecker] Setting interval to 2 minutes");
        }
        int time = minTime*60*20;	//Converts Real Time Minutes to Server Ticks
        Runnable ServerStat = new ServerStat();
        Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, ServerStat, 0, time);	//Repeatedly runs the ServerStat class depending on the given Interval.
		getLogger().info("UptimeChecker has successfully started!");
		getLogger().info("Created by Vik1395");
		saveDefaultConfig();
	}
	
	public static JavaPlugin plugin;
	public static boolean bcyes;
	public static String logup;
	public static String logdn;
	public static String skinup;
	public static String skindn;
	public static String bothup;
	public static String web;
	public static String prefix;
}
