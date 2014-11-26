package Chapter_13;

import ToolKit.Circle2D;
import ToolKit.GeometricObject;
import ToolKit.MyRectangle2D;

/**
 * Chapter 13 Exercise 5:
 *
 *  (Enable GeometricObject comparable)
 *  Modify the GeometricObject class to implement the Comparable interface,
 *  and define a static max method in the GeometricObject class for finding
 *  the larger of two GeometricObject objects. Draw the UML diagram and implement
 *  the new GeometricObject class. Write a test program that uses the max method
 *  to find the larger of two circles and the larger of two rectangles.
 *  
 * Created by Luiz Arantes Sa on 9/10/14.
 */
public class Exercise_05 {

    public static void main(String[] args) {

        Circle2D c1 = new Circle2D(0, 0, 5);
        Circle2D c2 = new Circle2D(0, 0, 2);
        Circle2D maxCircle =(Circle2D)GeometricObject.max(c1, c2);
        System.out.println("Circle 1: " + c1);
        System.out.println("Circle 2: " + c2);
        System.out.println("Max circle is: " + maxCircle);

        MyRectangle2D r1 = new MyRectangle2D(0, 0, 10, 5);
        MyRectangle2D r2 = new MyRectangle2D(0, 0, 10, 10);
        MyRectangle2D maxRectangle = (MyRectangle2D) GeometricObject.max(r1, r2);
        System.out.println("MyRec2 1: " + r1);
        System.out.println("MyRec2 2: " + r2);
        System.out.println("Max MyRec2 is: " + maxRectangle);


    }


}
