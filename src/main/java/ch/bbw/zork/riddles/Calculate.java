package ch.bbw.zork.riddles;

import ch.bbw.zork.Riddle;
import java.util.Scanner;

public class Calculate implements Riddle {

    boolean solved = false;
    Scanner scanner = new Scanner(System.in);
    int max;

    public Calculate (int max) {
        this.max = max;
    }


    @Override
    public boolean start() {
        System.out.println("This is  a riddle.");
        System.out.println("You have to calculate.");
        riddle();
        if (solved){
            System.out.println("The riddle is solved!");
            return true;
        }
        return false;
    }

    @Override
    public void riddle() {
    int number1 = (int) (Math.random() * (max - 1)) + 1;
    int number2 = (int) (Math.random() * (max - 1)) + 1;
    int solution = number1 + number2;
    System.out.println(number1 +" + "+ number2);
    int guess;

    while (!solved){
            guess = scanner.nextInt();
            if (guess == solution){
                solved = true;
            }else {
                System.out.println("The answer was not correct try again!");
                System.out.println(number1 +" + "+ number2);
            }
    }
    }
}
