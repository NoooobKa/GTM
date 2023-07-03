package ru.nbk.gtm.sound.impl;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import ru.nbk.gtm.sound.GTMSound;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class GTMSoundImpl implements GTMSound {

    private Map<WrappedSound, Integer> sounds = new HashMap<>();
    private Plugin plugin;

    public GTMSoundImpl(Plugin plugin){
        this.plugin = plugin;
    }

    @Override
    public GTMSoundImpl addSound(Sound sound, float pitch, float volume, int delay){
        sounds.put(new WrappedSound(sound, pitch, volume), delay);
        return this;
    }


    @Override
    public void play(Location location, Supplier<Boolean> condition) {
        sounds.forEach((sound, delay) -> new SoundTask(() -> location.getWorld().playSound(location, sound.sound(), sound.pitch(), sound.volume()), condition).runTaskLater(plugin, delay));
    }

    @Override
    public void play(Location location, Collection<Player> players, Supplier<Boolean> condition) {
        sounds.forEach((sound, delay) -> new SoundTask(() -> players.forEach(player -> player.playSound(location, sound.sound(), sound.pitch(), sound.volume())), condition).runTaskLater(plugin, delay));

    }

    @Override
    public void play(Player player, Supplier<Boolean> condition) {
        play(player.getLocation(), condition);
    }

    @Override
    public void play(Player player, Collection<Player> players, Supplier<Boolean> condition) {
        play(player.getLocation(), players, condition);
    }


}
