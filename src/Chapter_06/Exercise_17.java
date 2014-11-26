package Chapter_06;

/**
 * Chapter 6 Exercise 17:
 *
 *      (Display matrix of 0s and 1s) Write a method that displays
 *      an n-by-n matrix using the following header:
 *
 *            public static void printMatrix(int n)
 *
 *      Each element is 0 or 1, which is generated randomly. Write a test program that
 *      prompts the user to enter n and displays an n-by-n matrix.
 *
 * Created by Luiz Arantes Sa on 8/25/14.
 */
public class Exercise_17 {

    public static void main(String[] args) {

        printMatrix(3);
    }

    public static void printMatrix(int n) {

        for (int column = 0; column < n; column++) {

            for (int row = 0; row < n; row++) {
                System.out.printf("%1d ", (int)(Math.random() * 2));
            }
            System.out.println("");
        }
    }
}
