package Chapter_08;

import ToolKit.Kit;

import java.util.Scanner;

/**
 * Chapter 8 Exercise 19:
 *
 *      (Pattern recognition: four consecutive equal numbers)
 *      Write the following method that tests whether a two-dimensional array
 *      has four consecutive numbers of the same value, either horizontally,
 *      vertically, or diagonally.
 *
 *      public static boolean isConsecutiveFour(int[][] values)
 *
 *      Write a test program that prompts the user to enter the number of
 *      rows and columns of a two-dimensional array and then the values in
 *      the array and displays true if the array contains four consecutive numbers
 *      with the same value. Other- wise, display false.
 *
 * Created by Luiz Arantes Sa on 8/30/14.
 */
public class Exercise_19 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rows = input.nextInt();
        System.out.print("Enter number of columns: ");
        int columns = input.nextInt();

        System.out.println("Enter values into the matrix below: ");
        int[][] m = new int[rows][columns];

        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[i].length; j++) m[i][j] = input.nextInt();


        System.out.println(isConsecutiveFour(m));

        Kit.displayGrid(m);

    }

    public static boolean isConsecutiveFour(int[][] values) {

        // checking rows
        for (int i = 0; i < values.length; i++) {
            int current = values[i][0];
            int consecutiveCount = 0; // values[i][0] starts count

            for (int j = 0; j < values[i].length; j++) {

                if (values[i][j] == current) {
                    consecutiveCount++;
                    if (consecutiveCount == 4) return true;
                } else {
                    current = values[i][j];
                    consecutiveCount = 1;
                }
            }
        }
        // check columns
        for (int j = 0; j < values[0].length; j++) {
            int consecutiveCount = 0; // values[0][j] starts count
            int current = values[0][j];

            for (int i = 0; i < values.length; i++) {

                if (values[i][j] == current) {
                    consecutiveCount++;
                    if (consecutiveCount == 4) return true;
                } else {
                    current = values[i][j];
                    consecutiveCount = 1;
                }

            }
        }

        // check topLeft side: going upright
        for (int i = values.length - 1; i > 0; i--) {
            int y = i;
            int x = 0;
            int consecutive = 0;
            int current = values[y][x];

            while (y >= 0) {
                System.out.println("y = " + y + " x = " + x);
                if (values[y][x] == current) {
                    consecutive++;
                    if (consecutive == 4) return true;
                } else {
                    consecutive = 1;
                    current = values[y][x];
                }
                x++;
                y--;
            }
        }

        // check bottom right side: going upright
        for (int j = 0; j < values[0].length; j++) {
            int y = values.length - 1;
            int x = j;
            int consecutive = 0;
            int current = values[y][x];

            while (x < values[0].length && y >= 0) {
                System.out.println("y = " + y + " x = " + x);
                if (values[y][x] == current) {
                    consecutive++;
                    if (consecutive == 4) return true;
                } else {
                    consecutive = 1;
                    current = values[y][x];
                }
                x++;
                y--;
            }

        }

        // check bottom left side going up-left
        for (int j = values[0].length - 1; j > 0; j--) {

            int x = j;
            int y = values.length - 1;
            int current = values[y][x];
            int consecutiveCount = 0;

            while (x >= 0 && y >= 0) {

                if (values[y][x] == current) {
                    consecutiveCount++;
                    if (consecutiveCount == 4) return true;
                } else {
                    consecutiveCount = 1;
                    current = values[y][x];
                }

                x--;
                y--;
            }
        }
        // check bottom right side going up-left
        for (int row = 1 ; row < values.length; row++) {
            int x = values[0].length - 1;
            int y = row;
            int consecutive = 0;
            int current = values[y][x];

            while (y >= 0) {
                System.out.println("y = " + y + " x = " + x);
                if (values[y][x] == current) {
                    consecutive++;
                    if (consecutive == 4) return true;
                } else {
                    consecutive = 1;
                    current = values[y][x];
                }
                x--;
                y--;
            }

        }
        return false;
    }

}










