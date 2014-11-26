package Chapter_03;

import java.util.Scanner;

/**
 * Chapter 3 Exercise 14:
 *
 *      (Game: heads or tails)
 *
 * Created by Luiz Arantes Sa on 6/22/14.
 */
public class Exercise_14 {

    public static void main(String[] strings) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter 0 for heads or 1 for tails: ");
        int userGuess = input.nextInt();

        System.out.println("Flipping coin...");
        int coinSide = (int) (Math.random() * 2.0);

        if (userGuess == coinSide) {
            System.out.println("Good job! You guess is correct.");
        } else if (coinSide == 0) {
            System.out.println("Sorry, it is a head");
        } else {
            System.out.println("Sorry, it is a tail");
        }

    }
}
