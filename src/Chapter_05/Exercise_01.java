package Chapter_05;

import java.util.Scanner;

/**
 * Chapter 5 Exercise 1:
 *
 *      (Count positive and negative numbers and compute the average of numbers)
 *      Write a program that reads an unspecified number of integers, determines how many
 *      positive and negative values have been read, and computes the total and average
 *      of the input values (not counting zeros). Your program ends with the input 0. Display
 *      the average as a floating-point number.
 *
 * Created by Luiz Arantes Sa on 8/24/14.
 */
public class Exercise_01 {

    public static void main(String[] args) {


        // Creating variables to hold pos/neg/average/total
        int positive = 0;
        int negative = 0;
        int total = 0;
        double average = 0;
        System.out.print("Enter an integer, the input ends if it is 0: ");
        Scanner input = new Scanner(System.in);

        for (int buffer = -1; buffer != 0; ) {

            buffer = input.nextInt();
            if (buffer > 0) positive++;
            else if (buffer < 0) negative++;
            total += buffer;
        }
        if (positive + negative == 0) {
            System.out.println("No numbers are entered except 0");
            System.exit(0);
        }
        average = total /(double)(positive + negative);
        System.out.println("The number of positives is " + positive);
        System.out.println("The number of negatives is " + negative);
        System.out.println("The total is " + total);
        System.out.println("The average is " + average);
    }
}
