package Chapter_05;

import java.util.Scanner;

/**
 * Chapter 5 Exercise 44:
 *
 *      (Computer architecture: bit-level operations) A short value is stored in 16 bits.
 *      Write a program that prompts the user to enter a short integer
 *      and displays the 16 bits for the integer.
 *
 * Created by Luiz Arantes Sa on 8/24/14.
 */
public class Exercise_44 {

    public static void main(String[] strings) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int number = input.nextInt();

        System.out.print("The 16 bits are ");

        for (int i = 15; i >= 0; i--) {

            System.out.print((number >> i) & 1);
        }

    }
}
