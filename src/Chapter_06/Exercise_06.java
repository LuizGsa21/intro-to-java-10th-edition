package Chapter_06;

import java.util.Scanner;

/**
 * Chapter 6 Exercise 6:
 *
 *      (Display patterns)
 *
 * Created by Luiz Arantes Sa on 8/25/14.
 */
public class Exercise_06 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = input.nextInt();
        displayPattern(num);
    }

    public static void displayPattern(int n) {

        // number of rows
        for (int row = 1; row <= n; row++) {

            // empty strings to print == n - row
            for (int formatter = 1; formatter <= n - row; formatter++) {
                System.out.printf("%4s", "");
            }

            // numbers to print == row number
            for (int column = row; column >= 1; column--) {
                System.out.printf("%4d", column);
            }
            System.out.println();

        }
    }
}
