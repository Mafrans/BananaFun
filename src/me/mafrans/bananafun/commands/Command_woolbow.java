
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
 */
package me.mafrans.bananafun.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.mafrans.bananafun.items.Woolbow;
import static org.bukkit.Bukkit.getPlayer;

public class Command_woolbow implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if(args.length < 1)
        {
            sender.sendMessage("/" + cmd.getName() + " <get|give> <item> [player]");
            return false;
        }

        if(args[0].equalsIgnoreCase("get"))
        {
            if(args.length != 1)
            {
                sender.sendMessage("/" + cmd.getName() + " <get> <item>");
                return false;
            }

            sender.sendMessage(ChatColor.YELLOW + "Recieved item: " + Woolbow.metadata.getDisplayName());
            ((Player) sender).getInventory().addItem(Woolbow.item);

            return true;
        }
        
        if(args[0].equalsIgnoreCase("give"))
        {
            if(args.length != 2)
            {
                sender.sendMessage("/" + cmd.getName() + " <give> <item> <player>");
                return false;
            }
            Player player = getPlayer(args[1]);
            if(player == null)
            {
                sender.sendMessage(ChatColor.YELLOW + "Could not find player: " + ChatColor.GREEN + args[1]);
                return true;
            }
            sender.sendMessage(ChatColor.YELLOW + "Gave item: " + Woolbow.metadata.getDisplayName() + ChatColor.YELLOW + " to player: " + ChatColor.GREEN + args[1]);
            player.getInventory().addItem(Woolbow.item);

            return true;
        }
        sender.sendMessage("/" + cmd.getName() + " <get|give> <item> [player]");
        return false;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
