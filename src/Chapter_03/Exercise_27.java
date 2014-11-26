package Chapter_03;

import java.util.Scanner;

/**
 * Chapter 3 Exercise 27:
 *
 *      (Geometry: points in triangle?)
 *
 * Created by Luiz Arantes Sa on 6/22/14.
 */
public class Exercise_27 {

    public static void main(String[] strings) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a point's x- and y-coordinates: ");
        double x = input.nextDouble();
        double y = input.nextDouble();

        double slope = -0.5D;
        double y1 = y + -x * slope;

        if ((x > 200.0D) || (x < 0.0D) || (y > 100.0D) || (y < 0.0D)) {
            System.out.println("The point is not in the triangle.");
        } else {

            if ((y1 <= 100.0D)) {
                System.out.println("The point is in the triangle");
            } else {
                System.out.println("The point is not in the triangle.");
            }
        }


    }
}
