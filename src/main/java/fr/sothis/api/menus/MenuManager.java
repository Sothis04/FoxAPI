package fr.sothis.api.menus;

import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.RegisteredListener;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class MenuManager implements Listener {

    private static final HashMap<Player, FoxUtility> registerSUtility = new HashMap<>();

    public static void registerMenuListener(Server server, Plugin plugin) {
        boolean registered = false;
        for (RegisteredListener registeredListener : InventoryClickEvent.getHandlerList().getRegisteredListeners()) {
            System.out.println(registeredListener.getListener().getClass().getSimpleName());
            if (registeredListener.getListener() instanceof MenuManager){
                registered = true;
                break;
            }
        }
        if (!registered){
            server.getPluginManager().registerEvents(new MenuManager(), plugin);
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        InventoryHolder holder = event.getInventory().getHolder();
        if (holder instanceof Menu) {
            if (event.getCurrentItem() == null) {
                return;
            }
            FoxMenu menu = (FoxMenu) holder;
            if (!menu.enablePickItem()){
                event.setCancelled(true);
            }
            menu.onEvent(event);
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

    }

    public static void openMenu(Class<? extends FoxMenu> menuClass, Player player) {
        getSUtility(player).getLastMenu().onCloseInventory();
        try {
            menuClass.getConstructor(FoxUtility.class).newInstance(getSUtility(player)).open();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public static FoxUtility getSUtility(Player player) {
        FoxUtility sPlayer;
        if (!(registerSUtility.containsKey(player))) {
            sPlayer = new FoxUtility(player);
            registerSUtility.put(player, sPlayer);
            return sPlayer;
        } else {
            return registerSUtility.get(player);
        }
    }
}
