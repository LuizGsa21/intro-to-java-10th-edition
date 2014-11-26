package Chapter_08;

import java.util.Scanner;

/**
 * Chapter 8 Exercise 25:
 *
 *      (Markov matrix)
 *      An n * n matrix is called a positive Markov matrix if each element is positive
 *      and the sum of the elements in each column is 1. Write the following method to
 *      check whether a matrix is a Markov matrix.
 *
 *      public static boolean isMarkovMatrix(double[][] m)
 *
 *      Write a test program that prompts the user to enter a 3 * 3 matrix of double
 *      values and tests whether it is a Markov matrix.
 *
 * Created by Luiz Arantes Sa on 8/31/14.
 */
public class Exercise_25 {

    public static void main(String[] args) {

        double[][] m = new double[3][3];

        Scanner
                input = new Scanner(System.in);
        System.out.println("Enter a 3-by-3 matrix row by row: ");
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[i].length; j++)
                m[i][j] = input.nextDouble();


        System.out.println(isMarkovMatrix(m) ? "The grid is a Markov matrix." : "The grid is NOT a Markov matrix.");
    }

    public static boolean isMarkovMatrix(double[][] m) {

        for (int j = 0; j < m[0].length; j++) {
            double sum = 0;

            for (int i = 0; i < m.length; i++) {

                double num = m[i][j];
                if (num < 0) return false;
                sum += num;
            }
            if (sum != 1) return false;
        }

        return true;
    }


}










