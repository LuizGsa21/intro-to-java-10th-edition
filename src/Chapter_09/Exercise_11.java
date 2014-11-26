package Chapter_09;

import ToolKit.LinearEquation;

import java.util.Scanner;

/**
 * Chapter 9 Exercise 11:
 *
 *      (Algebra: 2 * 2 linear equations)
 *      Design a class named LinearEquation for a 2 * 2 system of linear equations:
 *
 *      The class contains:
 *          ■ Private data fields a, b, c, d, e, and f.
 *          ■ A constructor with the arguments for a, b, c, d, e, and f.
 *          ■ Six getter methods for a, b, c, d, e, and f.
 *          ■ A method named isSolvable() that returns true if ad - bc is not 0.
 *          ■ Methods getX() and getY() that return the solution for the equation.
 *
 *       Draw the UML diagram for the class and then implement the class.
 *       Write a test program that prompts the user to enter a, b, c, d, e, and f
 *       and displays the result. If ad - bc is 0, report that “The equation has no solution.”
 *       See Programming Exercise 3.3 for sample runs.
 *
 * Created by Luiz Arantes Sa on 9/2/14.
 */
public class Exercise_11 {

    public static void main(String[] strings) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a, b, c, d, e, f: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        double d = input.nextDouble();
        double e = input.nextDouble();
        double f = input.nextDouble();

        LinearEquation linear = new LinearEquation(a,b,c,d,e,f);

        if (linear.isSolvable()) {
            System.out.println("x is " + linear.getX() + " and y is " + linear.getY());
        } else {
            System.out.println("The equation has no solution.");
        }
    }

}
