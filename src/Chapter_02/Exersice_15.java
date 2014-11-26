package Chapter_02;

import java.util.Scanner;

/**
 * Chapter 2 Exercise 15:
 *
 *      (Geometry: distance of two points)
 *
 * Created by Luiz Arantes Sa on 6/20/14.
 */
public class Exersice_15 {

    public static void main(String[] String) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter x1 and y1: ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();

        System.out.print("Enter x2 and y2: ");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();

        double a = (Math.pow((x2 - x1), 2)) + (Math.pow((y2 - y1), 2));
        double distance = Math.pow(a, 0.5);

        System.out.println("The distance between the two points is " + distance);

    }
}
