package ru.nbk.gtm.gun.attribute;

import ru.nbk.gtm.sound.GTMSound;

public record GunAttribute(GTMSound fireSound, GTMSound hitSound, double scatter, double zoomScatter, double damage, double recoil, double zoomRecoil, double power, int clip) {}
