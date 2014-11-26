package Chapter_07;

import java.util.Scanner;

/**
 * Chapter 7 Exercise 15:
 *
 *      (Eliminate duplicates) Write a method that returns a new array by
 *      eliminating the duplicate values in the array using the following method header:
 *
 *          - public static int[] eliminateDuplicates(int[] list)
 *
 *      Write a test program that reads in ten integers, invokes the method, and displays
 *      the result.
 *
 * Created by Luiz Arantes Sa on 8/27/14.
 */
public class Exercise_15 {

    static final int SIZE = 10;

    public static void main(String[] args) {


        int[] numbers = new int[SIZE];
        Scanner input = new Scanner(System.in);

        System.out.print("Enter " + SIZE + " numbers: ");
        for (int i = 0; i < numbers.length; i++) numbers[i] = input.nextInt();

        printArray(eliminateDuplicates(numbers), 10);

    }

    public static int[] eliminateDuplicates(int[] list) {

        int[] temp = new int[list.length];
        int tempIndex = 0;
        for (int i = 0; i < list.length; i++) {

            boolean isDuplicate = false;
            for (int k = 0; k < list.length; k++) {
                if (temp[k] == list[i]) {
                    isDuplicate = true;

                }
            }
            if (!isDuplicate) {
                temp[tempIndex++] = list[i];
            }

        }
        int[] trimmedArray = new int[tempIndex];
        for (int i = 0; i < tempIndex; i++) {
            trimmedArray[i] = temp[i];
        }

        return trimmedArray;
    }

    public static void printArray(int[] array, int numberPerLine) {

                for (int i = 0; i < array.length; i++) {

                    System.out.printf("%2d ", array[i]);
                    if ((i + 1) % numberPerLine == 0) System.out.println("");
                }
    }
}
