package Chapter_03;

import java.util.Scanner;

/**
 * Chapter 3 Exercise 22:
 *
 *      (Geometry: point in a circle?)
 *
 * Created by Luiz Arantes Sa on 6/22/14.
 */
public class Exercise_22 {

    public static void main(String[] strings) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter X and Y coordinate: ");
        double x = input.nextDouble();
        double y = input.nextDouble();

        if (Math.pow(x * x + y * y, 0.5D) <= 10.0) {
            System.out.println("Point (" + x + ", " + y + ") is in the circle");
        } else {
            System.out.println("Point (" + x + ", " + y + ") is not in the circle");
        }

    }
}
