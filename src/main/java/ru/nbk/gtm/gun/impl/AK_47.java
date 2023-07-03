package ru.nbk.gtm.gun.impl;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import ru.nbk.gtm.gun.Gun;
import ru.nbk.gtm.gun.Zoomable;
import ru.nbk.gtm.gun.attribute.GunAttribute;
import ru.nbk.gtm.gun.patron.Patron;
import ru.nbk.gtm.misc.util.ItemBuilder;
import ru.nbk.gtm.sound.GTMSound;
import ru.nbk.gtm.sound.GTMSoundManager;

public class AK_47 extends Gun implements Zoomable {

    private GunAttribute attributes;
    private ItemStack gunItem;

    public AK_47(GTMSoundManager soundManager){
        GTMSound fireSound = soundManager.createSound()
                .addSound(Sound.ENTITY_IRON_GOLEM_HURT, 1f, 2f, 0)
                .addSound(Sound.ENTITY_SKELETON_HURT, 1f, 2f, 0)
                .addSound(Sound.ENTITY_ZOMBIE_ATTACK_WOODEN_DOOR, 1f, 2f, 0);

        GTMSound hitSound = soundManager.createSound()
                .addSound(Sound.ENTITY_ARROW_SHOOT, 1f, 2f, 0);

        this.attributes = new GunAttribute(fireSound, hitSound, 0.06, 0.03, 4.5, 0.2, 0.1, 3.2, 30);
        this.gunItem = new ItemBuilder(Material.STONE_SWORD)
                .name(getName() + " «»").build();
    }

    @Override
    public String getName() {
        return "AK_47";
    }

    @Override
    public GunAttribute getAttributes() {
        return attributes;
    }

    @Override
    public void onLeftClick(Player source) {
        zoom(source);
    }

    @Override
    public void onRightClick(Player source) {
        onShot(source);
    }

    @Override
    public void onDrop(Player source) {
        reloadMagazine(source);
    }

    @Override
    public void reloadMagazine(Player player) {

    }

    @Override
    public void onShot(Player player) {

    }

    @Override
    public void onHit(Player shooter, LivingEntity target) {

    }

    @Override
    public Patron getPatron() {
        return Patron.CARBINE;
    }

    @Override
    public ItemStack getItem() {
        return null;
    }

    @Override
    public void zoom(Player player) {

    }


}
