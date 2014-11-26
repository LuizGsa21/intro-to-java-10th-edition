package Chapter_05;

/**
 * Chapter 5 Exercise 3:
 *
 *      (Conversion from kilograms to pounds) Write a program that displays the following
 *      table (note that 1 kilogram is 2.2 pounds)
 *
 * Created by Luiz Arantes Sa on 8/24/14.
 */
public class Exercise_03 {

    public static void main(String[] args) {

        System.out.printf("%-12s%8s\n", "Kilograms", "Pounds");

        for (int i = 1; i < 200; i++) {
            System.out.printf("%-12d%8.1f\n", i, i * 2.2);
        }
    }
}
