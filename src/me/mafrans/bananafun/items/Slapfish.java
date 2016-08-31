package me.mafrans.bananafun.items;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Instrument;
import org.bukkit.Material;
import org.bukkit.Note;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.util.Vector;

public class Slapfish
{
    public static ItemStack    item     = new ItemStack(Material.RAW_FISH);
    public static ItemMeta     metadata = item.getItemMeta();
    public static MaterialData itemdata = item.getData();

    public static void itemInteract(Player user, PlayerInteractEvent event)
    {
        if(event.getAction().equals(Action.LEFT_CLICK_AIR))
        {
            user.playNote(user.getLocation(), Instrument.PIANO, Note.flat(1, Note.Tone.E));

            for (Player p : Bukkit.getServer().getOnlinePlayers())
            {
                if(user.getLocation().distance(p.getLocation()) <= 20)
                {
                    if(p != user)
                    {
                        Vector vector = p.getLocation().toVector().subtract(user.getLocation().toVector());

                        p.setVelocity(vector);
                    }
                }
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

    public static void setItemMeta()
    {
        setItemName();
        item.setItemMeta(metadata);
    }

    public static void setItemName()
    {
        metadata.setDisplayName(ChatColor.YELLOW + "Slap" + ChatColor.GREEN + "Fish");
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
