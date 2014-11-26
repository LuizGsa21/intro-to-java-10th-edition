package Chapter_02;

import java.util.Scanner;

/**
 * Chapter 2 Exercise 19:
 *
 *      (Geometry: area of a triangle)
 *
 * Created by Luiz Arantes Sa on 6/20/14.
 */
public class Exersice_19 {

    public static void main(String[] Strings) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter three points for a triangle: ");

        // triangle points
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double x3 = input.nextDouble();
        double y3 = input.nextDouble();

        // gettings sides of triangle
        double side1 = Math.pow((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2), 0.5);
        double side2 = Math.pow((x1 - x3) * (x1 - x3) + (y1 - y3) * (y1 - y3), 0.5);
        double side3 = Math.pow((x3 - x2) * (x3 - x2) + (y3 - y2) * (y3 - y2), 0.5);

        double s = (side1 + side2 + side3) / 2.0;
        double area = Math.pow(s * (s - side1) * (s - side2) * (s - side3), 0.5);

        System.out.println("The area of the triangle is " + area);
    }
}
