package fr.sothis.api;

import fr.sothis.api.menus.MenuManager;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.plugin.Plugin;

public class FoxApi {

    public void setup(Server server, Plugin plugin) {
        Bukkit.getLogger().info("FoxAPI initialized");
        MenuManager.registerMenuListener(server, plugin);
    }
}
