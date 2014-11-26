package Chapter_09;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Chapter 9 Exercise 5:
 *
 *      (Use the GregorianCalendar class)
 *       Java API has the GregorianCalendar class in the java.util package,
 *       which you can use to obtain the year, month, and day of a date.
 *       The no-arg constructor constructs an instance for the current date, and the methods
 *
 *          -get(GregorianCalendar.YEAR),
 *          -get(GregorianCalendar.MONTH),
 *          -get(GregorianCalendar.DAY_OF_MONTH)
 *       return the year, month, and day
 *
 *       Write a program to perform two tasks:
 *          ■ Display the current year, month, and day.
 *          ■ The GregorianCalendar class has the setTimeInMillis(long),
 *       which can be used to set a specified elapsed time since January 1, 1970.
 *       Set the value to 1234567898765L and display the year, month, and day.
 *
 * Created by Luiz Arantes Sa on 9/1/14.
 */
public class Exercise_05 {

    public static void main(String[] args) {

        // current date
        System.out.println(new Date().toString());

        // display year month day using 1234567898765L from gregorian class
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTimeInMillis(1234567898765L);

        // display the year, month, and day
        System.out.printf("Year: %d Month: %d Day: %d",
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DATE));
    }
}












