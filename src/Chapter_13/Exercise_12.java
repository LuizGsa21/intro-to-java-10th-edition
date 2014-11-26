package Chapter_13;

import ToolKit.Circle2D;
import ToolKit.GeometricObject;
import ToolKit.MyRectangle2D;

/**
 * Chapter 13 Exercise 12:
 *
 *      (Sum the areas of geometric objects)
 *      Write a method that sums the areas of all the geometric objects in an array.
 *      The method signature is:
 *
 *      public static double sumArea(GeometricObject[] a)
 *
 *      Write a test program that creates an array of four objects (two circles and two
 *      rectangles) and computes their total area using the sumArea method.
 *
 * Created by Luiz Arantes Sa on 9/10/14.
 */
public class Exercise_12 {

    public static void main(String[] args) {

        GeometricObject[] shapes = new GeometricObject[4];
        for (int i = 0; i < 4; i++) {
            if (i < 2) {
                shapes[i] = new Circle2D();
            } else {
                shapes[i] = new MyRectangle2D();
            }
            System.out.println("Area for object #"+(i + 1)+" = " + shapes[i].getArea());
        }

        System.out.println("Sum of GeometricObjects = " + GeometricObject.sumArea(shapes));
    }


}
