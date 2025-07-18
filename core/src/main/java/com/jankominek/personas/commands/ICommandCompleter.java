package com.jankominek.personas.commands;

import org.bukkit.command.CommandSender;

import java.util.List;

@FunctionalInterface
public interface ICommandCompleter {
    List<String> onTabComplete(CommandSender s, String[] a);
}
