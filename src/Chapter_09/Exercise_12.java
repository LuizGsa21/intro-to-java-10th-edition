package Chapter_09;

import ToolKit.LinearEquation;

import java.util.Scanner;

/**
 * Chapter 9 Exercise 12:
 *
 *      (Geometry: intersecting point)
 *      Suppose two line segments intersect. The two end-points for the first line segment
 *      are (x1, y1) and (x2, y2) and for the second line segment are (x3, y3) and (x4, y4).
 *      Write a program that prompts the user to enter these four endpoints and displays the
 *      intersecting point. As discussed in Program- ming Exercise 3.25, the intersecting point can
 *      be found by solving a linear equation. Use the LinearEquation class in Programming Exercise 9.11
 *      to solve this equation. See Programming Exercise 3.25 for sample runs.
 *
 * Created by Luiz Arantes Sa on 9/2/14.
 */
public class Exercise_12 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter x1, y1, x2, y2, x3, y3, x4, y4: ");
        double[][] points = new double[4][2];
        for (int i = 0; i < points.length; i++)
            for (int j = 0; j < points[i].length; j++)
                points[i][j] = input.nextDouble();

        LinearEquation linear = LinearEquation.getIntersectingPoint(points);

        if (linear.isSolvable()) {
            System.out.println("The intersecting point is at (" + linear.getX() + ", " + linear.getY() + ")");
        } else {
            System.out.println("The two lines are parallel");
        }

    }

}
