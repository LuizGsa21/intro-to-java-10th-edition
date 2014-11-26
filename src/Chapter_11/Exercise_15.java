package Chapter_11;

import ToolKit.MyPoint;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Chapter 11 Exercise 15:
 *
 *      (Area of a convex polygon)
 *      A polygon is convex if it contains any line segments that connects
 *      two points of the polygon. Write a program that prompts the user to enter
 *      the number of points in a convex polygon, then enter the points clockwise,
 *      and display the area of the polygon.
 *
 *      NOTE: THE BOOKS AREA OUTPUT IS INACCURATE
 *      Checked answer at http://www.mathopenref.com/coordpolygonareacalc.html
 *      Books answer: 250.075
 *      Correct Answer: 232.575
 *
 * Created by Luiz Arantes Sa on 9/8/14.
 */
public class Exercise_15 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of the points: ");
        int numOfPoints = input.nextInt();

        System.out.print("Enter the coordinates of the points: ");
        ArrayList<MyPoint> points = new ArrayList<>();
        for (int i = 0; i < numOfPoints; i++) {
            points.add(new MyPoint(input.nextDouble(), input.nextDouble()));
        }


        System.out.println("The total area is " + getConvexPolygonArea(points));

    }

    //  Area of a Convex Polygon
    // http://www.mathwords.com/a/area_convex_polygon.htm
    public static double getConvexPolygonArea(ArrayList<MyPoint> points) {
        // points must be counter clockwise
        double sum1 = 0;
        double sum2 = 0;
        for (int i = 0; i < points.size(); i++) {
            int limitIndex = (i + 1) % points.size();
            MyPoint p1 = points.get(i);
            MyPoint p2 = points.get(limitIndex);
            System.out.println("P1 index = " + i);
            System.out.println("P2 index =" + limitIndex);
            sum1 += (p1.x * p2.y);
            sum2 += (p1.y * p2.x);
        }

        double area = 0.5 * (sum1 - sum2);
        return (area > 0) ? area : -area;
    }

}
