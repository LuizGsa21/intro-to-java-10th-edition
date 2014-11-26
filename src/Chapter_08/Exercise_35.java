package Chapter_08;

import java.util.Scanner;

/**
 * Chapter 8 Exercise 35:
 *
 *      (Largest block)
 *      Given a square matrix with the elements 0 or 1, write a program to
 *      find a maximum square submatrix whose elements are all 1s. Your
 *      program should prompt the user to enter the number of rows in the matrix.
 *      The program then displays the location of the first element in the maximum
 *      square submatrix and the number of the rows in the submatrix.
 *
 *      Your program should implement and use the following method
 *      to find the maxi- mum square submatrix:
 *
 *      public static int[] findLargestBlock(int[][] m)
 *
 *      The return value is an array that consists of three values.
 *      The first two values are the row and column indices for the first
 *      element in the submatrix, and the third value is the
 *      number of the rows in the submatrix
 *
 * Created by Luiz Arantes Sa on 9/1/14.
 */
public class Exercise_35 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of rows in the matrix: ");
        int size = input.nextInt();
        int[][] m = new int[size][size];

        System.out.println("Enter the matrix row by row: ");
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[i].length; j++)
                m[i][j] = input.nextInt();

        int[] location = findLargestBlock(m);

        if (location != null) {
            System.out.printf("The maximum square submatrix is at (%d, %d) with size %d",
                    location[0], location[1], location[2]);
        }

    }

    public static int[] findLargestBlock(int[][] m) {

        int[] highestSquare = null;
        int highestSize = 0;
        for (int i = 0; i < m.length; i++) {

            for (int j = 0; j < m[0].length; j++) {

                int occurrence = getOccurrence(m, i, j);

                if (occurrence < 2) continue; // not a square

                if (scanPossibleSquare(m, i, j, occurrence) && occurrence > highestSize) {

                    highestSize = occurrence;
                    highestSquare = new int[]{i,j,occurrence};
                }
            }
        }
        return highestSquare;
    }

    public static int getOccurrence(int[][] m, int row, int column) {

        int occurrence = 0;

        if (column == m[0].length - 1) return 0;

        for (int j = column; j < m[0].length; j++) {

            if (m[row][j] == 1) {
                occurrence++;
                if (j == m[0].length - 1) return occurrence; // if in the end of grid

            } else if (occurrence > 1) return occurrence;

            else return 0;
        }
        return 0;
    }

    public static boolean scanPossibleSquare(int[][] m, int row, int column, int occurrence) {

        if (row + occurrence > m.length) return false; // out of range

        for (int i = row; i < occurrence + row; i++) {

            for (int j = column; j < occurrence + column; j++) {
                if (m[i][j] == 0) return false;
            }
        }
        return true;
    }
}







