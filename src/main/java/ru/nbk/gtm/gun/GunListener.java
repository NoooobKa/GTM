package ru.nbk.gtm.gun;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import ru.nbk.gtm.misc.util.ItemBuilder;

public class GunListener implements Listener {

    private GunManager gunManager;
    private Plugin plugin;

    public GunListener(Plugin plugin, GunManager gunManager){
        this.gunManager = gunManager;
        this.plugin = plugin;

        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(ignoreCancelled = true)
    public void onInteract(PlayerInteractEvent e){
        if (e.getItem() == null) return;

        String itemName = new ItemBuilder(e.getItem()).name();
        if (itemName.isEmpty()) return;

        String gunName = ChatColor.stripColor(itemName).split(" ")[0];
        Gun gun = gunManager.byName(gunName);
        if (gun == null) return;

        if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK){
            gun.onLeftClick(e.getPlayer());
        }else if (e.getAction() != Action.PHYSICAL){
            gun.onRightClick(e.getPlayer());
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onGunDrop(PlayerDropItemEvent e){
        Gun gun = gunManager.byName(new ItemBuilder(e.getItemDrop().getItemStack()).name());
        if (gun == null) return;
        if (!e.getPlayer().hasMetadata("DropItem")) {
            e.setCancelled(true);
            gun.reloadMagazine(e.getPlayer());
        }
    }

    @EventHandler
    public void onInventory(InventoryClickEvent e){
        if (e.getSlot() == -999){
           ItemStack item =  e.getCursor();
           if (item == null) return;

           Gun gun = gunManager.byName(new ItemBuilder(item).name());
           if (gun == null) return;
           e.getWhoClicked().setMetadata("DropItem", new FixedMetadataValue(plugin, null));
           new BukkitRunnable(){
               @Override
               public void run() {
                   e.getWhoClicked().removeMetadata("DropItem", plugin);
               }
           }.run();
        }
    }

}
