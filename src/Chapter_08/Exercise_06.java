package Chapter_08;

import java.util.Scanner;

/**
 * Chapter 8 Exercise 6:
 *
 *      (Algebra: multiply two matrices)
 *      Write a method to multiply two matrices. The header of the method is:
 *
 *      public static double[][] multiplyMatrix(double[][] a, double[][] b)
 *
 *      To multiply matrix a by matrix b, the number of columns in a must be
 *      the same as the number of rows in b, and the two matrices must have elements
 *      of the same or compatible types. Let c be the result of the multiplication.
 *      Assume the column size of matrix a is n.
 *      Each element cij is ai1 * b1j + ai2 * b2j + c + ain * bnj.
 *      For example, for two 3 * 3 matrices a and b, c.
 *      where cij =ai1 *b1j +ai2 *b2j +ai3 *b3j.
 *
 *      Write a test program that prompts the user to enter two 3 * 3 matrices and displays their product.
 *
 * Created by Luiz Arantes Sa on 8/29/14.
 */
public class Exercise_06 {

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

        double[][] multipliedMatrix = multiplyMatrix(matrix1, matrix2);

        for (int i = 0; i < matrix1.length; i++) {

            for (int k = 0; k < matrix1[i].length; k++) {
                System.out.printf("%2.1f ", matrix1[i][k]);
                if (i == 1 && k == 2) System.out.printf("%2s ", " * ");
                else System.out.printf("%3s ", " ");
            }
            for (int k = 0; k < matrix2[i].length; k++) {
                System.out.printf("%2.1f ", matrix2[i][k]);
                if (i == 1 && k == 2) System.out.printf("%2s ", " = ");
                else System.out.printf("%3s ", " ");

            }
            for (int k = 0; k < multipliedMatrix[i].length; k++) {
                System.out.printf("%2.1f ", multipliedMatrix[i][k]);
                System.out.printf("%3s ", " ");

            }
            System.out.println("");

        }
    }

    public static double[][] multiplyMatrix(double[][] a, double[][] b) {

        double[][] multipliedMatrix = new double[a.length][a[0].length];

        for (int i = 0; i < multipliedMatrix.length; i++) {
            for (int j = 0; j < multipliedMatrix.length; j++) {
                for (int k = 0; k < multipliedMatrix[0].length; k++) {
                    multipliedMatrix[i][j] += a[i][k] * b[k][j];
                    System.out.println(a[i][k] + "-- " + b[k][j] + " --" + multipliedMatrix[i][j]);
                }
                System.out.println("break");
            }
        }

        return multipliedMatrix;
    }
}
