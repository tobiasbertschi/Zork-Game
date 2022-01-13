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

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
