package Chapter_07;

import java.util.Scanner;

/**
 * Chapter 7 Exercise 3:
 *
 *      (Count occurrence of numbers)
 *      Write a program that reads the integers between 1 and 100 and counts
 *      the occurrences of each. Assume the input ends with 0.
 *
 *
 * Created by Luiz Arantes Sa on 8/26/14.
 */
public class Exercise_03 {

    static int SIZE = 100;
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the integers between 1 and 100: ");
        int[][] n = new int[2][SIZE];
        for (int i = 0; i < SIZE; i++) {

            int num = input.nextInt();
            if (num >= 100 || num <= 0) break; // break out of loop

            n[0][i] = num;
            n[1][num] = n[1][num] + 1;
        }

        for (int i = 0; i < n[1].length; i++) {

            if (n[1][i] == 0) continue; // on to the next iteration

            if (n[1][i] > 1) System.out.println(i + " occurs " + n[1][i] + " times.");

            else System.out.println(i + " occurs " + n[1][i] + " time");
        }
    }


}
