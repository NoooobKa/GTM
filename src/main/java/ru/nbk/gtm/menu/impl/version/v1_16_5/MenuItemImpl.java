package ru.nbk.gtm.menu.impl.version.v1_16_5;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import ru.nbk.gtm.menu.Menu;
import ru.nbk.gtm.menu.MenuItem;

import java.util.function.Consumer;

public class MenuItemImpl implements MenuItem {

    private ItemStack item;
    private Consumer<Player> consumer;

    public MenuItemImpl(ItemStack item){
        this.item = item;
        this.consumer = player -> {};
    }

    public MenuItemImpl(ItemStack item, Consumer<Player> onClick){
        this.item = item;
        this.consumer = onClick;
    }

    @Override
    public ItemStack item() {
        return item;
    }

    @Override
    public void item(ItemStack item) {
        this.item = item;
    }

    @Override
    public Consumer<Player> onClick() {
        return consumer;
    }

    @Override
    public void onClick(Consumer<Player> consumer) {
        this.consumer = consumer;
    }
}
