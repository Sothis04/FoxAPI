package fr.sothis.api.buttons;

import java.util.HashMap;

public class ButtonManager {

    private static HashMap<String, Button> allButtons = new HashMap<>();

    public static void addButton(Button button) {
        allButtons.put(button.getKey(), button);
    }

    public static HashMap<String, Button> getAllButtons() {
        return allButtons;
    }
}
