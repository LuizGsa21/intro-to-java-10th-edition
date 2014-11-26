package Chapter_10;

import ToolKit.Circle2D;

/**
 * Chapter 10 Exercise 11:
 *   (Geometry: the Circle2D class) Define the Circle2D class that contains:
 *    ■ Two double data fields named x and y that specify the center of the circle with getter methods.
 *    ■ A data field radius with a getter method.
 *    ■ A no-arg constructor that creates a default circle with (0, 0) for (x, y) and 1for radius.
 *    ■ A constructor that creates a circle with the specified x, y, and radius.
 *    ■ A method getArea() that returns the area of the circle.
 *    ■ A method getPerimeter() that returns the perimeter of the circle.
 *    ■ A method contains(double  x,  double  y) that returns true if the specified point (x, y) is inside
 *      this circle (see Figure 10.21a).
 *    ■ A method contains(Circle2D circle) that returns true if the specified circle is inside
 *      this circle (see Figure 10.21b).
 *    ■ A method overlaps(Circle2D circle) that returns true if the specified circle
 *      overlaps with this circle (see Figure 10.21c).
 *
 *      Write a test program that creates a Circle2D object c1 (new Circle2D(2, 2, 5.5)),
 *      displays its area and perimeter, and displays the result of c1.contains(3, 3),
 *      c1.contains(new  Circle2D(4,  5,  10.5)), and c1.overlaps(new Circle2D(3, 5, 2.3)).
 * Created by Luiz Arantes Sa on 9/2/14.
 */
public class Exercise_11 {

    public static void main(String[] args) {


        Circle2D c1 = new Circle2D(2, 2, 5.5);

        System.out.println("C1 area = " + c1.getArea() + " perimeter = " + c1.getPerimeter());
        System.out.println("Does c1 contain coordinate (3,3)? " + c1.contains(3, 3));
        System.out.println("Does c1 contain circle 2? " + c1.contains(new Circle2D(4, 5, 10.5)));
        System.out.println("Does c1 overlap circle 3? " + c1.overlaps(new Circle2D(3, 5, 2.3)));

    }

}
