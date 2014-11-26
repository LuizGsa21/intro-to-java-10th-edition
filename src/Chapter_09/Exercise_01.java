package Chapter_09;

import ToolKit.MyRec2;

/**
 * Chapter 9 Exercise 01:
 *
 *      (The MyRec2 class) Following the example of the Circle class in Section 9.2,
 *      design a class named MyRec2 to represent a rectangle. The class contains:
 *
 *              ■ Two double data fields named width and height that specify the width
 *                  and height of the rectangle. The default values are 1 for both width and height.
 *              ■ A no-arg constructor that creates a default rectangle.
 *              ■ A constructor that creates a rectangle with the specified width and height.
 *              ■ A method named getArea() that returns the area of this rectangle.
 *              ■ A method named getPerimeter() that returns the perimeter.
 *
 *      Draw the UML diagram for the class and then implement the class.
 *      Write a test program that creates two MyRec2 objects—one with
 *      width 4 and height 40 and the other with width 3.5 and height 35.9.
 *      Display the width, height, area, and perimeter of each rectangle in this order.
 *
 *
 * Created by Luiz Arantes Sa on 9/1/14.
 */
public class Exercise_01 {

    public static void main(String[] args) {


        MyRec2[] rectangles = new MyRec2[2];
        rectangles[0] = new MyRec2(4,40);
        rectangles[1] = new MyRec2(3.5, 35.9);

        for (int i = 0; i < 2; i++){
            System.out.println("MyRec2 " + (i+1) +":");
            System.out.print("Area = " + rectangles[i].getArea());
            System.out.println(" Perimeter = " +  rectangles[i].getPerimeter() +"\n");
        }
    }
}
