package Chapter_02;

import java.util.Scanner;

/**
 * Chapter 2 Exercise 1:
 *      (Convert Celsius to Fahrenheit) Write a program that reads a Celsius degree
 *      in a double value from the console, then converts it to Fahrenheit and displays the result.
 *
 *          fahrenheit = (9 / 5) * celsius + 32
 *
 * Created by Luiz Arantes Sa on 8/23/14.
 */
public class Exercise_01 {

    public static void main(String[] Strings) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a degree in Celsius: ");
        double celsius = input.nextDouble();

        double fahrenheit = (9.0 / 5.0) * celsius + 32.0;
        System.out.println(celsius + " degree Celsius is equal to " + fahrenheit + " in Fahrenheit");
    }
}
