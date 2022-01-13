package ch.bbw.zork.riddles;

import ch.bbw.zork.Riddle;

public class Hangman implements Riddle {
    @Override
    public void solved() {
        System.out.println("the riddle is solved");

    }

    @Override
    public boolean start() {
        System.out.println("riddle is here");


        return true;
    }
}
