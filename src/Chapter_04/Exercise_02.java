package Chapter_04;

import java.util.Scanner;

/**
 * Chapter 4 Exercise 2:
 *
 *      (Geometry: great circle distance)
 *
 *      Write a program that prompts the user to enter the latitude and longitude
 *      of two points on the earth in degrees and displays its great circle distance.
 *      The average earth radius is 6,371.01 km. Note that you need to convert the degrees
 *      into radians using the Math.toRadians method since the Java trigonometric methods use radians.
 *      The latitude and longitude degrees in the formula are for north and west. Use negative to
 *      indicate south and east degrees.
 *
 * Created by Luiz Arantes Sa on 8/23/14.
 */
public class Exercise_02 {

    private static final double AVERAGE_EARTH_RADIUS = 6371.01;

    public static void main(String[] args) {

        // Getting (x1,y1) (x2,y2) from user
        Scanner input = new Scanner(System.in);
        System.out.print("Enter point 1 (latitude and longitude) in degrees: ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();

        System.out.print("Enter point 2 (latitude and longitude) in degrees: ");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        input.close();

        // Solving for the distance between the two points
        // Formula: d = radius * arccos(sin(x1) * sin(x2) + cos(x1) * cos(x2) * cos(y1 - y2))

        double radius = AVERAGE_EARTH_RADIUS;

        double distance = radius *
                Math.acos( Math.sin(Math.toRadians(x1)) * Math.sin(Math.toRadians(x2)) +
                           Math.cos(Math.toRadians(x1)) * Math.cos(Math.toRadians(x2)) *
                           Math.cos(Math.toRadians(y1 - y2)));


        System.out.printf("The distance between the two points is %f km", distance);
    }
}
