package com.jankominek.personas.commands;

import com.jankominek.personas.commands.impl.*;
import com.jankominek.personas.utils.DiagnosticUtils;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.HashMap;
import java.util.Map;

public class CommandRegister implements CommandExecutor {
    public final static Map<String, CommandBuilder> commands = new HashMap<>() {
        {
            put(Help.command.name, Help.command);
            put(GUI.command.name, GUI.command);
            put(Status.command.name, Status.command);
            put(Toggle.command.name, Toggle.command);
            put(PersonasEnchantments.command.name, PersonasEnchantments.command);
            put(PersonasWorlds.command.name, PersonasWorlds.command);
            put(PersonasMaterials.command.name, PersonasMaterials.command);
            put(PersonasRepair.command.name, PersonasRepair.command);
            put(PersonasSound.command.name, PersonasSound.command);
            put(ShatterEnchantments.command.name, ShatterEnchantments.command);
            put(ShatterWorlds.command.name, ShatterWorlds.command);
            put(ShatterRepair.command.name, ShatterRepair.command);
            put(ShatterSound.command.name, ShatterSound.command);
            put(Diagnostic.command.name, Diagnostic.command);
        }
    };

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
        try {
            if (args.length == 0) return executeCommand("help", sender, args);

            return executeCommand(args[0].toLowerCase(), sender, args);
        } catch (Exception e) {
            DiagnosticUtils.throwReport(e);

            return false;
        }
    }

    private boolean executeCommand(String name, CommandSender sender, String[] args) {
        CommandBuilder command = commands.get(name.toLowerCase()) == null ? commands.get("help") : commands.get(name.toLowerCase());

        return command.execute(sender, args);
    }
}
