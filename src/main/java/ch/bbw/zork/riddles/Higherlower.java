package ch.bbw.zork.riddles;

import ch.bbw.zork.Riddle;

import java.util.Scanner;

public class Higherlower implements Riddle {

    boolean solved = false;
    Scanner scanner = new Scanner(System.in);


    @Override
    public void start() {
        System.out.println("this is  a riddle");
        System.out.println("you have to guess my number");
        System.out.println("my number is between 1 and 1000");
        riddle();
        if (solved){
            System.out.println("the riddle is solved");

        }

    }

    @Override
    public void riddle() {
        int solution = (int) (Math.random() * (1000 - 1)) + 1;
        int number = 0;
        boolean solved = false;
        while (!solved){

            number = scanner.nextInt();
            if (number == solution) {
                solved = true;
            } else if (number < solution){
                System.out.print("my number is higher \n");
            }else if (number > solution){
                System.out.print("my number is lower \n");
            }

        }
        System.out.println("you solved the riddle");
    }
}
