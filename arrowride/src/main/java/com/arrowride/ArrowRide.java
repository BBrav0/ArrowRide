package com.arrowride;


import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class ArrowRide extends JavaPlugin{

    public static FileConfiguration config;
    public static ArrowRide instance;
    
    @Override
    public void onLoad() {
        getLogger().info("ArrowRide loaded and ready to use.");
    }

    @Override
    public void onEnable() {
        saveDefaultConfig();
        instance = this;
        ArrowRide.config = getConfig();
        Commands.enable = getConfig().getBoolean("settings.riding");
        Commands.explosions = getConfig().getBoolean("settings.explosions");;
        Commands.mobs = getConfig().getBoolean("settings.mobs");;
        getLogger().info("ArrowRide has been enabled.");

        getCommand("arrowride").setExecutor(new Commands());
        getCommand("arrowride").setTabCompleter(new MyTabCompleter());

        getServer().getPluginManager().registerEvents(new MyListener(), this);
    }

    @Override
    public void onDisable() {
        saveConfig();
        getLogger().info("ArrowRide has been disabled.");
    }

    public static ArrowRide getInstance() {
        return instance;
    }

}