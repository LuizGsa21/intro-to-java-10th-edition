package Chapter_07;

import java.util.Scanner;

/**
 * Chapter 7 Exercise 30:
 *
 *      (Pattern recognition: consecutive four equal numbers)
 *      Write the following method that tests whether the array has four
 *      consecutive numbers with the same value.
 *
 *       public static boolean isConsecutiveFour(int[] values)
 *
 *       Write a test program that prompts the user to enter a series of integers
 *       and displays if the series contains four consecutive numbers with the same value.
 *       Your program should first prompt the user to enter the input size i.e.,
 *       the number of values in the series.
 *
 * Created by Luiz Arantes Sa on 8/28/14.
 */
public class Exercise_30 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of values: ");
        int size = input.nextInt();
        int[] values = new int[size];
        System.out.print("Enter the values: ");
        for (int i = 0; i < size; i++) values[i] = input.nextInt();

        if (isConsecutiveFour(values)) {
            System.out.println("The list has consecutive fours");
        } else {
            System.out.println("The list has no consecutive fours");
        }


    }

    public static boolean isConsecutiveFour(int[] values) {

        int sequence = 0;
        int last = values[0];
        for (int i = 1; i < values.length; i++) {

            if (values[i] == last) {
                sequence++;
            } else {
                sequence = 1;
                last = values[i];
            }
            if (sequence == 4) return true;

        }

        return false;
    }
}
