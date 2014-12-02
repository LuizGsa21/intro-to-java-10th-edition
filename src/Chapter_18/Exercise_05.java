package Chapter_18;

/**
 * (Sum series) Write a recursive method to compute the following series:
 * i / (2i + 1)
 * Write a test program that displays m(i) for i = 1, 2, . . ., 10.
 * <p>
 * Created by Luiz Arantes Sa on 12/2/14.
 */
public class Exercise_05 {

    public static void main(String[] args) {

        for (int i = 1; i < 10; i++) {
            System.out.println(sumSeries(i));
        }
    }

    public static double sumSeries(int n) {

        if (n == 1)
            return 1.0 / 3;
        else
            return sumSeries(n - 1) + n / (2.0 * n + 1);
    }

}
