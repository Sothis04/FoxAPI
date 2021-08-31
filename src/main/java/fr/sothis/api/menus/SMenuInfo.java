package fr.sothis.api.menus;

import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class SMenuInfo {

    private String name;
    private Size size;
    private HashMap<ItemStack, Integer> items = new HashMap<>();
    private boolean cancelClick;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public HashMap<ItemStack, Integer> getItems() {
        return items;
    }

    public void setItems(HashMap<ItemStack, Integer> items) {
        this.items = items;
    }

    public boolean isCancelClick() {
        return cancelClick;
    }

    public void setCancelClick(boolean cancelClick) {
        this.cancelClick = cancelClick;
    }
}
