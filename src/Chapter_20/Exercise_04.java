package Chapter_20;

import java.util.Arrays;
import java.util.Comparator;

/**
 * (Sort points in a plane)
 * Write a program that meets the following requirements:
 *  ■ Define a class named Point with two data fields x and y to represent a point’s x- and y-coordinates.
 *      Implement the Comparable interface for com- paring the points on x-coordinates. If two points have the
 *      same x-coordinates, compare their y-coordinates.
 *  ■ Define a class named CompareY that implements Comparator<Point>. Implement the compare method to
 *      compare two points on their y-coordinates. If two points have the same y-coordinates, compare their x-coordinates.
 *  ■ Randomly create 100 points and apply the Arrays.sort method to display the points in increasing
 *      order of their x-coordinates and in increasing order of their y-coordinates, respectively.
 *
 * Created by Luiz Arantes Sa on 12/18/14.
 */
public class Exercise_04 {


    public static void main(String[] args) {

        // Create 100 random points
        Point[] points = new Point[100];
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point();
            points[i].x = Math.random() * 100;
            points[i].y = Math.random() * 100;
        }

        points[0].x = 1.03;
        points[0].y = 1.04;
        points[1].x = 1.03;
        points[1].y = 1.03;

        // Sort by X priority
        Arrays.sort(points);
        for (Point p : points) {
            System.out.println(p.toString());
        }

        // Sort by Y priority
        Arrays.sort(points, new CompareY());
        for (Point p : points) {
            System.out.println(p.toString());
        }

    }
}
class Point implements Comparable<Point> {

    public double x;
    public double y;

    @Override
    public int compareTo(Point o) {

        if (x > o.x)
            return 1;
        else if (x < o.x)
            return -1;
        else if (y > o.y)
            return 1;
        else if (y < o.y)
            return -1;
        else
            return 0;
    }

    @Override
    public String toString() {
        return "[" + String.format("%.2f",x) + ", " + String.format("%.2f",y) + "]";
    }
}

class CompareY implements Comparator<Point> {

    @Override
    public int compare(Point o1, Point o2) {

        if (o1.y > o2.y)
            return 1;
        else if (o1.y < o2.y)
            return -1;
        else if (o1.x > o2.x)
            return 1;
        else if (o1.x < o2.x)
            return -1;
        else
            return 0;
    }
}
