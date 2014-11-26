package Chapter_08;

import java.util.Scanner;

/**
 * Chapter 8 Exercise 15:
 *
 *      (Geometry: same line?)
 *      Programming Exercise 6.39 gives a method for testing
 *      whether three points are on the same line.
 *      Write the following method to test whether all
 *      the points in the array points are on the same line.
 *
 *      public static boolean sameLine(double[][] points)
 *
 *      Write a program that prompts the user to enter five points and displays whether
 *      they are on the same line.
 *
 * Created by Luiz Arantes Sa on 8/30/14.
 */
public class Exercise_15 {

    static final int X = 0; // index constant for x
    static final int Y = 1; // index constant for y

    public static void main(String[] args) {

        System.out.print("Enter 5 points: ");
        double[][] points = new double[5][2];

        Scanner input = new Scanner(System.in);
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                points[i][j] = input.nextDouble();
            }
        }
        if (sameLine(points)) {
            System.out.println("The five points are on the same line");
        } else {
            System.out.println("The five points are not on the same line");
        }

    }

    public static boolean sameLine(double[][] points) {

        for (int k = 0; k < points.length - 3; k++) {


            if (!onTheSameLine(points[k][X],points[k][Y],
                    points[k+1][X], points[k+1][Y],
                    points[k+2][X], points[k+2][Y])) {
                return false;
            }

        }
        return true;
    }
    /** Return true if point (x2, y2) is on the same
     *  line from (x0, y0) to (x1, y1) */
    public static boolean onTheSameLine(double x0, double y0, double x1, double y1, double x2, double y2) {

        return (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0) == 0;
    }
}
