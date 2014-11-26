package Chapter_05;

/**
 * Chapter 5 Exercise 24:
 *
 *      (Sum a series)
 *
 * Created by Luiz Arantes Sa on 8/24/14.
 */
public class Exercise_24 {

    public static void main(String[] strings) {

        double total = 0.0;
        for (int i = 1; i <= 97; i += 2) {
            total += (double) i / (i + 2);
        }
        System.out.println("Total is: " + total);
    }
}
