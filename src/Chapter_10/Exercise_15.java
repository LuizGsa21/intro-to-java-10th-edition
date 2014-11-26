package Chapter_10;

import ToolKit.MyRectangle2D;

import java.util.Scanner;

/**
 * Chapter 10 Exercise 15:
 *
 *      "*10.15 (Geometry: the bounding rectangle)
 *      A bounding rectangle is the minimum rectangle that encloses a set of points in a two-dimensional
 *      plane, as shown in Figure 10.24d. Write a method that returns a bounding rectangle for a set of
 *      points in a two-dimensional plane, as follows:"
 *
 *      "public  static  MyRectangle2D  getRectangle(double[][]  points)"
 *      "The Rectangle2D class is defined in Programming Exercise 10.13. Write a"
 *      "test program that prompts the user to enter five points and displays the bounding
 *      rectangle’s center, width, and height. Here is a sample run:"
 *
 *      "Enter five points: 1.0 2.5 3 4 5 6 7 8 9 10"
 *      "The bounding rectangle's center (5.0, 6.25), width 8.0, height 7.5"
 *
 * Created by Luiz Arantes Sa on 9/5/14.
 */
public class Exercise_15 {

    public static void main(String[] args) {

        // 1.0 2.5 3 4 5 6 7 8 9 10
        System.out.print("Enter 5 given points: ");
        Scanner input = new Scanner(System.in);
        double[][] points = new double[5][2];
        for (int i = 0; i < points.length; i++) {
            points[i][0] = input.nextDouble();
            points[i][1] = input.nextDouble();
        }

        MyRectangle2D r1 = MyRectangle2D.getRectangle(points);
        System.out.println("Center point: " + r1.getCenterP().toString());
        System.out.println("width = " + r1.getWidth());
        System.out.println("height = " + r1.getHeight());
    }
}
