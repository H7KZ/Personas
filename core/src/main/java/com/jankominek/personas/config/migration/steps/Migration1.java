package com.jankominek.personas.config.migration.steps;

import com.jankominek.personas.config.migration.IConfigMigration;
import com.jankominek.personas.utils.ConfigUtils;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.Set;

public class Migration1 implements IConfigMigration {
    public FileConfiguration migrate(FileConfiguration oldConfig, FileConfiguration configTemplate) {
        Set<String> keys = oldConfig.getKeys(true);

        ConfigUtils.copyKeys(keys, oldConfig, configTemplate);

        return configTemplate;
    }
}
