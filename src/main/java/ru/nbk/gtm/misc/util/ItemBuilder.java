package ru.nbk.gtm.misc.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ItemBuilder {

    private ItemStack item;

    public ItemBuilder(ItemStack item){
        if (item == null){
            this.item = new ItemStack(Material.AIR);
        }else {
            this.item = item.clone();
        }
    }

    public ItemBuilder(Material material){
        this.item = new ItemStack(material);
    }

    public ItemMeta meta(){
        return item.getItemMeta();
    }

    public ItemBuilder meta(ItemMeta meta){
        item.setItemMeta(meta);
        return this;
    }

    public String name(){
        return meta().hasDisplayName() ? meta().getDisplayName() : "";
    }

    public ItemBuilder name(String name){
        ItemMeta meta = meta();
        meta.setDisplayName(name);
        meta(meta);
        return this;
    }

    public List<String> lore(){
        return meta().getLore() == null ? new ArrayList<>() : meta().getLore();
    }

    public ItemBuilder lore(List<String> lore){
        ItemMeta meta = meta();
        meta.setLore(lore);
        meta(meta);
        return this;
    }

    public ItemBuilder addLore(String... lore){
        ItemMeta meta = meta();
        List<String> old = lore();
        for (String line : lore) {
            old.add(line);
        }
        meta.setLore(old);
        meta(meta);
        return this;
    }

    public ItemBuilder addLoreAbove(String... lore){
        ItemMeta meta = meta();
        List<String> old = lore();
        List<String> toAdd = Arrays.asList(lore);
        Collections.reverse(toAdd);
        old.addAll(0, toAdd);
        meta.setLore(old);
        meta(meta);
        return this;
    }

    public ItemStack build(){
        return item;
    }
}
