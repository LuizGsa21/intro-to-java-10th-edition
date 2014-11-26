package Chapter_07;

import java.util.Scanner;

/**
 * Chapter 7 Exercise 10:
 *
 *      (Find the index of the smallest element)
 *      Write a method that returns the index of the smallest element in an array of integers.
 *      If the number of such elements is greater than 1, return the smallest index. Use the following header:
 *
 *          - public static int indexOfSmallestElement(double[] array)
 *
 *      Write a test program that prompts the user to enter ten numbers, invokes this
 *      method to return the index of the smallest element, and displays the index.
 *
 * Created by Luiz Arantes Sa on 8/27/14.
 */
public class Exercise_10 {

    static final int SIZE = 10;

    public static void main(String[] args) {

        double[] numbers = new double[SIZE];
        Scanner input = new Scanner(System.in);

        System.out.print("Enter " + SIZE + " numbers: ");
        for (int i = 0; i < numbers.length; i++) numbers[i] = input.nextDouble();

        System.out.println("The index of the smallest number is: " + indexOfSmallestElement(numbers));

    }

    public static int indexOfSmallestElement(double[] array) {

        int index = 0;
        double low = array[index];
        for (int i = 0; i < array.length; i++) {

            if (low > array[i]) {
                low = array[i];
                index = i;
            }
        }
        return index;
    }
}
