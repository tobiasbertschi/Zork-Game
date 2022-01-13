package ch.bbw.zork;import ch.bbw.zork.riddles.Guess;import ch.bbw.zork.riddles.Higherlower;/** * Class Game - the main class of the "Zork" game. * Author: Tobias Bertschi, Yves Huber */public class Game {    private Parser parser;    private Room currentRoom;    private Room entrance, dining_hall, kitchen, basement, bath, libary, study, forge, armory, prison;    public Game() {        Guess guess = new Guess("its longer than a meter", "2 meters");        Higherlower higherlower = new Higherlower();        parser = new Parser(System.in);        entrance = new Room("the dungeon entrance");        dining_hall = new Room("the gloomy dinging-hall");        kitchen = new Room("the medieval kitch");        basement = new Room("the dank basement");        bath = new Room("the moist bath");        libary = new Room("the dusty libary");        study = new Room("the crammed study");        forge = new Room("the nast forge");        armory = new Room("the rusty armory");        prison = new Room("the gruesome prison");        entrance.setExits(null, null, dining_hall, null);        dining_hall.setExits(entrance, bath, basement, kitchen);        kitchen.setExits(null, dining_hall, null, null);        basement.setExits(dining_hall, libary, forge, null);        bath.setExits(null, null, null, dining_hall);        libary.setExits(null, study, null, basement);        study.setExits(null, null, null, libary);        forge.setExits(basement, prison, null, armory);        armory.setExits(null, forge, null, null);        prison.setExits(null, null, null, forge);        currentRoom = entrance; // start game entrance    }    /**     * Main play routine.  Loops until end of play.     */    public void play() {        printWelcome();        // Enter the main command loop.  Here we repeatedly read commands and        // execute them until the game is over.        boolean finished = false;        while (!finished) {            Command command = parser.getCommand();            finished = processCommand(command);        }        System.out.println("Thank you for playing.  Good bye.");    }    private void printWelcome() {        System.out.println();        System.out.println("Welcome to Zork!");        System.out.println("Zork is a simple adventure game.");        System.out.println("Type 'help' if you need help.");        System.out.println();        System.out.println(currentRoom.longDescription());    }    private boolean processCommand(Command command) {        if (command.isUnknown()) {            System.out.println("I don't know what you mean...");            return false;        }        String commandWord = command.getCommandWord();        if (commandWord.equals("help")) {            printHelp();        } else if (commandWord.equals("go")) {            goRoom(command);        } else if (commandWord.equals("quit")) {            if (command.hasSecondWord()) {                System.out.println("Quit what?");            } else {                return true; // signal that we want to quit            }        } else if (commandWord.equals("search")){            currentRoom.startRiddle();        }        return false;    }    private void printHelp() {        System.out.println("You are lost. You are alone. You wander");        System.out.println("around at Monash Uni, Peninsula Campus.");        System.out.println();        System.out.println("Your command words are:");        System.out.println(parser.showCommands());    }    private void goRoom(Command command) {        if (!command.hasSecondWord()) {            System.out.println("Go where?");        } else {            String direction = command.getSecondWord();            // Try to leave current room.            Room nextRoom = currentRoom.nextRoom(direction);/*            if (nextRoom == office) {                System.out.println("Das Fenster ist offen, brrrrrrr");            }*/            if (nextRoom == null)                System.out.println("There is no door!");            else {                currentRoom = nextRoom;                System.out.println(currentRoom.longDescription());            }        }    }}