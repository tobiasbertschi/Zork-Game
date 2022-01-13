package ch.bbw.zork;import java.util.ArrayList;import java.util.HashMap;import java.util.List;import java.util.stream.Collectors;/** * Author: Tobias Bertschi, Yves Huber */public class Room {    private String description;    private HashMap<String, Room> exits;    private Riddle riddle;    public Room(String description) {        this.description = description;        this.exits = new HashMap<>();    }    public Room(String description, Riddle riddle) {        this.description = description;        this.exits = new HashMap<>();        this.riddle = riddle;    }    public void setExits(Room north, Room east, Room south, Room west) {        exits.put("north", north);        exits.put("east", east);        exits.put("south", south);        exits.put("west", west);    }    public String shortDescription() {        return description;    }    public String longDescription() {        StringBuilder stringBuilder = new StringBuilder("You are in " + description + ".\n");        stringBuilder.append(exitString());        return stringBuilder.toString();    }    public void startRiddle(){        riddle.start();    }    private String exitString() {        return "Exits:" + String.join(" ", exits.keySet());    }    public Room nextRoom(String direction) {        return exits.get(direction);    }}