package me.mafrans.bananafun.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

import me.mafrans.bananafun.items.*;

public class PlayerListener implements Listener
{
    @EventHandler
    public void onInteract(PlayerInteractEvent e)
    {
        Player    player = e.getPlayer();
        ItemStack hand   = player.getItemInHand();

        switch(hand.getType())
        {
            case RAW_FISH :
            {
                if(hand.getItemMeta().equals(Slapfish.metadata))
                {
                    Slapfish.itemInteract(player, e);
                }
            }

            case BOW :
            {
                if(hand.getItemMeta().equals(Instabow.metadata))
                {
                    Instabow.itemInteract(player, e);
                }
            }

            case SLIME_BALL :
            {
                if(hand.getItemMeta().equals(Bouncer.metadata))
                {
                    Bouncer.itemInteract(player, e);
                }
            }

            case DRAGON_EGG :
            {
                if(hand.getItemMeta().equals(Enderdragon.metadata))
                {
                    Enderdragon.itemInteract(player, e);
                }
            }
            
            case BRICK :
            {
                if(hand.getItemMeta().equals(Dynamite.metadata))
                {
                    Dynamite.itemInteract(player, e);
                }
            }
            
            case RED_MUSHROOM:
            {
                if(hand.getItemMeta().equals(Megaphone.metadata))
                {
                    Megaphone.itemInteract(player, e);
                }
            }
            
            case IRON_INGOT:
            {
                if(hand.getItemMeta().getDisplayName().equals(Magnet.metadata.getDisplayName()))
                {
                    Magnet.itemInteract(player, e);
                }
            }
        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e)
    {
        Player player = e.getPlayer();

        if(Enderdragon.players.contains(player))
        {
            Enderdragon.dragonEffect(player, e);
        }
        
        if(Magnet.players.contains(player))
        {
            Magnet.itemMove(player, e);
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
