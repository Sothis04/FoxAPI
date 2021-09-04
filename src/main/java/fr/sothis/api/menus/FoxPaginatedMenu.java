package fr.sothis.api.menus;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.List;

public abstract class FoxPaginatedMenu extends FoxMenu {

    protected List<Object> data;
    protected int page = 0;
    protected int maxItemsPerPage = 28;
    protected int index = 0;
    protected ItemStack defaultBorder = new ItemStack(Material.GLASS);
    protected ItemStack leftbutton = setLeftButton();
    protected ItemStack rightbutton = setRightButton();
    protected ItemStack backbutton = setBackButton();

    public FoxPaginatedMenu(FoxUtility playerUtility) {
        super(playerUtility);
    }

    public abstract List<?> getData();

    public abstract void loopCode(Object object);

    @Nullable
    public abstract HashMap<Integer, ItemStack> getCustomMenuBorderItems();

    protected void addMenuBorder() {
        inventory.setItem(48, leftbutton);
        inventory.setItem(49, backbutton);
        inventory.setItem(50, rightbutton);

        for (int i = 0; i < 10; i++) {
            if (inventory.getItem(i) == null) {
                inventory.setItem(i, defaultBorder);
            }
        }

        inventory.setItem(17, defaultBorder);
        inventory.setItem(18, defaultBorder);
        inventory.setItem(26, defaultBorder);
        inventory.setItem(27, defaultBorder);
        inventory.setItem(35, defaultBorder);
        inventory.setItem(36, defaultBorder);

        for (int i = 44; i < 54; i++) {
            if (inventory.getItem(i) == null) {
                inventory.setItem(i, defaultBorder);
            }
        }

        if (getCustomMenuBorderItems() != null) {
            getCustomMenuBorderItems().forEach((integer, itemStack) -> inventory.setItem(integer, itemStack));
        }
    }

    @Override
    public void setItems() {
        addMenuBorder();
        List<Object> data = (List<Object>) getData();
        if (data != null && !data.isEmpty()) {
            for (int i = 0; i < getMaxItemsPerPage(); i++) {
                index = getMaxItemsPerPage() * page + i;
                System.out.println(index);
                if (index >= data.size()) break;
                if (data.get(index) != null) {
                    loopCode(data.get(index));
                }
            }
        }
    }

    @Override
    public void onOpenInventory() {
        return;
    }

    @Override
    public void onCloseInventory() {
        return;
    }

    public boolean prevPage() {
        if (page == 0) {
            return false;
        } else {
            page = page - 1;
            reloadItems();
            return true;
        }
    }

    public boolean nextPage() {
        if (!((index + 1) >= getData().size())) {
            page = page + 1;
            reloadItems();
            return true;
        } else {
            return false;
        }
    }

    public abstract ItemStack setBackButton();

    public abstract ItemStack setLeftButton();

    public abstract ItemStack setRightButton();

    public int getMaxItemsPerPage() {
        return maxItemsPerPage;
    }
}
