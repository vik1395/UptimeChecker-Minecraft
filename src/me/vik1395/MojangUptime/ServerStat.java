package me.vik1395.MojangUptime;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;



public class ServerStat implements Runnable
{
	public void run()
	{
		
		URL url;	//Sets up a url variable.
	    URLConnection uj = null;	//Initializes the variable uj, used for connecting to the URL.
	    StringBuilder parsedContentFromUrl = new StringBuilder();
	    String urlString="http://xpaw.ru/mcstatus/status.json";
	    System.out.println("Getting content from http://xpaw.ru/mcstatus");
	    
	    try 
	    {
			url = new URL(urlString);	//sets the URL (http://xpaw.ru/mcstatus/status.json) to the url variable.
			uj = url.openConnection();	//Opens the connection to the URL
			uj.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");	//Queries the webpage disguised as a Web Browser so that it can open the link and read the Json file.
			uj.connect();	//This is where the plugin actually connects to the given URL.
			uj.getInputStream();	//Gets whatever is displayed on the web page.
			
			BufferedInputStream in = new BufferedInputStream(uj.getInputStream());	//Variable 'in' is given the details from the webpage.
			int ch;
			while ((ch = in.read()) != -1) 
			{
		       parsedContentFromUrl.append((char) ch);	//Uses the String Builder to create a string with the data in the variable 'in'
			}
	    }
		catch (MalformedURLException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	    
		String jsonData = parsedContentFromUrl.toString();	//Content in the StringBuilder is converted into a String.
		JsonParser parser = new JsonParser();				//Initializes the String-to-JsonObject Parser.
		JsonObject o = (JsonObject)parser.parse(jsonData);	//Converts the String from the website into a Json Object.
		JsonObject data = (JsonObject)o.get("report");		//Gets the Report Object inside the JSON file.
		
		String skins = data.getAsJsonObject("skins").get("status").toString();
		String realms = data.getAsJsonObject("realms").get("status").toString();
		String session = data.getAsJsonObject("session").get("status").toString();
		String website = data.getAsJsonObject("website").get("status").toString();
		String login = data.getAsJsonObject("login").get("status").toString();			//This piece of code gets the status of each mojang server from the json file.
		
		skins = skins.replace("\"", "");
		realms = realms.replace("\"", "");
		session = session.replace("\"", "");
		website = website.replace("\"", "");
		login = login.replace("\"", "");				//This piece of code removes the double quotations present around the string(s).
		
		//ONLY FOR TESTING PURPOSES: System.out.print("\n Skins:" + skins + "\n Realms:" + realms + "\n Session:" + session + "\n Website" + website + "\n Login" + login);	//Prints the status of servers (Up or Down) in the Server's console.
		
		if(!skins.equalsIgnoreCase("Up"))
		{
			System.out.println("skins.minecraft.net is offline.");
            Bukkit.broadcastMessage(ChatColor.GOLD + PluginStart.prefix + ChatColor.DARK_RED + " Warning: " + ChatColor.RED + PluginStart.skindn);
		}
		
		if(!realms.equalsIgnoreCase("Up"))
		{
			System.out.println("Minecraft Realms are offline.");
		}
		
		if(!session.equalsIgnoreCase("Up"))
		{
			System.out.println("session.minecraft.net is offline.");
		}
		
		if(!website.equalsIgnoreCase("Up"))
		{
			System.out.println("minecraft.net is offline.");
            Bukkit.broadcastMessage(ChatColor.GOLD + PluginStart.prefix + ChatColor.DARK_RED + " Warning: " + ChatColor.RED + PluginStart.web);
		}
		
		if(!login.equalsIgnoreCase("Up"))
		{
			System.out.println("login.minecraft.net is offline.");
            Bukkit.broadcastMessage(ChatColor.GOLD + PluginStart.prefix + ChatColor.DARK_RED + " Warning: " + ChatColor.RED + PluginStart.logdn);
		}
		
		//The if statements above check if any of the servers are down and send a message to the Server console, and Broadcast a warning message depending on the server that's down.
		
		
		if(login.equalsIgnoreCase("Up")&&skins.equalsIgnoreCase("Up")&&PluginStart.bcyes==true)
		{
			Bukkit.broadcastMessage(ChatColor.GOLD + PluginStart.prefix + ChatColor.GREEN + PluginStart.bothup);
		}
		
		if(login.equalsIgnoreCase("Up")&&skins.equalsIgnoreCase("Down")&&PluginStart.bcyes==true)
		{
			Bukkit.broadcastMessage(ChatColor.GOLD + PluginStart.prefix + ChatColor.GREEN + PluginStart.logup);
		}
		
		if(login.equalsIgnoreCase("Down")&&skins.equalsIgnoreCase("Up")&&PluginStart.bcyes==true)
		{
			Bukkit.broadcastMessage(ChatColor.GOLD + PluginStart.prefix + ChatColor.GREEN + PluginStart.skinup);
		}
		
		//Broadcasts the appropriate message, based on which of the two (Skins and Login) servers are up, If the user has enabled Broadcast message in the config.yml file.
		
	}

}
