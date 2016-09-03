package me.mafrans.bananafun.items;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Instrument;
import org.bukkit.Material;
import org.bukkit.Note;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.util.Vector;

public class Magnet
{
    public static ItemStack    item     = new ItemStack(Material.IRON_INGOT);
    public static MaterialData itemdata = item.getData();
    public static ItemMeta metadata     = item.getItemMeta();
    public static List<Player> players         = new ArrayList();

    public static void itemInteract(Player user, PlayerInteractEvent event)
    {
        if(event.getAction().equals(Action.RIGHT_CLICK_BLOCK)||event.getAction().equals(Action.RIGHT_CLICK_AIR))
        {
            if(user.isSneaking())
            {   
                if(players.contains(user))
                {
                    user.playNote(user.getLocation(), Instrument.PIANO, Note.flat(0, Note.Tone.A));
                    players.remove(user);
                    ItemStack is = user.getItemInHand();
                    ItemMeta meta = is.getItemMeta();
                    meta.removeEnchant(Enchantment.LURE);
                    is.setItemMeta(meta);
                }
                else
                {
                    user.playNote(user.getLocation(), Instrument.PIANO, Note.flat(1, Note.Tone.A));
                    players.add(user);
                    ItemStack is = user.getItemInHand();
                    ItemMeta meta = is.getItemMeta();
                    meta.addEnchant(Enchantment.LURE, 1, true);
                    is.setItemMeta(meta);
                }
            }   
        }
        event.setCancelled(true);
    }
    
    public static void itemMove(Player user, PlayerMoveEvent event)
    {
        if(players.contains(user))
        {
            List<Entity> entities = user.getNearbyEntities(5, 5, 5);
            for(Entity entity : entities)
            {
                if(entity.getType() == EntityType.DROPPED_ITEM)
                {
                    Vector vector = user.getLocation().toVector().subtract(entity.getLocation().toVector());
                    entity.setVelocity(vector);
                }
            }
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
        metadata.setDisplayName("§7Mag§cnet");
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
