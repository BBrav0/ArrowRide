package com.arrowride;

import org.bukkit.plugin.java.JavaPlugin;

public class ArrowRide extends JavaPlugin{
    
    @Override
    public void onLoad() {
        getLogger().info("ArrowRide loaded and ready to use.");
    }

    @Override
    public void onEnable() {
        getLogger().info("ArrowRide has been enabled.");
    }

    @Override
    public void onDisable() {
        getLogger().info("ArrowRide has been disabled.");
    }
}