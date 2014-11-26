package Chapter_07;

import java.util.Scanner;

/**
 * Chapter 7 Exercise 2:
 *
 *      (Reverse the numbers entered)
 *      Write a program that reads ten integers and displays them
 *      in the reverse of the order in which they were read.
 *
 * Created by Luiz Arantes Sa on 8/26/14.
 */
public class Exercise_02 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter ten integers: ");
        int[] n = new int[10];

        // passing input values to array
        for (int i = 0; i < 10; i++) n[i] = input.nextInt();
        // displaying array in reverse order
        for (int i = n.length - 1; i >= 0; i--) System.out.print(n[i] + " ");
    }
}
