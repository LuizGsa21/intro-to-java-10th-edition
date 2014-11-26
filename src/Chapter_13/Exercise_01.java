package Chapter_13;

import ToolKit.Triangle;

import java.util.Scanner;

/**
 * Chapter 13 Exercise 1:
 *
 *      (Triangle class)
 *      Design a new Triangle class that extends the abstract GeometricObject class.
 *      Draw the UML diagram for the classes Triangle and GeometricObject and then implement
 *      the Triangle class. Write a test program that prompts the user to enter three sides
 *      of the triangle, a color, and a Boolean value to indicate whether the triangle is filled.
 *      The program should create a Triangle object with these sides and set the color and filled
 *      properties using the input. The program should display the area, perimeter, color, and
 *      true or false to indicate whether it is filled or not.
 *
 * Created by Luiz Arantes Sa on 9/9/14.
 */
public class Exercise_01 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter three sides of a triangle: ");
        double[] sides = new double[3];
        for (int i = 0; i < sides.length; i++) {
            sides[i] = input.nextDouble();
        }
        System.out.print("Enter a triangle color: ");
        String color = input.next();
        System.out.print("Is the triangle filled? true/false: ");
        String isFilledString = input.next();
        boolean isFilled = (isFilledString.equals("true"));

        Triangle t1 = new Triangle(sides[0], sides[1], sides[2]);
        t1.setColor(color);
        t1.setFilled(isFilled);
        System.out.println("Triangle 1:");
        System.out.println("Area = " + t1.getArea());
        System.out.println("Perimeter = " + t1.getPerimeter());
        System.out.println("Color = " + t1.getColor());
        System.out.println("Is filled? " + t1.isFilled());


    }

}
