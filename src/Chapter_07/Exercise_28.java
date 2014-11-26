package Chapter_07;

import java.util.Scanner;

/**
 * Chapter 7 Exercise 28:
 *
 *      (Math: combinations)
 *      Write a program that prompts the user to enter 10 integers
 *      and displays all combinations of picking two numbers from the 10.
 *
 *      // 1 2 3 4 5 6 7 8 9 10
 *
 * Created by Luiz Arantes Sa on 8/28/14
 */
public class Exercise_28 {

    public static void main(String[] args) {

        int[] numbers = new int[10];
        Scanner input = new Scanner(System.in);

        System.out.print("Enter 10 numbers: ");
        for (int i = 0; i < 10; i++) numbers[i] = input.nextInt();

        for (int i = 0; i < numbers.length; i++) {

            for (int k = 0; k < numbers.length; k++) {
                if (k != i) {
                    System.out.print(numbers[i] + "-" + numbers[k] + " ");
                }
            }
            System.out.println("");
        }
    }


}
