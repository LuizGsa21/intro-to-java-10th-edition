package Chapter_08;

import java.util.Scanner;

/**
 * Chapter 8 Exercise 34:
 *
 *      (Geometry: rightmost lowest point)
 *      In computational geometry, often you need to find the rightmost lowest
 *      point in a set of points. Write the following method that returns the
 *      rightmost lowest point in a set of points.
 *
 *      public static double[] getRightmostLowestPoint(double[][] points)
 *
 *      Write a test program that prompts the user to enter the coordinates of
 *      six points and displays the rightmost lowest point.
 * Created by Luiz Arantes Sa on 9/1/14.
 */
public class Exercise_34 {

    static final int X = 0;
    static final int Y = 1;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);


        double[][] points = new double[6][2];
        System.out.print("Enter 6 points: ");
        for (int i = 0; i < points.length; i++)
            for (int j = 0; j < points[i].length; j++)
                points[i][j] = input.nextDouble();

        double[] point = getRightMostLowestPoint(points);
        double[] point2 = getLeftMostLowestPoint(points);
        System.out.println("The rightmost lowest point is (" + point[0] + ", " + point[1] + ")");
        System.out.println("The leftmost lowest point is (" + point2[0] + ", " + point2[1] + ")");
    }

    public static double[] getLeftMostLowestPoint(double[][] p) {

        double[] leftMost;
        leftMost = p[0];

        for (int i = 1; i < p.length; i++) {
            if (p[i][Y] < leftMost[Y]) {
                leftMost = p[i];
            } else if (p[i][Y] == leftMost[Y] && p[i][X] < leftMost[X]) {
                leftMost = p[i];
            }
        }
        return new double[] {leftMost[X], leftMost[Y]};

    }

    public static double[] getRightMostLowestPoint(double[][] p) {

        double[] rightMost;
        rightMost = p[0];

        for (int i = 1; i < p.length; i++) {

            if (p[i][Y] < rightMost[Y]) {

                rightMost = p[i];
            } else if (p[i][Y] == rightMost[Y] && p[i][X] > rightMost[X]) {

                rightMost = p[i];
            }
        }
        return new double[] {rightMost[X], rightMost[Y]};

    }
}
