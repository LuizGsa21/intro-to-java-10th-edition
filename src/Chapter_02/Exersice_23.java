package Chapter_02;

import java.util.Scanner;

/**
 * Chapter 2 Exercise 23:
 *
 *      (Cost of driving)
 *      Write a program that prompts the user to enter the distance to drive,
 *      the fuel efficiency of the car in miles per gallon, and the price per gallon,
 *      and displays the cost of the trip.
 *
 * Created by Luiz Arantes Sa on 6/20/14.
 */
public class Exersice_23 {

    public static void main(String[] Strings) {

        Scanner input = new Scanner(System.in);

        double distance;
        double milesPerGallon;
        double pricePerGallon;

        // Getting input from user
        System.out.print("Enter the driving distance: ");
        distance = input.nextDouble();

        System.out.print("Enter miles per gallon: ");
        milesPerGallon = input.nextDouble();

        System.out.print("Enter price per gallon: ");
        pricePerGallon = input.nextDouble();

        input.close(); // closing scanner

        double total = distance / milesPerGallon * pricePerGallon;
        // Displaying total cost
        System.out.printf("The cost of driving is $%.2f", total);
    }
}
