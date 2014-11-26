package Chapter_01;

/**
 * Chapter 1 Exercise 10:
 *
 *      (Average speed in miles) Assume a runner runs 14 kilometers in 45 minutes and 30 seconds.
 *       Write a program that displays the average speed in miles per hour.
 *      (Note that 1 mile is 1.6 kilometers.)
 *
 * Created by Luiz Arantes Sa on 8/23/14.
 */
public class Exercise_10 {

    public static void main(String[] strings) {

        double kilometers = 14.0;
        double miles = kilometers / 1.6;

        double rate = (45.5 * 60.0 + 30.0) / (60.0 * 60.0);
        double milesPerHour = miles / rate;

        System.out.println(milesPerHour);


    }

}
