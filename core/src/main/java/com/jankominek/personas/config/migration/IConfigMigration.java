package com.jankominek.personas.config.migration;

import org.bukkit.configuration.file.FileConfiguration;

public interface IConfigMigration {
    FileConfiguration migrate(FileConfiguration oldConfig, FileConfiguration configTemplate);
}
