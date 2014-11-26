package Chapter_08;

import java.util.Scanner;

/**
 * Chapter 8 Exercise 27:
 *
 *      (Column sorting)
 *      Implement the following method to sort the columns in a two-dimensional array.
 *      A new array is returned and the original array is intact.
 *
 *      public static double[][] sortColumns(double[][] m)
 *
 *      Write a test program that prompts the user to enter a 3 * 3 matrix
 *      of double values and displays a new column-sorted matrix.
 *
 * Created by Luiz Arantes Sa on 8/31/14.
 */
public class Exercise_27 {

    public static void main(String[] args) {

        double[][] m = new double[3][3];

        Scanner
                input = new Scanner(System.in);
        System.out.println("Enter a 3-by-3 matrix row by row: ");
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[i].length; j++)
                m[i][j] = input.nextDouble();


        double[][] sorted = sortColumns(m);
        displayMatrix(sorted);


    }

    public static double[][] sortColumns(double[][] m) {

        // create copy array
        double[][] sorted = new double[m.length][m[0].length];

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                sorted[i][j] = m[i][j];
            }
        }

        for (int j = 0; j < sorted[0].length; j++) {

            for (int i = 0; i < sorted.length - 1; i++) {

                double currentMin = sorted[i][j];
                int minIndex = i;

                for (int row = i + 1; row < sorted.length; row++) {

                    if (currentMin > sorted[row][j]) {
                        currentMin = sorted[row][j];
                        minIndex = row;
                    }
                }
                if (minIndex != i) {
                    sorted[minIndex][j] = sorted[i][j];
                    sorted[i][j] = currentMin;
                }

            }
        }
        return sorted;
    }

    public static void displayMatrix(double[][] m) {

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.printf("%2.3f ", m[i][j]);
            }
            System.out.println("");
        }
    }
}
