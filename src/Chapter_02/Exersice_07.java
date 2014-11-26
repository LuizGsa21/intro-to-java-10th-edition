package Chapter_02;

import java.util.Scanner;

/**
 * Chapter 2 Exercise 7:
 *
 *      (Find the number of years) Write a program that prompts the user to enter
 *      the minutes (e.g., 1 billion), and displays the number of years and days for the minutes.
 *      For simplicity, assume a year has 365 days.
 *
 * Created by Luiz Arantes Sa on 6/19/14.
 */
public class Exersice_07 {

    public static void main(String[] Strings) {


        double minutesInYear = 60 * 24 * 365;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of minutes: ");

        double minutes = input.nextDouble();

        long years = (long) (minutes / minutesInYear);
        int days = (int) (minutes / 60 / 24) % 365;

        System.out.println((int) minutes + " minutes is approximately " + years + " years and " + days + " days");
    }
}
