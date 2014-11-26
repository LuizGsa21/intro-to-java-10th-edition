package Chapter_02;

import java.util.Scanner;

/**
 * Chapter 2 Exercise 8:
 *
 *      (Current time) Listing 2.7, ShowCurrentTime.java, gives a program that
 *      displays the current time in GMT. Revise the program so that it prompts
 *      the user to enter the time zone offset to GMT and displays the time in
 *      the specified time zone.
 *
 * Created by Luiz Arantes Sa on 6/19/14.
 */
public class Exersice_08 {
    public static void main(String[] Strings) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the time zone offset to GMT: ");
        long timeZoneChange = input.nextInt();

        // Obtain the total milliseconds since the midnight, Jan 1, 1970
        long totalMilliseconds = System.currentTimeMillis();

        // Obtain the total seconds since the midnight, Jan 1, 1970
        long totalSeconds = totalMilliseconds / 1000;

        // Compute the current second in the minute in the hour
        long currentSecond = totalSeconds % 60;

        // Obtain the total minutes
        long totalMinutes = totalSeconds / 60;

        // Compute the current minute in the hour
        long currentMinute = totalMinutes % 60;

        // Obtain the total hours
        long totalHours = totalMinutes / 60;

        // Compute the current hour
        long currentHour = ((totalHours + timeZoneChange) % 24);

        // Display results
        System.out.println("Current time is " + currentHour + ":" + currentMinute + ":" + currentSecond);
    }
}
