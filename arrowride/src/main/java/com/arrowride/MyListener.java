package com.arrowride;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;

public class MyListener implements Listener{
    
    @SuppressWarnings("deprecation")
    @EventHandler
    public void onShoot(EntityShootBowEvent e) {

        Entity t = e.getEntity();
        
        if (!(t instanceof Player)) {
            return;
        }
        Entity arrow = e.getProjectile();
        arrow.setPassenger(t);

    }

}
