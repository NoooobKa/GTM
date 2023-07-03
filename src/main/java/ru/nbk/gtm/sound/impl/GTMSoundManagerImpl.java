package ru.nbk.gtm.sound.impl;

import org.bukkit.plugin.Plugin;
import ru.nbk.gtm.sound.GTMSound;
import ru.nbk.gtm.sound.GTMSoundManager;

public class GTMSoundManagerImpl implements GTMSoundManager {

    private final Plugin plugin;

    public GTMSoundManagerImpl(Plugin plugin){
        this.plugin = plugin;
    }

    @Override
    public GTMSound createSound() {
        return new GTMSoundImpl(plugin);
    }
}
