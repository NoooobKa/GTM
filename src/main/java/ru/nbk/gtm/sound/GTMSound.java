package ru.nbk.gtm.sound;

import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.function.Supplier;

public interface GTMSound {

    GTMSound addSound(Sound sound, float pitch, float volume, int delay);

    void play(Location location, Supplier<Boolean> condition);

    void play(Location location, Collection<Player> players, Supplier<Boolean> condition);

    void play(Player player, Supplier<Boolean> condition);

    void play(Player player, Collection<Player> players, Supplier<Boolean> condition);



}
