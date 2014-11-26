package Chapter_05;

/**
 * Chapter 5 Exercise 5:
 *
 *  (Conversion from kilograms to pounds and pounds to kilograms)
 *  Write a program that displays the two table from the last two exercises
 *
 * Created by Luiz Arantes Sa on 8/24/14.
 */
public class Exercise_05 {

    public static void main(String[] args) {

        System.out.printf("%-12s%8s", "Kilograms", "Pounds");
        System.out.printf("\t\t|\t\t");
        System.out.printf("%-12s%-8s\n", "Pounds", "Kilograms");


        for (int i = 1, j = 20; i < 200; i++, j += 5) {
            System.out.printf("%-12d%8.1f", i, i * 2.2);
            System.out.printf("\t\t|\t\t");
            System.out.printf("%-12d%-8.2f\n", j, j / 2.2);

        }

    }
}
