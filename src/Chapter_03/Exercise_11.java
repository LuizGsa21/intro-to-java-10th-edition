package Chapter_03;

import java.util.Scanner;

/**
 * Chapter 3 Exercise 11:
 *
 *      (Find the number of days in a month)
 * Created by Luiz Arantes Sa on 6/22/14.
 */
public class Exercise_11 {

    public static void main(String[] strings) {

        Scanner input = new Scanner(System.in);

        int numberOfDaysInMonth = 0; // holds number of days in month
        String nameOfMonth = "Unknown"; // holds name of the month

        System.out.print("Enter a month number: ");
        int month = input.nextInt();

        System.out.print("Enter a year: ");
        int year = input.nextInt();

        switch (month) {
            case 1:
                nameOfMonth = "January";
                numberOfDaysInMonth = 31;
                break;
            case 2:
                nameOfMonth = "February";
                if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
                    numberOfDaysInMonth = 29;
                } else {
                    numberOfDaysInMonth = 28;
                }
                break;
            case 3:
                nameOfMonth = "March";
                numberOfDaysInMonth = 31;
                break;
            case 4:
                nameOfMonth = "April";
                numberOfDaysInMonth = 30;
                break;
            case 5:
                nameOfMonth = "May";
                numberOfDaysInMonth = 31;
                break;
            case 6:
                nameOfMonth = "June";
                numberOfDaysInMonth = 30;
                break;
            case 7:
                nameOfMonth = "July";
                numberOfDaysInMonth = 31;
                break;
            case 8:
                nameOfMonth = "August";
                numberOfDaysInMonth = 31;
                break;
            case 9:
                nameOfMonth = "September";
                numberOfDaysInMonth = 30;
                break;
            case 10:
                nameOfMonth = "October";
                numberOfDaysInMonth = 31;
                break;
            case 11:
                nameOfMonth = "November";
                numberOfDaysInMonth = 30;
                break;
            case 12:
                nameOfMonth = "December";
                numberOfDaysInMonth = 31;
        }
        System.out.print(nameOfMonth + " " + year + " has " + numberOfDaysInMonth + " days");
    }
}
