package ru.nbk.gtm.menu;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import ru.nbk.gtm.menu.MenuManager;

public class MenuManagerFactory {

    public MenuManager createMenuManager(Plugin plugin){
        switch (Bukkit.getServer().getBukkitVersion().split("-")[0]){
            case "1.16.5": return new ru.nbk.gtm.menu.impl.version.v1_16_5.MenuManagerImpl(plugin);
        }
        return null;
    }

}
