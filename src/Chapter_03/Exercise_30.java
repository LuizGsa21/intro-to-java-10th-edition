package Chapter_03;

import java.util.Scanner;

/**
 * Chapter 3 Exercise 31:
 *
 *      (Current time)
 *
 * Created by Luiz Arantes Sa on 6/22/14.
 */
public class Exercise_30 {

    public static void main(String[] strings) {

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
        System.out.print("Current time is " + currentHour % 12 + ":" + currentMinute + ":" + currentSecond);
        if (currentHour < 12) {
            System.out.println(" AM");
        } else {
            System.out.println(" PM");
        }
    }
}
