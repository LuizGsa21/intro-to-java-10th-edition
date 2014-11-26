package Chapter_07;

import java.util.Scanner;

/**
 * Chapter 7 Exercise 13:
 *
 *      (Random number chooser) Write a method that returns a random number between 1 and 54,
 *      excluding the numbers passed in the argument.
 *      The method header is specified as follows:
 *
 *       - public static int getRandom(int... numbers)
 *
 * Created by Luiz Arantes Sa on 8/27/14.
 */
public class Exercise_13 {

    static final int SIZE = 10;
    public static void main(String[] args) {

        int[] numbers = new int[SIZE];
        Scanner input = new Scanner(System.in);

        System.out.print("Enter ten numbers to exclude from random (1-54): ");
        for (int i = 0; i < numbers.length; i++) numbers[i] = input.nextInt();

        System.out.println("Number generated: " + getRandom(numbers));
    }

    public static int getRandom(int... numbers) {

        int random = (int)(Math.random() * 54 + 1);
        for (int i = 0; i < numbers.length; i++) {
            if (random == numbers[i]) {
                random = (int)(Math.random() * 54 + 1);
                i = -1;
            }
        }
        return random;
    }



}
