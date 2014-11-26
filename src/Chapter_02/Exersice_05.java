package Chapter_02;

import java.util.Scanner;

/**
 * Chapter 2 Exercise 5:
 *
 *      (Financial application: calculate tips) Write a program that reads the subtotal
 *       and the gratuity rate, then computes the gratuity and total.
 *
 * Created by Luiz Arantes Sa on 6/19/14.
 */
public class Exersice_05 {

    public static void main(String[] Strings) {

        double gratuityRate,
                gratuityTotal,
                total,
                subtotal;

        Scanner input = new Scanner(System.in);

        System.out.print("Please enter the subtotal and gratuity rate: ");
        subtotal = input.nextDouble();
        gratuityRate = input.nextDouble();

        gratuityTotal = subtotal * gratuityRate * .01;
        total = subtotal + gratuityTotal;

        System.out.print("The gratuity is $" + gratuityTotal + " and total is $" + total);

    }
}
