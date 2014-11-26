package Chapter_01;

/**
 * Chapter 1 Exercise 7:
 *      (Approximate) pi can be computed using the following formula:
 *      4.0 * (1 - (1.0/3) + (1.0/5) - (1.0/7) + (1.0/9) - (1.0/11))
 *
 * Created by Luiz Arantes Sa on 8/23/14.
 */
public class Exercise_07 {

    public static void main(String[] args) {

        double pi = 4.0 * (1 - (1.0/3) + (1.0/5) - (1.0/7) + (1.0/9) - (1.0/11));
        System.out.println(pi); //
    }
}
