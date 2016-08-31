package me.mafrans.bananafun.items;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Instrument;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Note;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.material.Wool;
import org.bukkit.util.Vector;

public class Enderdragon
{
    public static ItemStack    item     = new ItemStack(Material.DRAGON_EGG);
    public static ItemMeta     metadata = item.getItemMeta();
    public static MaterialData itemdata = item.getData();
    public static List<Player> players  = new ArrayList<>();

    public static void dragonEffect(Player user, PlayerMoveEvent event)
    {
        for (Block b : getNearbyBlocks(user.getLocation(), 3))
        {
            b.setType(Material.AIR);
        }
    }

    public static void itemInteract(Player user, PlayerInteractEvent event)
    {
        if(event.getAction().equals(Action.RIGHT_CLICK_AIR) || event.getAction().equals(Action.RIGHT_CLICK_BLOCK))
        {
            user.playNote(user.getLocation(), Instrument.PIANO, Note.flat(1, Note.Tone.D));

            if(players.contains(user))
            {
                players.remove(user);
                user.sendMessage(metadata.getDisplayName() + ChatColor.YELLOW + " is now " + ChatColor.RED + "OFF");
            }
            else
            {
                players.add(user);
                user.sendMessage(metadata.getDisplayName() + ChatColor.YELLOW + " is now " + ChatColor.GREEN + "ON");
            }

            event.setCancelled(true);
        }
    }

    public static void registerItem()
    {
        setItemData();
        setItemMeta();
    }

    public static void setItemData()
    {
        itemdata = new MaterialData(2);
        item.setData(itemdata);
    }

    public static void setItemLore()
    {
        metadata.setLore(Arrays.asList(ChatColor.RED + "WARNING: THIS ITEM PERMANENTLY REMOVES",
                                       ChatColor.RED + "BLOCKS AND SHOULD NOT BE USED NEAR",ChatColor.RED
                                       + "YOUR OR OTHERS BUILDS."));
    }

    public static void setItemMeta()
    {
        setItemName();
        setItemLore();
        item.setItemMeta(metadata);
    }

    public static void setItemName()
    {
        metadata.setDisplayName(ChatColor.DARK_PURPLE + "Ender" + ChatColor.GRAY + "Dragon");
    }

    public static List<Block> getNearbyBlocks(Location location, int radius)
    {
        List<Block> blocks = new ArrayList<Block>();

        for (int x = location.getBlockX() - radius; x <= location.getBlockX() + radius; x++)
        {
            for (int y = location.getBlockY() - radius; y <= location.getBlockY() + radius; y++)
            {
                for (int z = location.getBlockZ() - radius; z <= location.getBlockZ() + radius; z++)
                {
                    blocks.add(location.getWorld().getBlockAt(x, y, z));
                }
            }
        }

        return blocks;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
