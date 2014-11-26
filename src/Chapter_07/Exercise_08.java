package Chapter_07;


import java.util.Scanner;

/**
 * Chapter 7 Exercise 8:
 *
 *      (Average an array)
 *      Write two overloaded methods that return the average of an array
 *      with the following headers:
 *
 *      - public static int average(int[] array)
 *      - public static double average(double[] array)
 *
 *      Write a test program that prompts the user to enter ten double values,
 *      invokes this method, and displays the average value.
 *
 * Created by Luiz Arantes Sa on 8/27/14.
 */
public class Exercise_08 {

    static final int SIZE = 10;

    public static void main(String[] args) {

        double[] numbers = new double[SIZE];
        Scanner input = new Scanner(System.in);
        System.out.print("Enter 10 double numbers: ");
        for (int i = 0; i < numbers.length; i++) numbers[i] = input.nextDouble();

        System.out.println("The average value is: " + average(numbers));

    }

    public static int average(int[] array) {
        int total = 0;
        for (int i = 0; i < array.length; i++) {
            total += array[i];
        }
        return total / array.length;
    }

    public static double average(double[] array) {
        double total = 0;
        for (int i = 0; i < array.length; i++) {
            total += array[i];
        }
        return total / array.length;
    }

    public static void printArray(int[] array, int numberPerLine) {

        for (int i = 0; i < array.length; i++) {

            System.out.printf("%4d", array[i]);
            if ((i + 1) % numberPerLine == 0) System.out.println("");
        }
    }
}
