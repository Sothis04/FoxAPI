package fr.sothis.api.menus;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public abstract class SMenu extends SMenuInfo implements InventoryHolder {

    protected SUtility playerUtility;
    protected SMenuInfo menuInfo;
    protected Player player;
    protected Inventory inventory;

    public SMenu(SUtility sUtility) {
        HashMap<ItemStack, Integer> items = new HashMap<>();
        int size = setSize().getNumber();
        for (int i = 0; i < size ; i++)
            items.put(inventory.getItem(i), i);
        this.playerUtility = sUtility;
        this.player = sUtility.getPlayer();
        super.setName(setName());
        super.setItems(items);
        super.setSize(setSize());
        super.setCancelClick(enablePickItem());
    }

    public abstract String setName();

    public abstract void onEvent(InventoryClickEvent event);

    public abstract void setItems();

    public abstract Size setSize();

    public abstract boolean enablePickItem();

    public abstract void onOpenInventory();

    public abstract void onCloseInventory();

    public void open() {
        onOpenInventory();
        inventory = Bukkit.createInventory(this, getSize().getNumber(), getName());
        this.setItems();
        playerUtility.getPlayer().openInventory(inventory);
        playerUtility.pushMenu(this);
    }

    public void back() {
        MenuManager.openMenu(playerUtility.backMenu().getClass(), playerUtility.getPlayer());
    }

    protected void reloadItems() {
        for (int i = 0; i < inventory.getSize(); i++){
            inventory.setItem(i, null);
        }
        setItems();
    }

    protected void reload() {
        player.closeInventory();
        MenuManager.openMenu(this.getClass(), player);
    }

    public SMenuInfo getMenuInfo() {
        return menuInfo;
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }
}
