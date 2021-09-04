package fr.sothis.api.buttons;

import java.util.Arrays;

public enum State {

    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9);

    private int filter;

    State(int number) {
        this.filter = number;
    }

    public static State getByNumber(int filter) {
        return Arrays.stream(values()).filter(state -> state.getFilter() == filter).findFirst().orElse(State.ONE);
    }

    public int getFilter() {
        return filter;
    }
}
