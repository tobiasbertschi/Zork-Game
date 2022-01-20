package ch.bbw.zork.riddles;

import ch.bbw.zork.Riddle;

import java.util.Scanner;


public class Guess implements Riddle {

    boolean solved = false;
    Scanner scanner = new Scanner(System.in);
    String tip;
    String word;

    public Guess(String tip, String word) {
        this.tip = tip;
        this.word = word;
    }

    @Override
    public boolean start() {
        System.out.println("This is  a riddle!");
        riddle();
        if (solved){
            System.out.println("The riddle is solved!");
            return true;
        }
        return false;
    }

    @Override
    public void riddle() {
        System.out.println(tip);
        String string = "";
        while (!solved){
            string = scanner.nextLine();
            if (string.equals(word)){
                solved = true;
            }
        }
    }
}
