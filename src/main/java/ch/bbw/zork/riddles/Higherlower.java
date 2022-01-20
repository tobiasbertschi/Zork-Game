package ch.bbw.zork.riddles;

import ch.bbw.zork.Riddle;

import java.util.Scanner;

public class Higherlower implements Riddle {

    boolean solved = false;
    Scanner scanner = new Scanner(System.in);


    @Override
    public boolean start() {
        System.out.println("This is a riddle.");
        System.out.println("You have to guess my number.");
        System.out.println("My number is between 1 and 1000.");
        riddle();
        if (solved){
            System.out.println("The riddle is solved.");
            return true;
        }
        return false;
    }

    @Override
    public void riddle() {
        int solution = (int) (Math.random() * (1000 - 1)) + 1;
        int number = 0;
        while (!solved){
            number = scanner.nextInt();
            if (number == solution) {
                solved = true;
            } else if (number < solution){
                System.out.print("My number is higher! \n");
            }else if (number > solution){
                System.out.print("My number is lower! \n");
            }

        }
    }
}
