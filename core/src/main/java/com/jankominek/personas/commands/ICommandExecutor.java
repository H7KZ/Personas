package com.jankominek.personas.commands;

import org.bukkit.command.CommandSender;

@FunctionalInterface
public interface ICommandExecutor {
    void execute(CommandSender s, String[] a);
}
