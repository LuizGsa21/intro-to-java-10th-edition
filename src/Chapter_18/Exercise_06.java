package Chapter_18;

/**
 * (Sum series) Write a recursive method to compute the following series:
 * i / (i + 1)
 * Write a test program that displays m(i) for i = 1, 2, . . ., 10.
 * Created by Luiz Arantes Sa on 12/2/14.
 */
public class Exercise_06 {

    public static void main(String[] args) {

        for (int i = 1; i < 10; i++) {
            System.out.println(m(i));
        }
    }

    private static double m(int i) {
        if (i == 1)
            return 1 / 2.0;
        else
            return m(i - 1) + i / (i + 1.0);
    }
}
