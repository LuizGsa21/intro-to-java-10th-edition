package Chapter_03;

import java.util.Scanner;

/**
 * Chapter 3 Exercise 10:
 *
 *      (Game: addition quiz)
 * Created by Luiz Arantes Sa on 6/22/14.
 */
public class Exercise_10 {

    public static void main(String[] strings) {

        // 1. Generate two random numbers less than 100
        int number1 = (int) (Math.random() * 100);
        int number2 = (int) (Math.random() * 100);

        System.out.print("What is " + number1 + " + " + number2 + "? ");
        Scanner input = new Scanner(System.in);
        int answer = input.nextInt();

        if (number1 + number2 == answer) {
            System.out.println("You are correct!");
        } else {
            System.out.print("Your answer is wrong.");
            System.out.print(number1 + " + " + number2 + " is " + (number1 + number2));
        }

    }
}
