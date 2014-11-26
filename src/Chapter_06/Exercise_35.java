package Chapter_06;

import java.util.Scanner;

/**
 * Chapter 6 Exercise 35:
 *
 *      (Geometry: area of a pentagon) The area of a pentagon can be computed using the following formula:
 *       Write a method that returns the area of a pentagon using the following header:
 *
 *          public static double area(double side)
 *
 *       Write a main method that prompts the user to enter the side of a pentagon and
 *       displays its area.
 * Created by Luiz Arantes Sa on 8/26/14.
 */
public class Exercise_35 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the side: ");
        double side = input.nextDouble();

        System.out.println("The area of the pentagon is " + area(side));


    }

    public static double area(double s) {
        return  (5 * s * s) / (4 * Math.tan(Math.PI/5));
    }
}
