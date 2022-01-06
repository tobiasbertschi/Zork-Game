package ch.bbw.zork;

public class Item {

    public static enum Types {
        KEY,
        NOTE,
        WEAPON
    }

    private Types type;

    private int weight;

    private String name;

    public Item(Types type, int weight, String name) {
        this.type = type;
        this.weight = weight;
        this.name = name;
    }

}
