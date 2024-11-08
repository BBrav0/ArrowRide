package com.arrowride;


import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEggThrowEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class MyListener implements Listener{
    
    @EventHandler
    public void onShoot(PlayerEggThrowEvent e) {

        e.getPlayer().sendMessage("You fired an egg!");


    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        final Player p = e.getPlayer();
        p.sendMessage("Welcome "+p.getName().toString());
        e.setJoinMessage("THE GOAT IS IN");
    }
}
