package Chapter_08;

/**
 * Chapter 8 Exercise 18:
 *
 *      (Shuffle rows) Write a method that shuffles the rows in a two-dimensional int array using the following header:
 *
 *      public static void shuffle(int[][] m)
 *
 *      Write a test program that shuffles the following matrix:
 *      int[][] m = {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}};
 *
 * Created by Luiz Arantes Sa on 8/30/14.
 */
public class Exercise_18 {

    public static void main(String[] args) {

        int[][] m = {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}};

        System.out.println("Before shuffle");
        displayMatrix(m);
        System.out.println("After shuffle");
        shuffle(m);
        displayMatrix(m);


    }

    public static void displayMatrix(int[][] m) {

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static void shuffle(int[][] m) {

        int r1; // random row index
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                do {
                    r1 = (int)(Math.random() * m.length);
                } while (r1 == i);
                int[] temp = m[i];
                m[i] = m[r1];
                m[r1] = temp;
            }
        }

    }

}
