package ch.bbw.zork;

public class Map {

    public static void show(Room currentroom) {

        System.out.println("you are in " + currentroom.shortDescription());
        System.out.println("This dungeon:\n" +
                "      Ent\n" +
                "       |\n" +
                "       |\n" +
                "Kit---Din---Bat\n" +
                "       |\n" +
                "       |\n" +
                "      Bas---Lib---Stu\n" +
                "       |\n" +
                "       |\n" +
                "Arm---For---Pri");
    }
    
}
