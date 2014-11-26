package Chapter_05;

/**
 * Chapter 5 Exercise 27:
 *
 *      (Display leap years) Write a program that displays all the leap years,
 *      ten per line, from 101 to 2100, separated by exactly one space. Also
 *      display the number of leap years in this period.
 *
 * Created by Luiz Arantes Sa on 8/24/14.
 */
public class Exercise_27 {

    public static void main(String[] strings) {

        int counter = 1;
        for (int year = 2001; year <= 2100; year++) {

            if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
                System.out.print(year + " ");
                if (counter % 10 == 0) {
                    System.out.println();
                }
                counter++;
            }

        }
    }
}
