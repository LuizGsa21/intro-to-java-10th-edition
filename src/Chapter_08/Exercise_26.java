package Chapter_08;

import java.util.Scanner;

/**
 * Chapter 8 Exercise 26:
 *
 *      (Row sorting)
 *      Implement the following method to sort the rows in a two-dimensional array.
 *      A new array is returned and the original array is intact.
 *
 *      public static double[][] sortRows(double[][] m)
 *
 *      Write a test program that prompts the user to enter a 3 * 3 matrix of double
 *      values and displays a new row-sorted matrix.
 *
 * Created by Luiz Arantes Sa on 8/31/14.
 */
public class Exercise_26 {

    public static void main(String[] args) {

        double[][] m = new double[3][3];

        Scanner
                input = new Scanner(System.in);
        System.out.println("Enter a 3-by-3 matrix row by row: ");
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[i].length; j++)
                m[i][j] = input.nextDouble();


        double[][] sorted = sortRows(m);
        displayMatrix(sorted);


    }

    public static void displayMatrix(double[][] m) {

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.printf("%2.3f ", m[i][j]);
            }
            System.out.println("");
        }
    }
    public static double[][] sortRows(double[][] m) {

        double[][] sortedRows = new double[m.length][m[0].length];

        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[0].length; j++)
                sortedRows[i][j] = m[i][j];

        // sort only rows
        for (int i = 0; i < sortedRows.length; i++) {

            for (int j = 0; j < sortedRows[0].length - 1; j++) {

                double currentMin = sortedRows[i][j];
                int minIndex = j;
                for (int column = j + 1; column < sortedRows[0].length; column++) {

                    if (currentMin > sortedRows[i][column]) {
                        currentMin = sortedRows[i][column];
                        minIndex = column;
                    }
                }

                if (minIndex != j) {
                    sortedRows[i][minIndex] = sortedRows[i][j];
                    sortedRows[i][j] = currentMin;
                }
            }
        }

        return sortedRows;
    }

}
