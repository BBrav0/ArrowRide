package com.arrowride;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Commands implements CommandExecutor {

    public static boolean enable;
    public static boolean mobs;
    public static boolean explosions;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String arg2,
            @NotNull String[] args) {

                if (sender instanceof Player p && !p.hasPermission("ArrowRide.admin")) {
                    p.sendMessage("Permission Denied");
                    return true;

                }

                if (args.length==0) {
                Commands.enable=!Commands.enable;
                ArrowRide.config.set("settings.riding", Commands.enable);
                if (!Commands.enable) {
                    Commands.explosions = false;
                    Commands.mobs = false;
                    ArrowRide.config.set("settings.explosions", Commands.explosions);
                    ArrowRide.config.set("settings.mobs", Commands.mobs);
                }
                sender.sendMessage("Arrow Riding: " + Commands.enable);
                sender.sendMessage("Explosive Arrow Riding: " + Commands.explosions);
                sender.sendMessage("Mob Arrow Riding: " + Commands.mobs);
                
                }

                else if (args.length >= 1) {

                    
                    switch (args[0]) {
                        case "enable":
                            if (args.length >= 2) {
                                switch (args[1]) {
                                    case "mobs":
                                        Commands.mobs = true;
                                        ArrowRide.config.set("settings.mobs", Commands.mobs);
                                        sender.sendMessage("Mob Arrow Riding: " + Commands.mobs);
                                        break;
                                    case "explosions":
                                        Commands.explosions = true;
                                        sender.sendMessage("Explosive Arrow Riding: " + Commands.explosions);
                                        ArrowRide.config.set("settings.explosions", Commands.explosions);
                                        break;
                                    default:
                                        sender.sendMessage("Invalid field.");
                                }
                            } else {
                                Commands.enable = true;
                                sender.sendMessage("Arrow Riding: " + Commands.enable);
                                ArrowRide.config.set("settings.riding", Commands.enable);
                            }
                            break;
                
                        case "disable":
                            if (args.length >= 2) {
                                switch (args[1]) {
                                    case "mobs":
                                        Commands.mobs = false;
                                        sender.sendMessage("Mob Arrow Riding: " + Commands.mobs);
                                        ArrowRide.config.set("settings.mobs", Commands.mobs);
                                        break;
                                    case "explosions":
                                        Commands.explosions = false;
                                        sender.sendMessage("Explosive Arrow Riding: " + Commands.explosions);
                                        ArrowRide.config.set("settings.explosions", Commands.explosions);
                                        break;
                                    default:
                                        sender.sendMessage("Invalid field.");
                                }
                            } else {
                                Commands.enable = false;
                                Commands.explosions = false;
                                Commands.mobs = false;
                                ArrowRide.config.set("settings.explosions", Commands.explosions);
                                ArrowRide.config.set("settings.mobs", Commands.mobs);
                                ArrowRide.config.set("settings.riding", Commands.enable);
                                sender.sendMessage("Arrow Riding: " + Commands.enable);
                                sender.sendMessage("Explosive Arrow Riding: " + Commands.explosions);
                                sender.sendMessage("Mob Arrow Riding: " + Commands.mobs);
                            }
                            break;
                
                        default:
                            sender.sendMessage("Unknown subcommand. Try /help ArrowRide");
                    }
                }

                return true;
    }}
