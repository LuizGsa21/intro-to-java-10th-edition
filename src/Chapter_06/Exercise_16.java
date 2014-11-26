package Chapter_06;

/**
 * Chapter 6 Exercise 16:
 *
 *      (Number of days in a year) Write a method that returns the number of days
 *      in a year using the following header:
 *
 *          public static int numberOfDaysInAYear(int year)
 *
 *  Write a test program that displays the number of days in year from 2000 to 2020
 *
 * Created by Luiz Arantes Sa on 8/25/14.
 */
public class Exercise_16 {

    public static void main(String[] args) {

        for (int i = 2000; i <= 2020; i++) {

            System.out.println("Year: " + i + " = " + numberOfDaysInAYear(i) + "days: is Leap year? " + isLeapYear(i));
        }
    }

    public static int numberOfDaysInAYear(int year) {

        if (isLeapYear(year)) return 365;
        else return 366;
    }
    public static boolean isLeapYear(int year) {

        return  (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;

    }
}
