package com.jankominek.personas.plugins;

import org.bukkit.entity.Player;

public interface ISupportedPlugin {
    String getName();

    boolean save(Player player);

    boolean load(Player player);

    default void activate() {
    }
}
