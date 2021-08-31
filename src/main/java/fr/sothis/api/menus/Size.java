package fr.sothis.api.menus;

public enum Size {

    ONEROW(9),
    TWOROWS(18),
    THREEROWS(27),
    FOURROWS(36),
    FIVEROWS(45),
    SIXROWS(54);

    private int number;

    Size(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
