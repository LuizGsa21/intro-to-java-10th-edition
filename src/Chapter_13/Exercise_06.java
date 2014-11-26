package Chapter_13;

import ToolKit.Circle2D;
import ToolKit.GeometricObject;

/**
 * Chapter 13 Exercise 6:
 *
 *      (The ComparableCircle class)
 *      Define a class named ComparableCircle that extends Circle and implements Comparable.
 *      Draw the UML diagram and implement the compareTo method to compare the circles on the
 *      basis of area. Write a test class to find the larger of
 *      two instances of ComparableCircle objects.
 *
 * Created by Luiz Arantes Sa on 9/10/14.
 */
public class Exercise_06 {

    public static void main(String[] args) {
        ComparableCircle c1 = new ComparableCircle(0,0,5);
        ComparableCircle c2 = new ComparableCircle(0,0,10);
        ComparableCircle c3 = (ComparableCircle) GeometricObject.max(c1, c2);
        System.out.println(c1);
        System.out.println(c2);

        System.out.println("Max circle = " + c3.getRadius());
        System.out.println(c3);
    }
}


class ComparableCircle  extends Circle2D { // GeometricObject Implements compareTo

    ComparableCircle() {
    }

    ComparableCircle(double x, double y, double radius) {
        super(x, y, radius);
    }

}