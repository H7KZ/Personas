package com.jankominek.personas.config;

import com.jankominek.personas.types.ConfigKeyType;

import java.util.List;

import static com.jankominek.personas.Personas.config;
import static com.jankominek.personas.Personas.plugin;

public class Config {
    public static boolean isPluginEnabled() {
        return config.getBoolean(ConfigKeyType.ENABLED.getKey());
    }

    public static boolean setPluginEnabled(boolean enabled) {
        config.set(ConfigKeyType.ENABLED.getKey(), enabled);
        plugin.saveConfig();

        return isPluginEnabled() == enabled;
    }

    public static List<String> getLocales() {
        return config.getStringList(ConfigKeyType.LOCALES.getKey());
    }

    public static String getLocale() {
        return config.getString(ConfigKeyType.LOCALE.getKey());
    }
}
