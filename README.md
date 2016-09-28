UptimeChecker is a plugin that checks all of Mojang's service statuses ([http://help.mojang.com/](http://help.mojang.com/)) and outputs a message in the console if any of Mojang's servers (related to Minecraft) are offline, and sends a broadcast if Login, Skins or Website servers are offline.

Please report any issues with this plugin [HERE](https://github.com/vik1395/UptimeChecker-Minecraft/issues)

If you like my work, please consider donating, I would greatly appreciate it. [![Image](https://www.paypalobjects.com/en_US/i/btn/btn_donate_LG.gif)](https://www.paypal.com/cgi-bin/webscr?cmd=_donations&business=vik1395lp%40gmail%2ecom&lc=US&item_name=Spigot%20Plugins&item_number=LegitPlay%2enet%20Plugin%20Dev&no_note=0&currency_code=USD&bn=PP%2dDonationsBF%3abtn_donateCC_LG%2egif%3aNonHostedGuest)

**Config File**
-------------
They config.yml looks similar to this:

    Interval: 5
    
    # Interval is the time in minutes between pings to the mojang server. Minimum interval is 1 minute.
    
    Broadcast: yes
    
    # Please type yes if a message should be broadcasted at every ping interval whether Login and Skin servers are online, else, type no.
    
    Prefix: [Mojang Servers]
    
    # Broadcast for Login Servers Up: Minecraft login servers are running smoothly.
    
    # Broadcast for Login Servers Down: Minecraft login servers are having problems, you might experience issues when trying to log in.
    
    # Broadcast for Skin Servers Up: Minecraft skin servers are running smoothly.
    
    # Broadcast for Skin Servers Down: Minecraft skin servers are experiencing problems.
    
    # Broadcast when Skin and Login servers are both up: Minecraft login and skin servers are running fine.
    
    # Broadcast for Minecraft Website Down: Minecraft.net is currently down.
    
    # Broadcasts will start with a golden Prefix followed by the user configured message in Red/Green depending upon the status of the server.

Here is an example of how the plugin works:

When login servers are Down:

![enter image description here](http://i.imgur.com/5q5ahvi.png?1)

When all servers are up:

![enter image description here](http://i.imgur.com/cNJ3UuB.png?1)

This plugin is licensed under [CC Attribution-NonCommercial-ShareAlike 4.0 International](http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en_US). 

In very basic terms, Do whatever you want with the code of this plugin, as long as you give credits to the author and/or the plugin itself.
