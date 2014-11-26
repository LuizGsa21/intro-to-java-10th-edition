package Chapter_03;

import java.util.Scanner;

/**
 * Chapter 3 Exercise 18:
 *
 *      (Cost of shipping)
 *
 * Created by Luiz Arantes Sa on 6/22/14.
 */
public class Exercise_18 {

    public static void main(String[] strings) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the amount of weight: ");
        double weight = input.nextDouble();
        input.close();

        double cost = getCost(weight);
        System.out.printf("The cost is: $%.2f", cost);

    }

    private static double getCost(double weight) {

        if (weight > 50) {
            System.out.println("The package cannot be shipped.");
            System.exit(0);
        } else if (weight < 0) {
            System.out.println("Invalid weight...");
            System.exit(0);
        }

        double cost;

        if (weight <= 1) {
            cost = 3.5;
        } else if (weight <= 3) {
            cost = 5.5;
        } else if (weight <= 10) {
            cost = 8.5;
        } else {
            cost = 10.5;
        }

        return cost * weight;
    }
}

