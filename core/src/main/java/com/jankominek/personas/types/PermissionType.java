package com.jankominek.personas.types;

import org.bukkit.permissions.Permissible;

import static com.jankominek.personas.Personas.logger;
import static com.jankominek.personas.types.PermissionStateType.ACTIVE;
import static com.jankominek.personas.types.PermissionStateType.DEPRECATED;

public enum PermissionType {
    ALL("personas.all"),
    ;

    private static long DEPRECATED_LAST_WARNING = 0;

    private final String permission;
    private final PermissionStateType state;

    PermissionType(String permission) {
        this(permission, ACTIVE);
    }

    PermissionType(String permission, PermissionStateType state) {
        this.permission = permission;
        this.state = state;
    }

    public boolean hasPermission(Permissible permissible) {
        boolean hasPermission = permissible.hasPermission(permission);

        if (!hasPermission) return false;

        if (state == DEPRECATED) sendDeprecatedMessage();

        return true;
    }

    private void sendDeprecatedMessage() {
        long time = System.currentTimeMillis();

        if (time <= DEPRECATED_LAST_WARNING) return;

        DEPRECATED_LAST_WARNING = time + 30 * 60 * 1000; // 30 minutes

        String message = "";
        message += "/!\\ Caution /!\\";
        message += "\nIt look like you are using deprecated permission ( \" + permission + \")";
        message += "\nCheckout the new permission system at";
        message += "\nthe plugin's spigot page or the plugin's github.";

        logger.warning(message);
    }
}
