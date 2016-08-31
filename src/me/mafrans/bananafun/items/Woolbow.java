package me.mafrans.bananafun.items;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Instrument;
import org.bukkit.Material;
import org.bukkit.Note;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.material.Wool;
import org.bukkit.util.Vector;

public class Woolbow
{
    public static ItemStack    item     = new ItemStack(Material.REDSTONE);
    public static ItemMeta     metadata = item.getItemMeta();
    public static MaterialData itemdata = item.getData();

    public static void itemInteract(Player user, BlockBreakEvent event)
    {
        user.playNote(user.getLocation(), Instrument.PIANO, Note.flat(1, Note.Tone.A));

        Random rand = new Random();

        event.getBlock().setType(Material.WOOL);
        event.getBlock().setData((byte) rand.nextInt(15));
        event.setCancelled(true);
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

    public static void setItemMeta()
    {
        setItemName();
        item.setItemMeta(metadata);
    }

    public static void setItemName()
    {
        metadata.setDisplayName("§4W§co§eo§6l§2b§ao§bw");
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
