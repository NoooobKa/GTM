package ru.nbk.gtm.menu;

import org.bukkit.event.inventory.InventoryType;

public interface MenuManager {

    Menu createMenu();

    Menu createMenu(String name);

    Menu createMenu(int size);

    Menu createMenu(InventoryType type);

    Menu createMenu(String name, int size);

    Menu createMenu(String name, InventoryType type);



}
