package com.jankominek.personas.types;

import com.jankominek.personas.config.I18n;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.Permissible;

import java.util.stream.Stream;

public enum PermissionGroupType {
    COMMAND_GUI(
            PermissionType.ALL
    ),
    ;

    private final PermissionType[] permissions;

    PermissionGroupType(PermissionType... permissions) {
        this.permissions = permissions;
    }

    public boolean hasPermission(Permissible permissible) {
        return hasPermission(permissible, true);
    }

    public boolean hasPermission(Permissible permissible, boolean feedback) {
        if (Stream.of(permissions).anyMatch(p -> p == PermissionType.ALL)) return true;
        if (Stream.of(permissions).anyMatch(p -> p.hasPermission(permissible))) return true;

        if (permissible instanceof CommandSender sender && feedback)
            sender.sendMessage(I18n.Messages.requiresPermission());

        return false;
    }
}
