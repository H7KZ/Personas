package com.jankominek.personas;

import com.jankominek.personas.commands.CommandCompleter;
import com.jankominek.personas.commands.CommandRegister;
import com.jankominek.personas.config.Config;
import com.jankominek.personas.events.GUIClickEvent;
import com.jankominek.personas.nms.NMS;
import com.jankominek.personas.nms.NMSMapper;
import com.jankominek.personas.plugins.SupportedPluginsManager;
import com.jankominek.personas.utils.BStatsMetrics;
import com.jankominek.personas.utils.ConfigUtils;
import com.jankominek.personas.utils.DiagnosticUtils;
import com.jankominek.personas.utils.UpdateChecker;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

import java.io.File;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

public final class Personas extends JavaPlugin {
    // Global variables (Should be used with class name, e.g. Personas.enabled)
    public static final String commandName = "personas";
    public static final int spigotmcId = 0; // TODO
    public static final int bstatsId = 26486;
    public static boolean enabled = true;

    // Globally known instances (Does not need to be used with class name)
    public static Personas plugin;
    public static NMS nms;
    public static BukkitScheduler scheduler;
    public static FileConfiguration config;
    public static FileConfiguration i18n;
    public static Logger logger;

    // Tasks
    private final ArrayList<BukkitTask> tasks = new ArrayList<>();

    public static void onToggle(boolean enable) {
        enabled = enable;
    }

    public void enable() {
        // Setup instances
        plugin = this;
        logger = getLogger();
        scheduler = getServer().getScheduler();

        // NMS net.minecraft.server
        NMS mappedNMS = NMSMapper.setup();
        if (mappedNMS == null) {
            logger.severe("This version of Minecraft is not compatible with Personas. Sorry!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        nms = mappedNMS;

        // Config
        ConfigUtils.setupConfig();
        config = getConfig();

        // I18n
        ConfigUtils.setupLocaleConfigs();
        String locale = Config.getLocale();
        File localesFolder = new File(plugin.getDataFolder().getAbsolutePath() + "/locales");
        if (!localesFolder.exists()) {
            logger.severe("Locales folder does not exist. Please reinstall the plugin.");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        String finalLocale = locale;
        if (Arrays.stream(Objects.requireNonNull(localesFolder.listFiles())).noneMatch(file -> file.getName().equals(finalLocale + ".yml")))
            locale = "en";
        i18n = YamlConfiguration.loadConfiguration(
                new InputStreamReader(
                        Objects.requireNonNull(
                                plugin.getResource("locales/" + locale + ".yml")
                        ),
                        StandardCharsets.UTF_8
                )
        );

        // Set config values
        Personas.enabled = Config.isPluginEnabled();

        // Find and activate supported plugins
        List<String> activatedPlugins = Arrays.stream(getServer().getPluginManager().getPlugins()).toList().stream().map(Plugin::getName).toList();
        SupportedPluginsManager.activatePlugins(activatedPlugins);

        // Events
        getServer().getPluginManager().registerEvents(new GUIClickEvent(), plugin);

        // Commands
        Objects.requireNonNull(getCommand(Personas.commandName)).setExecutor(new CommandRegister());
        Objects.requireNonNull(getCommand(Personas.commandName)).setTabCompleter(new CommandCompleter());

        // BStats
        new BStatsMetrics(plugin, bstatsId);

        // Automatic update check
        tasks.add(new UpdateChecker(spigotmcId).run(plugin, plugin.getDescription().getVersion()));

        logger.info("Personas enabled!");
    }

    public void disable() {
        for (BukkitTask task : tasks) {
            task.cancel();
        }

        getServer().getScheduler().cancelTasks(plugin);

        SupportedPluginsManager.deactivateAllPlugins();

        logger.info("Personas disabled!");
    }

    @Override
    public void onEnable() {
        try {
            this.enable();
        } catch (Exception e) {
            DiagnosticUtils.throwReport(e);
            getServer().getPluginManager().disablePlugin(this);
        }
    }

    @Override
    public void onDisable() {
        try {
            this.disable();
        } catch (Exception e) {
            DiagnosticUtils.throwReport(e);
        }
    }
}
