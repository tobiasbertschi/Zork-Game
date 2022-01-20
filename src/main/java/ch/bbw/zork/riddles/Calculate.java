package ch.bbw.zork.riddles;

import ch.bbw.zork.Riddle;
import java.util.Scanner;

public class Calculate implements Riddle {

    boolean solved = false;
    Scanner scanner = new Scanner(System.in);


    @Override
    public boolean start() {
        System.out.println("this is  a riddle");
        System.out.println("you have to calculate");
        riddle();
        if (solved){
            System.out.println("the riddle is solved");
            return true;
        }
        return false;
    }

    @Override
    public void riddle() {
    int number1 = (int) (Math.random() * (1000 - 1)) + 1;
    int number2 = (int) (Math.random() * (1000 - 1)) + 1;
    int solution = number1 + number2;
    System.out.println(number1 +" + "+ number2);
    int guess;

    while (!solved){
            guess = scanner.nextInt();
            if (guess == solution){
                solved = true;
            }else {
                System.out.println("The answer was not correct try again");
                System.out.println(number1 +" + "+ number2);
            }
    }
    }
}
