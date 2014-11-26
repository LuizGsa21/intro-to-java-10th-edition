package Chapter_08;

/**
 * Chapter 8 Exercise 16:
 *
 *      (Sort two-dimensional array) Write a method to sort a two-dimensional array using the following header:
 *
 *      public static void sort(int m[][])
 *
 *      The method performs a primary sort on rows and a secondary sort on columns.
 *      For example, the following array
 *
 *      {{4, 2},{1, 7},{4, 5},{1, 2},{1, 1},{4, 1}}
 *      to
 *      {{1, 1},{1, 2},{1, 7},{4, 1},{4, 2},{4, 5}}
 *
 * Created by Luiz Arantes Sa on 8/30/14.
 */
public class Exercise_16 {

    public static void main(String[] args) {

        int[][] matrix = new int[][] {
                {4, 2},{1, 7},{4, 5},{1, 2},{1, 1},{4, 1}
        };
        sort(matrix);
        displayMatrix(matrix);

    }

    public static void sort(int m[][]) {

        for (int i = 0; i < m.length - 1; i++) {
            int currentIndex = i;
            int[] current = m[i];
            for (int j = i +  1; j < m.length; j++) {
                if (current[0] > m[j][0] || current[0] == m[j][0] && current[1] > m[j][1]) {
                    current = m[j];
                    currentIndex = j;
                }
            }
            if (currentIndex != i) {
                m[currentIndex] = m[i];
                m[i] = current;
            }
        }

    }

    public static void displayMatrix(int[][] m) {

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
