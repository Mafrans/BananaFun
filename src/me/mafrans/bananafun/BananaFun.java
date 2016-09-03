package me.mafrans.bananafun;


import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import me.mafrans.bananafun.commands.*;
import me.mafrans.bananafun.items.*;
import me.mafrans.bananafun.listeners.BlockListener;
import me.mafrans.bananafun.listeners.PlayerListener;
import org.bukkit.Server;

public class BananaFun extends JavaPlugin implements Listener
{
    public static PlayerListener playerlistener = new PlayerListener();
    public static BlockListener  blocklistener  = new BlockListener();
    public static BananaFun      plugin;
    public FileConfiguration     config         = this.getConfig();
    public Server server = getServer();
    
    @Override
    public void onDisable()
    {
    }

    @Override
    public void onEnable()
    {
        // Register the plugin
        plugin = this;

        // Register the items
        Slapfish.registerItem();
        Instabow.registerItem();
        Bouncer.registerItem();
        Woolbow.registerItem();
        Enderdragon.registerItem();
        Dynamite.registerItem();
        Megaphone.registerItem();
        Magnet.registerItem();
        

        // Register the listeners
        getServer().getPluginManager().registerEvents(playerlistener, plugin);
        getServer().getPluginManager().registerEvents(blocklistener, plugin);

        // Register the commands
        plugin.getCommand("slapfish").setExecutor(new Command_slapfish());
        plugin.getCommand("instabow").setExecutor(new Command_instabow());
        plugin.getCommand("bouncer").setExecutor(new Command_bouncer());
        plugin.getCommand("woolbow").setExecutor(new Command_woolbow());
        plugin.getCommand("enderdragon").setExecutor(new Command_enderdragon());
        plugin.getCommand("dynamite").setExecutor(new Command_dynamite());
        plugin.getCommand("megaphone").setExecutor(new Command_megaphone());
        plugin.getCommand("magnet").setExecutor(new Command_magnet());
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
