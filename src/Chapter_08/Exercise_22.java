package Chapter_08;

/**
 * Chapter 8 Exercise 22:
 *
 *      (Even number of 1s)
 *      Write a program that generates a 6-by-6 two-dimensional matrix
 *      filled with 0s and 1s, displays the matrix, and checks if every
 *      row and every column have an even number of 1s.
 *
 * Created by Luiz Arantes Sa on 8/31/14.
 */
public class Exercise_22 {

    public static void main(String[] args) {

        int[][] m = generateMatrix(6, 6);

        displayMatrix(m);
        boolean rowHasEvenOnes = false;
        for (int i = 0; i < m.length; i++) {
            if (rowHasEvenOnes(m, i)) {
                rowHasEvenOnes = true;
                System.out.println("Row #" + i + " has even sequence of ones");
            }
        }
        if (!rowHasEvenOnes) {
            System.out.println("No rows have an even sequence of ones");
        }
        boolean columnHasEvenOnes = false;
        for (int j = 0; j < m[0].length; j++) {
            if (columnHasEvenOnes(m,j)) {
                columnHasEvenOnes = true;
                System.out.println("Column #" + j + " has even sequence of ones");

            }
        }
        if (!columnHasEvenOnes) {
            System.out.println("No Columns have an even sequence of ones");
        }



    }

    public static void displayMatrix(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j]);
            }
            System.out.println("");
        }
    }

    public static int[][] generateMatrix(int row, int columns) {

        int[][] m = new int[row][columns];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = (int) (Math.random() * 2);
            }
        }

        return m;
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
