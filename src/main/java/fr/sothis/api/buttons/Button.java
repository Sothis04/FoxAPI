package fr.sothis.api.buttons;

import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.function.Consumer;

public class Button {

    private HashMap<State, Consumer<Inventory>> consumerHashMap;
    private String key;

    public Button(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public Button mapState(State state, Consumer<Inventory> consumer) {
        consumerHashMap.put(state, consumer);
        return this;
    }

    public HashMap<State, Consumer<Inventory>> getConsumerHashMap() {
        return consumerHashMap;
    }
}
