package com.jankominek.personas.events;

import com.jankominek.personas.utils.DiagnosticUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class GUIClickEvent implements Listener {
    @EventHandler(priority = EventPriority.NORMAL)
    public void onEvent(InventoryClickEvent event) {
        try {
            this.handler(event);
        } catch (Exception e) {
            DiagnosticUtils.throwReport(e);
        }
    }

    private void handler(InventoryClickEvent e) {
        if (e.getClickedInventory() == null) return;

        if (!(e.getWhoClicked() instanceof Player p)) {
        }


    }
}
