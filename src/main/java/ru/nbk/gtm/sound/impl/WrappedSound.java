package ru.nbk.gtm.sound.impl;

import org.bukkit.Sound;

public record WrappedSound(Sound sound, float pitch, float volume) {

}
