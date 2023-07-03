package ru.nbk.gtm.sound.impl;

import org.bukkit.scheduler.BukkitRunnable;

import java.util.function.Supplier;

public class SoundTask extends BukkitRunnable {

    private final Supplier<Boolean> condition;
    private final Runnable runnable;

    public SoundTask(Runnable runnable, Supplier<Boolean> condition){
        this.condition = condition;
        this.runnable = runnable;
    }

    @Override
    public void run() {
        if (!condition.get()) return;
        runnable.run();
    }
}
