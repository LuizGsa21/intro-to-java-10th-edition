package Chapter_06;

/**
 * Chapter 6 Exercise 14:
 *
 *      (Estimate p) p can be computed using the following series provided
 *
 * Created by Luiz Arantes Sa on 8/25/14.
 */
public class Exercise_14 {

    public static void main(String[] args) {


        System.out.printf("%-10s%8s\n", "i", "m(i)");

        for (int i = 1; i <= 901; i += 100) {

            System.out.printf("%-10d%10.4f\n", i, estimate(i));
        }
    }

    public static double estimate(int p) {

        double sum = 0;

        for (double i = 1; i <= p; i++) {

            sum += Math.pow(-1, i + 1) / (2 * i - 1);
        }

        sum *= 4;

        return sum;
    }
}
