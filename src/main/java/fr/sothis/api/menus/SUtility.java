package fr.sothis.api.menus;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Vector;

public class SUtility {

    private final Player player;
    private final Vector<SMenu> historic = new Vector<>();
    private final HashMap<String, Object> dataMap = new HashMap<>();

    public SUtility(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setData(String identifier, Object data){
        this.dataMap.put(identifier, data);
    }

    public void setData(Enum identifier, Object data){
        this.dataMap.put(identifier.toString(), data);
    }

    public Object getData(String identifier){
        return this.dataMap.get(identifier);
    }

    public Object getData(Enum identifier){
        return this.dataMap.get(identifier.toString());
    }

    public <T> T getData(String identifier, Class<T> classRef){
        Object obj = this.dataMap.get(identifier);
        if (obj == null){
            return null;
        }else{
            return classRef.cast(obj);
        }
    }

    public <T> T getData(Enum identifier, Class<T> classRef){
        Object obj = this.dataMap.get(identifier.toString());
        if (obj == null){
            return null;
        }else{
            return classRef.cast(obj);
        }
    }

    public SMenu getLastMenu() {
        return historic.lastElement();
    }

    public SMenu backMenu() {
        SMenu sMenu = historic.lastElement();
        historic.remove(sMenu);
        return sMenu;
    }

    public void pushMenu(SMenu menu) {
        historic.add(menu);
    }
}
