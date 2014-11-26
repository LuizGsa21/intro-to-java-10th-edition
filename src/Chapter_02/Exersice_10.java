package Chapter_02;

import java.util.Scanner;

/**
 * Chapter 2 Exercise 10:
 *
 *      (Science: calculating energy)
 * Created by Luiz Arantes Sa on 6/20/14.
 */
public class Exersice_10 {

    public static void main(String[] Strings) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the amount of water in kilograms: ");
        double kilograms = input.nextDouble();

        System.out.print("Enter the initial temperature: ");
        double initialTemp = input.nextDouble();

        System.out.print("Enter the final temperature: ");
        double finalTemp = input.nextDouble();

        double energyNeeded = kilograms * (finalTemp - initialTemp) * 4184;
        System.out.print("The energy needed is " + energyNeeded);
    }
}
