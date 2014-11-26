package Chapter_06;

/**
 * Chapter 6 Exercise 13:
 *
 *      (Sum series)
 *
 * Created by Luiz Arantes Sa on 8/25/14.
 */
public class Exercise_13 {

    public static void main(String[] args) {

        System.out.printf("%-10s%8s\n", "i", "m(i)");
        for (int i = 1; i <= 20; i++) {

            System.out.printf("%-10d%10.4f\n", i, sumSeries(i));
        }
    }

    public static double sumSeries(int n) {

        double sum = 0;

        for (double i = 1; i <= n; i++) {
            sum += i / (i + 1);
        }
        return sum;
    }
}
