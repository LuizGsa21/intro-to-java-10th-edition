package Chapter_08;

/**
 * Chapter 8 Exercise 10:
 *
 *      (Largest row and column)
 *      Write a program that randomly fills in 0s and 1s into a 4-by-4 matrix,
 *      prints the matrix, and finds the first row and column with the most 1s.
 *      Here is a sample run of the program:
 *
 *          0011
 *          0011
 *          1101
 *          1010
 *
 *          The largest row index: 2
 *          The largest column index: 2
 *
 * Created by Luiz Arantes Sa on 8/30/14.
 */
public class Exercise_10 {

    public static void main(String[] args) {

        // create 4 by 4 matrix
        int[][] matrix = new int[4][4];

        // generate 1's and 0's for each each rows and columns
        // and track largest row index with the most ones
        int largestRI = 0;
        int largest = -1;
        for (int i = 0; i < matrix.length; i++) {
            int rowCount = 0;
            for (int k = 0; k < matrix[i].length; k++) {
                matrix[i][k] = (int)(Math.random() * 2);
                rowCount += matrix[i][k];
            }
            if (rowCount > largest) {
                largestRI = i;
                largest = rowCount;
            }
        }

        // find largest column index
        int largestCI = 0;
        largest = -1;
        for (int k = 0; k < matrix[0].length; k++) {
            int columnCount = 0;
            for (int i = 0; i < matrix.length; i++) {
                columnCount += matrix[i][k];
            }
            if (columnCount > largest) {
                largest = columnCount;
                largestCI = k;
            }

        }

        // display matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int k = 0; k < matrix[i].length; k++) {
                System.out.printf("%d", matrix[i][k]);
            }
            System.out.printf("\n");
        }
        System.out.println("The largest row index: " + largestRI);
        System.out.println("The larges column index: " + largestCI);
    }


}
