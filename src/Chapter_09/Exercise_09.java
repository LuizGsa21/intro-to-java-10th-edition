package Chapter_09;

import ToolKit.RegularPolygon;

/**
 * Chapter 9 Exercise 9:
 *
 * (Geometry: n-sided regular polygon)
 *      In an n-sided regular polygon, all sides have the same length and all angles have the same degree
 *      (i.e., the polygon is both equilateral and equiangular). Design a class named RegularPolygon that contains:
 *          ■ A private int data field named n that defines the number of sides in the poly- gon with default value 3.
 *          ■ A private double data field named side that stores the length of the side with default value 1.
 *          ■ A private double data field named x that defines the x-coordinate of the poly- gon’s center with default value 0.
 *          ■ A private double data field named y that defines the y-coordinate of the poly- gon’s center with default value 0.
 *          ■ A no-arg constructor that creates a regular polygon with default values.
 *          ■ A constructor that creates a regular polygon with the specified number of sides and length of side, centered at (0, 0).
 *          ■ A constructor that creates a regular polygon with the specified number of sides, length of side, and x- and y-coordinates.
 *          ■ The accessor and mutator methods for all data fields.
 *          ■ The method getPerimeter() that returns the perimeter of the polygon.
 *          ■ The method getArea() that returns the area of the polygon.
 *      The formula for computing the area of a regular polygon is Area (n * s * s) / 4 tan(PI/N)
 *      Draw the UML diagram for the class and then implement the class. Write a test program that creates three
 *      RegularPolygon objects, created using the no-arg constructor, using RegularPolygon(6, 4), and using RegularPolygon(10, 4, 5.6, 7.8).
 *      For each object, display its perimeter and area.
 *
 * Created by Luiz Arantes Sa on 9/1/14.
 */
public class Exercise_09 {

    public static void main(String[] args) {

        RegularPolygon[] regularPolygons = new RegularPolygon[3];
        regularPolygons[0] = new RegularPolygon();
        regularPolygons[1] = new RegularPolygon(6,4);
        regularPolygons[2] = new RegularPolygon(10,4,5.6,8.7);

        for (int i = 0; i < 3; i++) {

            System.out.printf("Polygon #%d area = %.3f perimeter = %.3f\n",
                    i, regularPolygons[i].getArea(), regularPolygons[i].getPerimeter());
        }
    }
}
