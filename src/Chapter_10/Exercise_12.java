package Chapter_10;

import ToolKit.MyPoint;
import ToolKit.Triangle2D;

/**
 * Chapter 10 Exercise 12:
 *
 *      (Geometry: the Triangle2D class) Define the Triangle2D class that contains:"
 *
 *      ■ Three points named p1, p2, and p3 of the type MyPoint with getter and setter methods.
 *          MyPoint is defined in Programming Exercise 10.4."
 *      ■ A no-arg constructor that creates a default triangle with the points (0, 0), (1,"1), and (2, 5)."
 *      ■ A constructor that creates a triangle with the specified points."
 *      ■ A method getArea() that returns the area of the triangle."
 *      ■ A method getPerimeter() that returns the perimeter of the triangle."
 *      ■ A method contains(MyPoint  p) that returns true if the specified point"
 *          p is inside this triangle (see Figure 10.22a)."
 *      ■ A method contains(Triangle2D  t) that returns true if the specified"
 *          triangle is inside this triangle (see Figure 10.22b)."
 *      ■ A method overlaps(Triangle2D  t) that returns true if the specified triangle overlaps with
 *      this triangle (see Figure 10.22c)."
 *
 *      Draw the UML diagram for the class and then implement the class. Write"
 *      a test program that creates a Triangle2D objects t1 using the constructor
 *      new Triangle2D(new MyPoint(2.5, 2), new MyPoint(4.2, 3), new MyPoint(5, 3.5)),
 *      displays its area and perimeter, and displays the result of t1.contains(3, 3),
 *      r1.contains(new Triangle2D(new MyPoint(2.9, 2), new MyPoint(4, 1), MyPoint(1, 3.4))),
 *      and t1. overlaps(new Triangle2D(new MyPoint(2, 5.5), new MyPoint(4,-3), MyPoint(2, 6.5)))."
 *      (Hint: For the formula to compute the area of a triangle, see Programming Exercise 2.19.
 *      To detect whether a point is inside a triangle, draw three dashed lines, as shown
 *      in Figure 10.23. If the point is inside a triangle, each dashed line should intersect a side
 *      only once. If a dashed line intersects a side twice, then the point must be outside the triangle.
 *      For the algorithm of finding the intersect- ing point of two lines, see Programming Exercise 3.25.)"
 *
 * Created by Luiz Arantes Sa on 9/3/14.
 */
public class Exercise_12 {

    public static void main(String[] args) {

        Triangle2D r1 = new Triangle2D(new MyPoint(0, 0), new MyPoint(0, 2), new MyPoint(2, 0));

        System.out.println("Area is " + r1.getArea());
        System.out.println("Perimeter is " + r1.getPerimeter());
        System.out.println("Point is inside triangle: " + r1.contains(1, 1));

        System.out.println("Triangle 2 is inside this triangle: " + r1.contains( new Triangle2D(4, 5, 10.5, 3.2, -0.5, -10.5)));
        System.out.println("Triangle 3 is overlaps this triangle: " + r1.overlaps(new Triangle2D(1, 1.7, -1, 1.7, 0,-3)));

    }


}