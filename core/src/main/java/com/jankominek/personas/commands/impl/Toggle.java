package com.jankominek.personas.commands.impl;

import com.jankominek.personas.Personas;
import com.jankominek.personas.commands.CommandBuilder;
import com.jankominek.personas.config.Config;
import com.jankominek.personas.types.PermissionGroupType;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class Toggle {
    public static final CommandBuilder command = new CommandBuilder(
            "toggle",
            PermissionGroupType.COMMAND_TOGGLE,
            new String[]{"global", "personas", "shatterment"},
            false,
            Toggle::execute,
            Toggle::complete
    );

    public static void execute(CommandSender s, String[] args) {
        if (args.length == 1) {
            Status.execute(s, args);
            return;
        }

        switch (args[1].toLowerCase()) {
            case "global": {
                boolean pluginEnabled = !Config.isPluginEnabled();

                Personas.onToggle(pluginEnabled);
                Config.setPluginEnabled(pluginEnabled);

                Status.execute(s, args);

                break;
            }
            case "personas": {
                boolean personasEnabled = !Config.Personas.isEnabled();

                Config.Personas.setEnabled(personasEnabled);

                Status.execute(s, args);

                break;
            }
            case "shatterment": {
                boolean shattermentEnabled = !Config.Shatterment.isEnabled();

                Config.Shatterment.setEnabled(shattermentEnabled);

                Status.execute(s, args);

                break;
            }
        }
    }

    public static List<String> complete(CommandSender sender, String[] args) {
        List<String> result = new ArrayList<>(List.of());

        for (String arg : Toggle.command.args) {
            if (arg.toLowerCase().startsWith(args[1].toLowerCase())) result.add(arg);
        }

        return result;
    }
}
