package Chapter_07;

import java.util.Scanner;

/**
 * Chapter 7 Exercise 20:
 *
 *      (Revise selection sort)
 *      In Section 7.11, you used selection sort to sort an array. The selection-sort
 *      method repeatedly finds the smallest number in the current array and swaps
 *      it with the first. Rewrite this program by finding the largest number and
 *      swapping it with the last. Write a test program that reads in ten double numbers,
 *      invokes the method, and displays the sorted numbers.
 *
 * Created by Luiz Arantes Sa on 8/27/14.
 */
public class Exercise_20 {

    static final int SIZE = 10;
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        double[] numbers = new double[SIZE];

        System.out.print("Enter " + SIZE + " numbers: ");
        for (int i = 0; i < numbers.length; i++) numbers[i] = input.nextDouble();

        selectionSort(numbers);
        printArray(numbers, 10);
    }

    public static void selectionSort(double[] numbers) {

        for (int i = numbers.length - 1; i > 1 ; i--) {
            int currentIndex = i;
            double currentHigh = numbers[i];

            for (int k = i - 1; k > 0; k--) {
                if (currentHigh < numbers[k]) {
                    currentIndex = k; // save new high index
                    currentHigh = numbers[k];
                }
            }

            // if currentIndex changed swap
            if (currentIndex != i) {
                double temp = numbers[currentIndex];
                numbers[currentIndex] = numbers[i];
                numbers[i] = temp;
            }
        }
    }

    public static void printArray(double[] array, int numberPerLine) {

            for (int i = 0; i < array.length; i++) {

                System.out.printf("%5.2f ", array[i]);
                if ((i + 1) % numberPerLine == 0) System.out.println("");
            }
    }
}
