package Chapter_09;

import java.util.Date;

/**
 * Chapter 9 Exercise 3:
 *
 *      (Use the Date class)
 *      Write a program that creates a Date object, sets its elapsed
 *      time to 10000, 100000, 1000000, 10000000, 100000000, 1000000000, 10000000000,
 *      and 100000000000, and displays the date and time using the toString() method,
 *      respectively.
 *
 * Created by Luiz Arantes Sa on 9/1/14.
 */
public class Exercise_03 {

    public static void main(String[] args) {

        long time = 10000;
        for (int i = 0; i < 8; i++, time *= 10) {
            Date date = new Date(time);
            System.out.println(date.toString());
        }
    }
}
