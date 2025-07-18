package com.jankominek.personas.plugins;

import java.util.ArrayList;
import java.util.List;

import static com.jankominek.personas.Personas.nms;

public class SupportedPluginsManager {
    private static final List<ISupportedPlugin> activatedPlugins = new ArrayList<>();

    public static List<ISupportedPlugin> getAllSupportedPlugins() {
        return nms.getSupportedPlugins();
    }

    public static ISupportedPlugin getSupportedPluginByName(String pluginName) {
        for (ISupportedPlugin supportedPlugin : getAllSupportedPlugins()) {
            if (supportedPlugin.getName().equals(pluginName)) return supportedPlugin;
        }

        return null;
    }

    public static List<String> getAllSupportedPluginsNames() {
        return getAllSupportedPlugins().stream().map(ISupportedPlugin::getName).toList();
    }

    public static void activatePlugins(List<String> plugins) {
        for (String plugin : plugins) {
            ISupportedPlugin supportedPlugin = getSupportedPluginByName(plugin);

            if (supportedPlugin != null) {
                activatedPlugins.add(supportedPlugin);
                supportedPlugin.activate();
            }
        }
    }

    public static List<ISupportedPlugin> getAllActivatedPlugins() {
        return activatedPlugins;
    }

    public static List<String> getAllActivatedPluginsNames() {
        return activatedPlugins.stream().map(ISupportedPlugin::getName).toList();
    }

    public static void deactivateAllPlugins() {
        activatedPlugins.clear();
    }
}
