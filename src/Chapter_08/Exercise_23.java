package Chapter_08;

import java.util.Scanner;

/**
 * Chapter 8 Exercise 23:
 *
 *      (Game: find the flipped cell)
 *      Suppose you are given a 6-by-6 matrix filled with 0s and 1s. All rows and all
 *      columns have an even number of 1s. Let the user flip one cell (i.e., flip from
 *      1 to 0 or from 0 to 1) and write a program to find which cell was flipped.
 *      Your program should prompt the user to enter a 6-by-6 array with 0s and 1s and
 *      find the first row r and first column c where the even number of the 1s property
 *      is violated (i.e., the number of 1s is not even). The flipped cell is at (r, c).
 *
 * Created by Luiz Arantes Sa on 8/31/14.
 */
public class Exercise_23 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter a 6-by-6 matrix row by row: ");
        int[][] m = new int[6][6];
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[i].length; j++)
                m[i][j] = input.nextInt();

        int invalidRow = -1;
        for (int i = 0; i < m.length; i++) {
            if (!rowHasEvenOnes(m, i)) {
                invalidRow = i;
                break;
            }
        }
        int invalidColumn = -1;
        for (int i = 0; i < m[0].length; i++) {
            if (!columnHasEvenOnes(m, i)) {
                invalidColumn = i;
                break;
            }
        }

        if (invalidColumn != -1 && invalidRow != -1) {
            System.out.println("The flipped cell is at (" +invalidRow +", " + invalidColumn + ")" );
        }



    }



    public static boolean rowHasEvenOnes(int[][] m, int row) {

        int count = 0;
        for (int j = 0; j < m[row].length; j++) {

            if (m[row][j] == 1) count++;
        }

        return (count % 2 == 0 && count != 0);
    }

    public static boolean columnHasEvenOnes(int[][] m, int column) {

        int count = 0;
        for (int i = 0; i < m.length; i++) {

            if (m[i][column] == 1) count++;
        }

        return (count % 2 == 0 && count != 0);
    }



}
