package com.arrowride;


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

    if (!(e.getEntity() instanceof Player) || !Commands.enable) {
        return;
    }
     this.player = e.getEntity();
    this.arrow = e.getProjectile();

    arrow.addPassenger(this.player);

    }

    @EventHandler
    public void onLand(ProjectileHitEvent e) {
        if (e.getEntity().equals(arrow)) {
            arrow.removePassenger(player);
        }

    }
}

