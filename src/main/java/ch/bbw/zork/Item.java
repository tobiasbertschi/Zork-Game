package ch.bbw.zork;

public class Item {

    public static enum Types {
        KEY,
        PAPER,
        WEAPON
    }
    private Types type;
    private int id;
    private String note;
    private String description;


    public Item(Types type, int id, String note, String description) {
        this.type = type;
        this.id = id;
        this.note = note;
        this.description = description;
    }

    public Types getType() {
        return type;
    }

    public void setType(Types type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
