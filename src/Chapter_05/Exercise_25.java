package Chapter_05;

/**
 * Chapter 5 Exercise 25:
 *
 *      (Compute π)
 *      Write a program that displays the p
 *      value for i = 10000, 20000, ..., and 100000.
 *
 * Created by Luiz Arantes Sa on 8/24/14.
 */
public class Exercise_25 {

    public static void main(String[] strings) {

        double pi = 1.0; // start point
        for (int i = 2; i <= 100000; i++) {

            pi += Math.pow(-1 , i + 1) / (2 * i - 1.0D);
            if (i % 10000 == 0) {
                System.out.println("i: " + i + " The pi is " + 4.0 * pi);
            }
        }

    }
}
