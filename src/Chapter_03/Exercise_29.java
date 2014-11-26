package Chapter_03;

import java.util.Scanner;

/**
 * Chapter 3 Exercise 29:
 *
 *      (Geometry: two circles)
 *
 * Created by Luiz Arantes Sa on 6/22/14.
 */
public class Exercise_29 {

    public static void main(String[] strings) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter circle1’s center x and y-coordinates, and radius: ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double radius1 = input.nextDouble();

        System.out.print("Enter circle2’s center x and y-coordinates, and radius: ");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double radius2 = input.nextDouble();

        double distance = Math.pow((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2), 0.5D);

        if (distance + radius2 <= radius1) {
            System.out.println("circle2 is inside circle1");
        } else if (distance <= radius1 + radius2) {
            System.out.println("circle2 overlaps circle1");
        } else {
            System.out.println("circle2 does not overlap circle1");
        }
    }
}
