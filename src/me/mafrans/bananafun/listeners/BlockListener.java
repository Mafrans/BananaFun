package me.mafrans.bananafun.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.mafrans.bananafun.items.Woolbow;

public class BlockListener implements Listener
{
    @EventHandler
    public void onBlockBreak(BlockBreakEvent e)
    {
        Player    player = e.getPlayer();
        ItemStack hand   = player.getItemInHand();

        switch(hand.getType())
        {
            case REDSTONE :
            {
                if(hand.getItemMeta().equals(Woolbow.metadata))
                {
                    Woolbow.itemInteract(player, e);
                }
            }
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
