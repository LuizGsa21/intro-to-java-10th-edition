package Chapter_08;

import java.util.Scanner;

/**
 * Chapter 8 Exercise 2:
 *
 *      (Sum the major diagonal in a matrix)
 *      Write a method that sums all the numbers in the major diagonal in
 *      an n * n matrix of double values using the following header:
 *
 *          public static double sumMajorDiagonal(double[][] m)
 *
 *      Write a test program that reads a 4-by-4 matrix and displays the sum of all its
 *      elements on the major diagonal.
 *
 * Created by Luiz Arantes Sa on 8/29/14.
 */
public class Exercise_02 {

    public static void main(String[] args) {


        double[][] m = get4By4Matrix();

        double majorDiagSum = sumMajorDiagonal(m);

        System.out.println("Sum of the elements in the major diagonal is " + majorDiagSum);


    }

    public static double[][] get4By4Matrix() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a 4-by-4 matrix row by row: ");

        double[][] m = new double[4][4];
        // save user input to the 4 by 4 matrix
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[i].length; j++)
                m[i][j] = input.nextDouble();
        input.close();

        return m;
    }
    // 00 11 22 33 44 55
    public static double sumMajorDiagonal(double[][] m) {

        double total = 0;

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (i == j) {
                    total += m[i][j];
                }
            }
        }


        return total;
    }
}
