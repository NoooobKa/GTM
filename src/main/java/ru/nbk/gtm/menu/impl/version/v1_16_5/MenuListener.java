package ru.nbk.gtm.menu.impl.version.v1_16_5;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;
import ru.nbk.gtm.menu.Menu;
import ru.nbk.gtm.menu.MenuItem;

import java.util.Map;

public class MenuListener implements Listener {

    private Map<Inventory, Menu> menus;

    public MenuListener(Plugin plugin, Map<Inventory, Menu> menus){
        this.menus = menus;
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onInvClick(InventoryClickEvent e){
        Menu menu = menus.get(e.getView().getTopInventory());
        if (menu != null) {
            menu.onClick().accept(e);

            MenuItem menuItem = menu.getItem(e.getRawSlot());
            if (menuItem != null) menuItem.onClick().accept((Player) e.getWhoClicked());
        }
    }

    @EventHandler
    public void onInvDrag(InventoryDragEvent e){
        Menu menu = menus.get(e.getView().getTopInventory());
        if (menu != null) menu.onDrag().accept(e);
    }

    @EventHandler
    public void onInvClose(InventoryCloseEvent e){
        Menu menu = menus.get(e.getView().getTopInventory());
        if (menu != null) {
            menu.onClose().accept(e);
            if (menu.removeOnClose() && e.getInventory().getViewers().size() == 0) menus.remove(e.getView().getTopInventory());
        }
    }
}
