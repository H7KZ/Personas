package com.jankominek.personas.config;

import com.jankominek.personas.types.I18nKeyType;
import org.bukkit.ChatColor;

import static com.jankominek.personas.Personas.i18n;

public class I18n {
    private static String translateColors(String text) {
        if (text == null) return "> Missing translation <";
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static String getPrefix() {
        return I18n.translateColors(i18n.getString(I18nKeyType.PREFIX.getKey()));
    }

    public static class Messages {
        public static String requiresPermission() {
            return translateColors(i18n.getString(I18nKeyType.MESSAGES_REQUIRES_PERMISSION.getKey()));
        }

        public static String invalidArgument() {
            return translateColors(i18n.getString(I18nKeyType.MESSAGES_INVALID_ARGUMENT.getKey()));
        }
    }
}
