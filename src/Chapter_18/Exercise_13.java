package Chapter_18;

import java.util.Scanner;

/**
 * (Find the largest number in an array)
 * Write a recursive method that returns the largest integer in an array.
 * Write a test program that prompts the user to enter a list of eight
 * integers and displays the largest element.
 * Created by Luiz Arantes Sa on 12/2/14.
 */
public class Exercise_13 {

    public static void main(String[] args) {

        int[] array = new int[8];
        Scanner input = new Scanner(System.in);
        System.out.print("Enter 8 integers: ");

        for (int i = 0; i < array.length; i++)
            array[i] = input.nextInt();

        System.out.println("The largest number is " + getLargest(array));

    }

    private static int getLargest(int[] array) {

        return getLargest(array, 0, array[0]);
    }

    private static int getLargest(int[] array, int i, int high) {

        if (i == array.length)
            return high;

        if (high < array[i])
            high = array[i];

        return getLargest(array, i + 1, high);
    }


}
