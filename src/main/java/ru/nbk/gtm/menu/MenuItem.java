package ru.nbk.gtm.menu;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.function.Consumer;

public interface MenuItem {

    ItemStack item();

    void item(ItemStack itemStack);

    Consumer<Player> onClick();

    void onClick(Consumer<Player> consumer);

}
