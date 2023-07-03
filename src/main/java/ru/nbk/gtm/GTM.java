package ru.nbk.gtm;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import ru.nbk.gtm.menu.MenuManager;
import ru.nbk.gtm.menu.MenuManagerFactory;
import ru.nbk.gtm.sound.GTMSoundManager;
import ru.nbk.gtm.sound.impl.GTMSoundManagerImpl;


public class GTM extends JavaPlugin implements Listener {

    private GTMSoundManager soundManager;
    private MenuManager menuManager;

    public void onEnable(){
        this.soundManager = new GTMSoundManagerImpl(this);
        this.menuManager = new MenuManagerFactory().createMenuManager(this);
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onCraft(InventoryClickEvent e){
        Bukkit.broadcastMessage("123");
    }
}
