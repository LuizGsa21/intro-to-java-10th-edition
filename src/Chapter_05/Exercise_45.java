package Chapter_05;

import java.util.Scanner;

/**
 * Chapter 5 Exercise 45:
 *
 *      (Statistics: compute mean and standard deviation) In business applications,
 *      you are often asked to compute the mean and standard deviation of data.
 *      The mean is simply the average of the numbers. The standard deviation
 *      is a statistic that tells you how tightly all the various data are
 *      clustered around the mean in a set of data. For example, what is the average
 *      age of the students in a class? How close are the ages? If all the students are
 *      the same age, the deviation is 0. Write a program that prompts the user to
 *      enter ten numbers, and displays the mean and standard deviations of these numbers
 *      using the provided formula
 *
 * Created by Luiz Arantes Sa on 8/24/14.
 */
public class Exercise_45 {

    public static void main(String[] strings) {

        double total = 0.0;
        double squareTotal = 0.0;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");

        for (int i = 0; i < 10; i++) {
            double number = input.nextDouble();
            total += number;
            squareTotal += Math.pow(number, 2.0);
        }
        double deviation = Math.pow((squareTotal - total * total / 10.0) / 9.0, 0.5);
        double mean = total / 10.0;

        System.out.println("The mean is " + mean);
        System.out.println("The standard deviation is " + deviation);
    }
}
