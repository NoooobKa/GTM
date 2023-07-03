package ru.nbk.gtm.gun;

import org.bukkit.craftbukkit.libs.org.apache.commons.lang3.math.NumberUtils;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import ru.nbk.gtm.gun.attribute.GunAttribute;
import ru.nbk.gtm.gun.patron.Patron;
import ru.nbk.gtm.misc.GTMChar;
import ru.nbk.gtm.misc.util.ItemBuilder;

public abstract class Gun {

    public abstract String getName();

    public abstract GunAttribute getAttributes();

    public abstract void onLeftClick(Player source);

    public abstract void onRightClick(Player source);

    public abstract void onDrop(Player source);

    public void reloadMagazine(Player player){

    }

    public abstract void onShot(Player player);

    public abstract void onHit(Player shooter, LivingEntity target);

    public abstract Patron getPatron();

    public abstract ItemStack getItem();

    public int getPatronsInClip(ItemStack item){
        String[] args = new ItemBuilder(item).name().split(" ");
        if (args.length < 3) return 0;

        String patrons = args[2].replace("«", "").replace("»", "");
        if (!NumberUtils.isDigits(patrons)) return 0;

        return Integer.valueOf(patrons);
    }

    public ItemStack setGunReady(ItemStack gunItem, boolean ready){
        return new ItemBuilder(gunItem).name(getName() + " " + (ready ? GTMChar.FILLED_SMALL_SQUARE : GTMChar.SMALL_SQUARE)).build();
    }

    public String getGunItemDefaultName(){
        return getName() + " " + GTMChar.FILLED_SMALL_SQUARE + " «" + getAttributes().clip() + "»";
    }
}
