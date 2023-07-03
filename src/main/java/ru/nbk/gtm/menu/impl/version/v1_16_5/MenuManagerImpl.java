package ru.nbk.gtm.menu.impl.version.v1_16_5;

import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;
import ru.nbk.gtm.menu.Menu;
import ru.nbk.gtm.menu.MenuManager;

import java.util.HashMap;
import java.util.Map;

public class MenuManagerImpl implements MenuManager {

    private Map<Inventory, Menu> menus = new HashMap<>();

    public MenuManagerImpl(Plugin plugin){
        new MenuListener(plugin, menus);
    }

    @Override
    public Menu createMenu() {
        Menu menu = new MenuImpl();
        menus.put(menu.getInventory(), menu);
        return menu;
    }

    @Override
    public Menu createMenu(String name) {
        Menu menu = new MenuImpl(name);
        menus.put(menu.getInventory(), menu);
        return menu;
    }

    @Override
    public Menu createMenu(int size) {
        Menu menu = new MenuImpl(size);
        menus.put(menu.getInventory(), menu);
        return menu;
    }

    @Override
    public Menu createMenu(InventoryType type) {
        Menu menu = new MenuImpl(type);
        menus.put(menu.getInventory(), menu);
        return menu;
    }

    @Override
    public Menu createMenu(String name, int size) {
        Menu menu = new MenuImpl(size, name);
        menus.put(menu.getInventory(), menu);
        return menu;
    }

    @Override
    public Menu createMenu(String name, InventoryType type) {
        Menu menu = new MenuImpl(type, name);
        menus.put(menu.getInventory(), menu);
        return menu;
    }
}
