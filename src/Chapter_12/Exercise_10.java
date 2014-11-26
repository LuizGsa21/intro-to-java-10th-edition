package Chapter_12;

/**
 * Chapter 12 Exercise 10:
 *
 *      (OutOfMemoryError)
 *      Write a program that causes the JVM to throw an OutOfMemoryError and
 *      catches and handles this error.
 *
 * Created by Luiz Arantes Sa on 9/9/14.
 */
public class Exercise_10 {

    public static void main(String[] args) {

        try {
            int[] temp = new int[1000000000];
            temp = new int[temp.length * 1000000000];
        } catch (OutOfMemoryError ex) {
            ex.printStackTrace();
        }

    }
}
