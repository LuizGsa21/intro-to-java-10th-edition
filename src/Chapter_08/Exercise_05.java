package Chapter_08;

import java.util.Scanner;

/**
 * Chapter 8 Exercise 5:
 *
 *      (Algebra: add two matrices)
 *      Write a method to add two matrices. The header of the method is as follows:
 *
 *      public static double[][] addMatrix(double[][] a, double[][] b)
 *
 *      In order to be added, the two matrices must have the same dimensions and the same
 *      or compatible types of elements. Let c be the resulting matrix. Each element cij
 *      is aij + bij. Write a test program that prompts the user to enter two 3 * 3
 *      matrices and displays their sum.
 *
 * Created by Luiz Arantes Sa on 8/29/14.
 */
public class Exercise_05 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter 3x3 matrix 1: ");
        double[][] matrix1 = new double[3][3];
        for (int i = 0; i < matrix1.length; i++)
            for (int k = 0; k < matrix1[i].length; k++)
                matrix1[i][k] = input.nextDouble();


        System.out.print("Enter 3x3 matrix 2: ");
        double[][] matrix2 = new double[3][3];
        for (int i = 0; i < matrix2.length; i++)
            for (int k = 0; k < matrix2[i].length; k++)
                matrix2[i][k] = input.nextDouble();

        double[][] addedMatrix = addMatrix(matrix1, matrix2);

        for (int i = 0; i < matrix1.length; i++) {

            for (int k = 0; k < matrix1[i].length; k++) {
                System.out.printf("%2.1f ", matrix1[i][k]);
                if (i == 1 && k == 2) System.out.printf("%2s ", " + ");
                else System.out.printf("%3s ", " ");
            }
            for (int k = 0; k < matrix2[i].length; k++) {
                System.out.printf("%2.1f ", matrix2[i][k]);
                if (i == 1 && k == 2) System.out.printf("%2s ", " = ");
                else System.out.printf("%3s ", " ");

            }
            for (int k = 0; k < addedMatrix[i].length; k++) {
                System.out.printf("%4.1f ", addedMatrix[i][k]);
            }
            System.out.println("");

        }
    }

    public static double[][] addMatrix(double[][] a, double[][] b) {

        double[][] addedMatrix = new double[a.length][a[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int k = 0; k < a[0].length; k++) {
                addedMatrix[i][k] = a[i][k] + b[i][k];
            }
        }

        return addedMatrix;
    }
}
