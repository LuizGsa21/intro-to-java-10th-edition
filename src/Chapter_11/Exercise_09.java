package Chapter_11;

import ToolKit.Kit;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Chapter 11 Exercise 9:
 *
 *      (Largest rows and columns) Write a program that randomly fills in 0s and 1s
 *      into an n-by-n matrix, prints the matrix, and finds the rows and columns with the
 *      most 1s. (Hint: Use two ArrayLists to store the row and column indices with
 *      the most 1s.) Here is a sample run of the program:
 *      Enter the array size n: 4
 *      The random array is
 *      0011
 *      0011
 *      1101
 *      1010
 *      The largest row index: 2
 *      The largest column index: 2, 3
 * Created by Luiz Arantes Sa on 9/8/14.
 */
public class Exercise_09 {

    public static void main(String[] args) {

        System.out.print("Enter the array size n: ");
        int n = new Scanner(System.in).nextInt();
        int[][] m = new int[n][n];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = (int) (Math.random() * 2);
            }
        }


        ArrayList<Integer> row = new ArrayList<>();
        ArrayList<Integer> column = new ArrayList<>();
        getHighestRow(m, row);
        getHighestColumn(m, column);

        Kit.displayGrid(m);
        System.out.println("Highest row: " + row);
        System.out.println("Highest column: " + column);

    }

    public static void getHighestRow(int[][] m, ArrayList<Integer> row) {

        int highest = 0;
        for (int i = 0; i < m.length; i++) {
            int occurrence = 0;
            for (int j = 0; j < m[i].length; j++) {

                if (m[i][j] == 1) {
                    occurrence++;
                }
            }
            if (highest < occurrence) {
                highest = occurrence;
                row.clear();
                row.add(i);
            } else if (highest == occurrence) {
                row.add(i);
            }
        }

    }
    public static void getHighestColumn(int[][] m, ArrayList<Integer> column) {

        int highest = 0;
        for (int j = 0; j < m[0].length; j++) {
            int occurrence = 0;
            for (int i = 0; i < m.length; i++) {

                if (m[i][j] == 1) {
                    occurrence++;
                }
            }
            if (highest < occurrence) {
                highest = occurrence;
                column.clear();
                column.add(j);
            } else if (highest == occurrence) {
                column.add(j);
            }
        }
    }
}
