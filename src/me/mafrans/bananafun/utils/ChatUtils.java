package me.mafrans.bananafun.utils;

import me.mafrans.bananafun.BananaFun;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;


public class ChatUtils 
{
    private static BananaFun plugin = new BananaFun();
    
    public static void tellRaw(ChatColor color, String message, String hoverText, CommandSender sender, String reciever)
    {
        String realColor = translateTellRawColorCodes(color);
        if(hoverText == null)
        {
            plugin.server.dispatchCommand(sender, "/tellraw " + reciever + " [\"\",{\"text\":\"" + message + "\",\"color\":\"" + realColor + "\"}]");
        }
        else
        {
            plugin.server.dispatchCommand(sender, "/tellraw " + reciever + " [\"\",{\"text\":\"" + message + "\",\"color\":\"" + realColor + "\",\"hoverEvent\":{\"action\":\"show_text\",\"value\":{\"text\":\"\",\"extra\":[{\"text\":\""+ hoverText + "\"}]}}}]");
        }
    }
    
    public static void tellRaw(ChatColor color, String message, Material hoverIcon, CommandSender sender, String reciever)
    {
        String realColor = translateTellRawColorCodes(color);
        if(hoverIcon == null)
        {
            plugin.server.dispatchCommand(sender, "/tellraw " + reciever + " [\"\",{\"text\":\"" + message + "\",\"color\":\"" + realColor + "\"}]");
        }
        else
        {
            plugin.server.dispatchCommand(sender, "/tellraw " + reciever + " [\"\",{\"text\":\"" + message + "\",\"color\":\"" + realColor + "\",\"hoverEvent\":{\"action\":\"show_item\",\"value\":\"{id:\\\\\\\"" + String.valueOf(hoverIcon.getId()) + "\\\\\\\"}\"}}]");
        }
    }
    
    public static String translateTellRawColorCodes(ChatColor color)
    {
        switch(color)
        {
            case AQUA: return "aqua";
            case BLACK: return "black";
            case BLUE: return "blue";
            case DARK_BLUE: return "dark_blue";
            case DARK_GREEN: return "dark_green";
            case DARK_AQUA: return "dark_aqua";
            case DARK_RED: return "dark_red";
            case DARK_PURPLE: return "dark_purple";
            case GOLD: return "gold";
            case GRAY: return "gray";
            case DARK_GRAY: return "dark_gray";
            case GREEN: return "green";
            case RED: return "red";
            case LIGHT_PURPLE: return "light_purple";
            case YELLOW: return "yellow";
        }
        return "white";
    }
}
