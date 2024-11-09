package com.arrowride;


import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;


public class MyListener implements Listener{

    Entity arrow;
    LivingEntity player;
    
    @EventHandler
    public void onShoot(EntityShootBowEvent e) {

    

        //TEST CASES::::
    if ((e.getEntity() instanceof Player) && !Commands.enable) {
        return;
    }

    if (!(e.getEntity() instanceof Player) && !Commands.mobs) {
        return;
    }



    //CODE
     this.player = e.getEntity();
     if (!player.hasPermission("ArrowRide.use")) {
        return;
     }

    this.arrow = e.getProjectile();

    arrow.addPassenger(this.player);

    }

    @EventHandler
    public void onLand(ProjectileHitEvent e) {
        if (e.getEntity().equals(arrow)) {
            arrow.removePassenger(player);
        }

        if (Commands.explosions) {
            arrow.getLocation().createExplosion(4.0f);
             
        }

    }
}

