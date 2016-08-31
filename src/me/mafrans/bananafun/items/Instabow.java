package me.mafrans.bananafun.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

public class Instabow
{
    public static ItemStack    item     = new ItemStack(Material.BOW);
    public static ItemMeta     metadata = item.getItemMeta();
    public static MaterialData itemdata = item.getData();

    public static void itemInteract(Player user, PlayerInteractEvent event)
    {
        if(event.getAction().equals(Action.LEFT_CLICK_AIR) || event.getAction().equals(Action.LEFT_CLICK_BLOCK))
        {
            user.getLocation()
                .getWorld()
                .spawnArrow(user.getLocation().add(0, 2, 0).add(user.getLocation().getDirection()), user.getLocation().getDirection(), (float) 3, (float) 0);
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
        metadata.setDisplayName(ChatColor.DARK_GRAY + "Insta" + ChatColor.GRAY + "bow");
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
