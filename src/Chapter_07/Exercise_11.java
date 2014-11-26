package Chapter_07;

import java.util.Scanner;

/**
 * Chapter 7 Exercise 11:
 *
 *      (Statistics: compute deviation)
 *      Programming Exercise 5.45 computes the standard deviation of numbers.
 *      This exercise uses a different but equivalent formula to compute the standard deviation of n numbers.
 *      To compute the standard deviation with this formula, you have to store the individual
 *      numbers using an array, so that they can be used after the mean is obtained.
 *
 *      Your program should contain the following methods:
 *          - public static double deviation(double[] x)
 *          - public static double mean(double[] x)
 *
 *
 * Created by Luiz Arantes Sa on 8/27/14.
 */
public class Exercise_11 {

    static final int SIZE = 10;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        double[] numbers = new double[SIZE];
        System.out.print("Enter " + SIZE + " numbers: ");
        for (int i = 0; i < numbers.length; i++) numbers[i] = input.nextDouble();

        System.out.println("The mean is: " + mean(numbers));
        System.out.println("The standard deviation is: " + deviation(numbers));

    }

    public static double deviation(double[] x) {

        double mean = mean(x);
        double deviation = 0;
        for (int i = 0; i < x.length; i++) {
            deviation += Math.pow(x[i] - mean, 2);
        }
        return Math.sqrt(deviation / (x.length - 1));
    }
    public static double mean(double[] x) {

        double total = 0;
        for (int i = 0; i < x.length; i++) {
            total += x[i];
        }
        System.out.println(total);
        return total / x.length;
    }



}
