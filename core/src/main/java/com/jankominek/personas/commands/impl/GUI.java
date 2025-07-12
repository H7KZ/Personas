package com.jankominek.personas.commands.impl;

import com.jankominek.personas.commands.CommandBuilder;
import com.jankominek.personas.guis.impl.NavigationGUI;
import com.jankominek.personas.types.PermissionGroupType;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class GUI {
    public static final CommandBuilder command = new CommandBuilder(
            "gui",
            PermissionGroupType.COMMAND_GUI,
            new String[]{},
            false,
            GUI::execute,
            GUI::complete
    );

    public static void execute(CommandSender s, String[] args) {
        NavigationGUI navigationGUI = new NavigationGUI();

        if (!(s instanceof Player player)) return;

        player.openInventory(navigationGUI.getInventory());
    }

    public static List<String> complete(CommandSender sender, String[] args) {
        return new ArrayList<>(List.of());
    }
}
