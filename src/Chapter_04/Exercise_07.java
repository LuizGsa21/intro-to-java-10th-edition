package Chapter_04;

import java.util.Scanner;

/**
 * Chapter 4 Exercise 7:
 *
 *      (Corner point coordinates)
 *      Suppose a pentagon is centered at (0, 0) with one point at
 *      the 0 o’clock position. Write a program that prompts the user to
 *      enter the radius of the bounding circle of a pentagon and displays
 *      the coordinates of the five corner points on the pentagon.
 *
 * Created by Luiz Arantes Sa on 8/23/14.
 */
public class Exercise_07 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the radius of the bounding circle: ");
        double radius = input.nextDouble();
        input.close();

        System.out.println("The coordinates of five points on the pentagon are...");
        for (int i = 0; i < 5; i++) {

            double x = radius * Math.sin(2.0 * Math.PI / 5.0 * i);
            double y = radius * Math.cos(2.0 * Math.PI / 5.0 * i);
            System.out.println(x + " " + y);
        }

    }

}
