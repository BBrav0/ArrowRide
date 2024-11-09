package com.arrowride;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class Commands implements CommandExecutor {

    public static boolean enable;
    public static boolean mobs;
    public static boolean explosions;

    @SuppressWarnings({"deprecation"})
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String arg2,
                             @NotNull String[] args) {
    
        if (sender instanceof Player p && !p.hasPermission("ArrowRide.admin")) {
            p.sendMessage(ChatColor.RED+"Permission Denied");
            return true;
        }
    
        if (args.length == 0) {
            Commands.enable = !Commands.enable;
            ArrowRide.config.set("settings.riding", Commands.enable);
    
            if (!Commands.enable) {
                Commands.explosions = false;
                Commands.mobs = false;
                ArrowRide.config.set("settings.explosions", Commands.explosions);
                ArrowRide.config.set("settings.mobs", Commands.mobs);
            }
    
            sender.sendMessage(ChatColor.AQUA+"Arrow Riding: " +ChatColor.RED+ Commands.enable);
            sender.sendMessage(ChatColor.AQUA+"Explosive Arrow Riding: " +ChatColor.RED+ Commands.explosions);
            sender.sendMessage(ChatColor.AQUA+"Mob Arrow Riding: " +ChatColor.RED+ Commands.mobs);
    
            // Save the configuration changes
            ArrowRide.instance.saveConfig();
        }
    
        else if (args.length >= 1) {
    
            switch (args[0]) {
                case "enable":
                    if (args.length >= 2) {
                        switch (args[1]) {
                            case "mobs":
                                Commands.mobs = true;
                                ArrowRide.config.set("settings.mobs", Commands.mobs);
                                sender.sendMessage(ChatColor.AQUA+"Mob Arrow Riding: " +ChatColor.RED+ Commands.mobs);
                                break;
                            case "explosions":
                                Commands.explosions = true;
                                ArrowRide.config.set("settings.explosions", Commands.explosions);
                                sender.sendMessage(ChatColor.AQUA+"Explosive Arrow Riding: " +ChatColor.RED+ Commands.explosions);
                                break;
                            default:
                                sender.sendMessage(ChatColor.RED+"Invalid field.");
                        }
                    } else {
                        Commands.enable = true;
                        ArrowRide.config.set("settings.riding", Commands.enable);
                        sender.sendMessage(ChatColor.AQUA+"Arrow Riding: " +ChatColor.RED+ Commands.enable);
                    }
                    // Save the configuration changes
                    ArrowRide.instance.saveConfig();
                    break;
    
                case "disable":
                    if (args.length >= 2) {
                        switch (args[1]) {
                            case "mobs":
                                Commands.mobs = false;
                                ArrowRide.config.set("settings.mobs", Commands.mobs);
                                sender.sendMessage(ChatColor.AQUA+"Mob Arrow Riding: " +ChatColor.RED+ Commands.mobs);
                                break;
                            case "explosions":
                                Commands.explosions = false;
                                ArrowRide.config.set("settings.explosions", Commands.explosions);
                                sender.sendMessage(ChatColor.AQUA+"Explosive Arrow Riding: " +ChatColor.RED+ Commands.explosions);
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
    
                        sender.sendMessage(ChatColor.AQUA+"Arrow Riding: " +ChatColor.RED+ Commands.enable);
                        sender.sendMessage(ChatColor.AQUA+"Explosive Arrow Riding: " +ChatColor.RED+ Commands.explosions);
                        sender.sendMessage(ChatColor.AQUA+"Mob Arrow Riding: " +ChatColor.RED+ Commands.mobs);
                    }
                    // Save the configuration changes
                    ArrowRide.instance.saveConfig();
                    break;

                    case "help":

                    sender.sendMessage(ChatColor.AQUA+"Arrow Riding Help:");
                    sender.sendMessage(ChatColor.RED+"/ar [enable|disable] [mobs|explosions]");
                    sender.sendMessage(ChatColor.RED+"/ar "+ChatColor.AQUA+"toggles arrow riding as a whole");
                    sender.sendMessage(ChatColor.RED+"/ar disable "+ChatColor.AQUA+"disables ALL arrow riding components");
                    sender.sendMessage(ChatColor.RED+"/ar disable mobs "+ChatColor.AQUA+"mobs will no longer ride arrows they shoot");

                    break;
                default:
                    sender.sendMessage(ChatColor.RED+"Unknown subcommand. Try /ar help");
            }
        }
    
        return true;
    }
}