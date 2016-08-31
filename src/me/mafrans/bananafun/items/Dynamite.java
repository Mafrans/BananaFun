package me.mafrans.bananafun.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

public class Dynamite
{
    public static ItemStack    item     = new ItemStack(Material.BRICK);
    public static ItemMeta     metadata = item.getItemMeta();
    public static MaterialData itemdata = item.getData();

    public static void itemInteract(Player user, PlayerInteractEvent event)
    {
        if(event.getAction().equals(Action.RIGHT_CLICK_AIR))
        {
            TNTPrimed tnt = user.getWorld().spawn(user.getEyeLocation(), TNTPrimed.class);
            tnt.setVelocity(user.getLocation().getDirection().multiply(2));
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
        metadata.setDisplayName(ChatColor.RED + "Dynamite");
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
