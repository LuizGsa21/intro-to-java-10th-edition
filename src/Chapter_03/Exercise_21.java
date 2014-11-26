package Chapter_03;

import java.util.Scanner;

/**
 * Chapter 3 Exercise 21:
 *
 *      (Science: day of the week)
 *
 * Created by Luiz Arantes Sa on 6/22/14.
 */
public class Exercise_21 {

    public static final String dayOfWeekisString = "Day of the week is ";

    public static void main(String[] strings) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = input.nextInt();

        System.out.print("Enter a month: 1-12: ");
        int month = input.nextInt();
        if (month == 1) {
            month = 13;
            year--;
        } else if (month == 2) {
            month = 14;
            year--;
        }
        System.out.print("Enter the day of the month: ");
        int dayOfMonth = input.nextInt();

        int k = year % 100;
        int j = year / 100;
        int dayOfWeek = (dayOfMonth + 26 * (month + 1) / 10 + k + k / 4 + j / 4 + 5 * j) % 7;

        String dayNameOfWeek = dayNameOfWeek(dayOfWeek);

        System.out.println(dayOfWeekisString + dayNameOfWeek);

    }

    public static String dayNameOfWeek(int dayOfWeek) {

        switch (dayOfWeek) {
            case 2: return "Monday";
            case 3: return "Tuesday";
            case 4: return "Wednesday";
            case 5: return "Thursday";
            case 6: return "Friday";
            case 7: return "Saturday";
            case 1: return "Sunday";
            default: return null;
        }
    }
}
