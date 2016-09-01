package me.mafrans.bananafun.items;

import me.mafrans.bananafun.BananaFun;
import org.bukkit.ChatColor;
import org.bukkit.Instrument;
import org.bukkit.Material;
import org.bukkit.Note;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

public class Megaphone
{
    public static ItemStack    item     = new ItemStack(Material.RED_MUSHROOM);
    public static ItemMeta     metadata = item.getItemMeta();
    public static MaterialData itemdata = item.getData();

    public static void itemInteract(Player user, PlayerInteractEvent event)
    {
        if(event.getAction().equals(Action.RIGHT_CLICK_AIR))
        {
            user.playNote(user.getLocation(), Instrument.PIANO, Note.natural(1, Note.Tone.C));
            user.playNote(user.getLocation(), Instrument.PIANO, Note.natural(1, Note.Tone.E));
            user.playNote(user.getLocation(), Instrument.PIANO, Note.natural(1, Note.Tone.G));

            for(Entity entity : user.getNearbyEntities(25,15,25))
            {
                entity.setVelocity(user.getLocation().getDirection().multiply(3));
            }
        }
        event.setCancelled(true);
    }

    public static void registerItem()
    {
        setItemData();
        setItemMeta();
    }

    public static void setItemData()
    {
        itemdata = new MaterialData(0);
        item.setData(itemdata);
    }

    public static void setItemMeta()
    {
        setItemName();
        item.setItemMeta(metadata);
    }

    public static void setItemName()
    {
        metadata.setDisplayName(ChatColor.RED + "Megaphone");
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
