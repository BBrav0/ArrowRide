package com.arrowride;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MyTabCompleter implements TabCompleter {

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command,
            @NotNull String alias, @NotNull String[] args) {
        List<String> suggestions = new ArrayList<>();

        // Only autocomplete for the "arrowride" command
        if (args.length == 1) {
            // Suggest "enable" or "disable"
            StringUtil.copyPartialMatches(args[0], List.of("enable", "disable"), suggestions);
        } else if (args.length == 2) {
            if (args[0].equalsIgnoreCase("enable") || args[0].equalsIgnoreCase("disable")) {
                // Suggest "mobs" or "explosions" if the first argument is "enable" or "disable"
                StringUtil.copyPartialMatches(args[1], List.of("mobs", "explosions"), suggestions);
            }
        }

        return suggestions;
    }

}
