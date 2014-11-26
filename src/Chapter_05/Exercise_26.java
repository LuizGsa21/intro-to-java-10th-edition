package Chapter_05;

/**
 * Chapter 5 Exercise 26:
 *
 *      (Compute e) You can approximate e using the following series:
 *      Write a program that displays the e value for i = 10000, 20000, ...,
 *      and 100000. (Hint: Because i! = i * (i - 1) * c * 2 * 1, then
 *      Initialize e and item to be 1 and keep adding a new item to e.
 *      The new item is the previous item divided by i for i = 2, 3, 4, ....)
 *
 * Created by Luiz Arantes Sa on 8/24/14.
 */
public class Exercise_26 {

    public static void main(String[] strings) {

        double e = 1.0;
        double item = 1.0;
        for (int i = 2; i <= 100000; i++) {
            item /= (double)i;
            e += item;
            if (i % 10000 == 0) {
                System.out.println("i is " + i + " and e is " + e);
            }
        }
    }

}
