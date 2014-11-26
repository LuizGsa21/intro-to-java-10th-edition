package Chapter_03;

import java.util.Scanner;

/**
 * Chapter 3 Exercise 20:
 *
 *      (Science: wind-chill temperature)
 *
 * Created by Luiz Arantes Sa on 6/22/14.
 */
public class Exercise_20 {

    public static void main(String[] strings) {

        Scanner input = new Scanner(System.in);


        System.out.print("Enter the temperature in Fahrenheit: ");
        double fahrenheit = input.nextDouble();

        while (fahrenheit < -58 || fahrenheit > 41) {
            System.out.print("Please enter a temperature between -58 and 41 degrees: ");
            fahrenheit = input.nextDouble();
        }

        System.out.print("Enter the wind speed miles per hour: ");
        double speed = input.nextDouble();

        while (speed < 2) {
            System.out.print("Please enter a wind speed greater than or equal 2: ");
            speed = input.nextDouble();
        }

        double windCold = 35.74 + 0.6215 * fahrenheit - 35.75 *
                Math.pow(speed, 0.16) + 0.4275 * fahrenheit *
                Math.pow(speed, 0.16);

        System.out.println("The wind chill index is " + windCold);
    }
}
