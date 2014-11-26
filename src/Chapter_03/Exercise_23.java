package Chapter_03;

import java.util.Scanner;

/**
 * Chapter 3 Exercise 23:
 *
 *      (Geometry: point in a rectangle?)
 *
 * Created by Luiz Arantes Sa on 6/22/14.
 */
public class Exercise_23 {

    public static void main(String[] strings) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a pont with two coordinates: ");
        double x = input.nextDouble();
        double y = input.nextDouble();

        double xDistance = Math.pow(x * x, 0.5D);
        double yDistance = Math.pow(y * y, 0.5D);

        if ((yDistance <= 2.5) && (xDistance <= 5.0)) {
            System.out.println("Point (" + x + ", " + y + ") is in the rectangle.");
        } else {
            System.out.println("Point (" + x + ", " + y + ") is not in the rectangle.");
        }
    }
}
