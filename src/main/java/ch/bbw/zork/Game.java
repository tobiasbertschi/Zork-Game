package ch.bbw.zork;import ch.bbw.zork.riddles.Calculate;import ch.bbw.zork.riddles.Guess;import ch.bbw.zork.riddles.Higherlower;import java.util.*;/** * Class Game - the main class of the "Zork" game. * Author: Tobias Bertschi, Yves Huber */public class Game {    private Room lastRoom;    private Parser parser;    private Room currentRoom;    private Room entrance, dining_hall, kitchen, basement, bath, libary, study, forge, armory, prison;    private ArrayList<Item> backpack;    public Game() {        Guess guess = new Guess("its longer than a meter", "2 meters");        Higherlower higherlower = new Higherlower();        Calculate calculate = new Calculate();        backpack = new ArrayList<Item>();        Item key1 = new Item(Item.Types.KEY, 1, "key", "This is a Key.");        Item key2 = new Item(Item.Types.KEY, 2, "new key", "This is a Key");        Item key3 = new Item(Item.Types.KEY, 3, "old key", "This is a Key");        Item tipp1 = new Item(Item.Types.PAPER, 4, "tipp", "If you want to go to the bath you need the sword.");        Item tipp2 = new Item(Item.Types.PAPER, 5, "tipp", "The end of the game is in study.");        Item tipp3 = new Item(Item.Types.PAPER, 6, "tipp", "Nice work you can do it.");        Item sword = new Item(Item.Types.WEAPON, 7, "sword", "This weapon is used to enter a room.");        Item old_sword = new Item(Item.Types.WEAPON, 8, "old-sword", "Well done you found de valuable Sword from the medieval.");        parser = new Parser(System.in);        entrance = new Room("the dungeon entrance");        dining_hall = new Room("the gloomy dinging-hall", key2, guess);        kitchen = new Room("the medieval kitch", key3, guess, true, key2);        basement = new Room("the dank basement");        bath = new Room("the moist bath", key1, guess);        libary = new Room("the dusty libary", tipp3, guess, true, key3);        study = new Room("the crammed study", old_sword, guess, true, sword);        forge = new Room("the nast forge", tipp1, guess, true, key1);        armory = new Room("the rusty armory", sword, guess);        prison = new Room("the gruesome prison", tipp2, guess);        entrance.setExits(null, null, dining_hall, null);        dining_hall.setExits(entrance, bath, basement, kitchen);        kitchen.setExits(null, dining_hall, null, null);        basement.setExits(dining_hall, libary, forge, null);        bath.setExits(null, null, null, dining_hall);        libary.setExits(null, study, null, basement);        study.setExits(null, null, null, libary);        forge.setExits(basement, prison, null, armory);        armory.setExits(null, forge, null, null);        prison.setExits(null, null, null, forge);        currentRoom = entrance; // start game entrance    }    /**     * Main play routine.  Loops until end of play.     */    public void play() {        printWelcome();        // Enter the main command loop.  Here we repeatedly read commands and        // execute them until the game is over.        boolean finished = false;        while (!finished) {            Command command = parser.getCommand();            finished = processCommand(command);        }        System.out.println("Thank you for playing.  Good bye.");    }    private void printWelcome() {        System.out.println();        System.out.println("Welcome to Zork!");        System.out.println("Zork is a simple adventure game.");        System.out.println("Type 'items' if you want to see your items.");        System.out.println("Type 'search' if you want to pick the item.");        System.out.println("Type 'help' if you need help.");        System.out.println("Type 'quit' if you want to quit the game.");        System.out.println();        System.out.println(currentRoom.longDescription());    }    private boolean processCommand(Command command) {        if (command.isUnknown()) {            System.out.println("I don't know what you mean...");            return false;        }        String commandWord = command.getCommandWord();        if (commandWord.equals("help")) {            printHelp();        } else if (commandWord.equals("go")) {            goRoom(command);        } else if (commandWord.equals("quit")) {            if (command.hasSecondWord()) {                System.out.println("Quit what?");            } else {                return true; // signal that we want to quit            }        } else if (commandWord.equals("items")) {            printItems();        } else if (commandWord.equals("search")) {            if (currentRoom.getRiddle() != null) {                if (currentRoom.startRiddle()) {                    System.out.println("you solved the riddle");                    pickItems();                }            } else {                System.out.println("there is nothing interesting here");            }        }        else if (commandWord.equals("map")) {            Map.show(currentRoom);        }        else if (commandWord.equals("back")) {            back();        }        return false;    }    private void printHelp() {        System.out.println("You are lost. You are alone. You wander");        System.out.println("around at Monash Uni, Peninsula Campus.");        System.out.println();        System.out.println("Your command words are:");        System.out.println(parser.showCommands());    }    private void printItems() {        System.out.println(toString().toString());        System.out.println("Your command words are:");        System.out.println(parser.showCommands());    }    private void pickItems() {        if (currentRoom.getItem() == null) {            System.out.println("This room is empty.");        } else {            backpack.add(currentRoom.getItem());            System.out.println("you picked up " + currentRoom.getItem().getNote());        }        System.out.println("Your commands are words are:");        System.out.println(parser.showCommands());    }    private void back() {        if (lastRoom != null) {            currentRoom = lastRoom;            System.out.println(currentRoom.longDescription());        }else {            System.out.println("you cant go back");        }    }    private void goRoom(Command command) {        if (!command.hasSecondWord()) {            System.out.println("Go where?");        } else {            String direction = command.getSecondWord();            // Try to leave current room.            Room nextRoom = currentRoom.nextRoom(direction);/*            if (nextRoom == office) {                System.out.println("Das Fenster ist offen, brrrrrrr");            }*/            if (nextRoom == null)                System.out.println("There is no door!");            else {                // Check if room is locked                if (nextRoom.isLocked()) {                    if (nextRoom.unlock(backpack)) {                        System.out.println("You unlocked the door.");                        lastRoom = currentRoom;                        currentRoom = nextRoom;                        System.out.println(currentRoom.longDescription());                    } else {                        System.out.println("You don't have the required item.");                    }                } else if (!nextRoom.isLocked()) {                    lastRoom = currentRoom;                    currentRoom = nextRoom;                    System.out.println(currentRoom.longDescription());                }            }        }    }    @Override    public String toString() {        String output = "";        for (Item item : backpack) {            if (item.getType() == Item.Types.KEY) {                output += "Type = " + item.getType() + ", " + "Name = " + item.getNote() + "\n";            } else if (item.getType() == Item.Types.PAPER) {                output += "Type = " + item.getType() + ", " + "Description " + item.getDescription() + "\n";            } else if (item.getType() == Item.Types.WEAPON) {                output += "Type = " + item.getType() + ", " + "Name = " + item.getNote() + "," + "Description " + item.getDescription() + "\n";            }        }        return output;    }}