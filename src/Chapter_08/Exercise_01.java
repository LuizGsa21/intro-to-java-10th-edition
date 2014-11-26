package Chapter_08;

import ToolKit.Kit;

import java.util.Scanner;

/**
 * Chapter 8 Exercise 1:
 *
 *      (Sum elements column by column)
 *      Write a method that returns the sum of all the elements in a
 *      specified column in a matrix using the following header:
 *
 *      public static double sumColumn(double[][] m, int columnIndex)
 *
 *
 *
 * Created by Luiz Arantes Sa on 8/29/14.
 */
public class Exercise_01 {

    public static void main(String[] args) {

        System.out.print("Enter a 3 X 4 matrix: ");
        Scanner input = new Scanner(System.in);

        // read user input: 3 by 4 matrix
        double[][] matrix = new double[3][4];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                matrix[i][j] = input.nextDouble();

        for (int i = 0; i < matrix[0].length; i++) {
            System.out.println("Sum of the elements at column" + i +" is " + sumColumn(matrix, i));
        }

    }

    public static double sumColumn(double[][] m, int columnIndex) {

        double total = 0;

        for (int i = 0; i < m.length; i++) {
            total += m[i][columnIndex];
        }
        return total;
    }

    public static void displayMatrix(double[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {

            for (int column = 0; column < matrix[row].length; column++) {
                System.out.printf("%5.0f ", matrix[row][column]);
            }
            System.out.printf("\n");
        }
    }

}
