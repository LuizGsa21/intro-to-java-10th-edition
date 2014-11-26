package Chapter_03;

import java.util.Scanner;

/**
 * Chapter 3 Exercise 28:
 *
 *      (Geometry: two rectangles)
 *
 * Created by Luiz Arantes Sa on 6/22/14.
 */
public class Exercise_28 {

    public static void main(String[] strings) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter r1’s center x and y-coordinates, width, and height: ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double width1 = input.nextDouble();
        double height1 = input.nextDouble();

        System.out.print("Enter r2’s center x and y-coordinates, width, and height: ");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        double width2 = input.nextDouble();
        double height2 = input.nextDouble();

        double xDistance = x1 >= x2 ? x1 - x2 : x2 - x1;
        double yDistance = y1 >= y2 ? y1 - y2 : y2 - y1;

        boolean r2IsInsideR1 = (xDistance <= (width1 - width2) / 2 && yDistance <= (height1 - height2) / 2);
        boolean r2OverlapsR1 = (xDistance <= (width1 + width2) / 2 && yDistance <= (height1 + height2) / 2);

        if (r2IsInsideR1) {
            System.out.println("r2 is inside r1");
        } else if (r2OverlapsR1) {
            System.out.println("r2 overlaps r1");
        } else {
            System.out.println("r2 does not overlap r1");
        }
    }
}
