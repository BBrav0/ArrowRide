package com.arrowride;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class Commands implements CommandExecutor {

    public static boolean enable;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String arg2,
            @NotNull String[] arg3) {

                Commands.enable=!Commands.enable;
                sender.sendMessage("Arrow Riding: "+Commands.enable);

                return true;
    }}
