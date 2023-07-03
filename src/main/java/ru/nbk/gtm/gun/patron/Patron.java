package ru.nbk.gtm.gun.patron;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum Patron {

    PISTOL(new ItemStack(Material.WHEAT_SEEDS)),
    SHOTGUN(new ItemStack(Material.PUMPKIN_SEEDS)),
    CARBINE(new ItemStack(Material.MELON_SEEDS)),
    SNIPER(new ItemStack(Material.CLAY_BALL)),
    MACHINE_GUN(new ItemStack(Material.NETHER_WART)),
    BAZOOKA(new ItemStack(Material.GOLD_NUGGET));

    ItemStack item;

    Patron(ItemStack item){
        this.item = item;
    }

    public ItemStack getItem(){
        return item.clone();
    }


//    PISTOL("§7Пистолетные патроны", "§6Пистолет", Snowball.class, new ItemStack(Material.SEEDS)),
//    SHOTGUN("§6Патроны для дробовика", "§6Дробовик", Snowball.class, new ItemStack(Material.PUMPKIN_SEEDS)),
//    CARBINE("§cАвтоматные патроны", "§6Автомат", Snowball.class, new ItemStack(Material.MELON_SEEDS)),
//    SNIPER("§5Патроны для снайперской винтовки", "§6Снайперская винтовка", Snowball.class, new ItemStack(Material.CLAY_BALL)),
//    MACHINE_GUN("§2Пулемётные патроны", "§6Пулемёт", Snowball.class, new ItemStack(Material.NETHER_STALK)),
//    BAZOOKA("§b§lСнаряд", "Ракетница", Snowball.class, new ItemStack(Material.GOLD_NUGGET));

}
