package Chapter_13;

import ToolKit.Complex;
import ToolKit.QuadraticEquation;

import java.util.Scanner;

/**
 * Chapter 13 Exercise :
 *
 *      (Algebra: solve quadratic equations)
 *      Rewrite Programming Exercise 3.1 to obtain imaginary roots
 *      if the determinant is less than 0 using the Complex class
 *      in Programming Exercise 13.17.
 *
 * Created by Luiz Arantes Sa on 9/11/14.
 */
public class Exercise_20 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a, b, c: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();

        QuadraticEquation equation = new QuadraticEquation(a, b, c);
        double discriminant = equation.getDiscriminant();
        if (discriminant > 0) {
            double r1 = (-b + Math.pow(discriminant, 0.5)) / (2 * a);
            double r2 = (-b - Math.pow(discriminant, 0.5)) / (2 * a);
            System.out.println("The roots are " + r1 + " and " + r2);
        }else if (discriminant == 0) {
            Complex r1 = new Complex(-b / (2 * a));
            System.out.println("The root is " + r1);
        } else {
            System.out.println("The equation has no real roots.");
            Complex r1 = new Complex(-b / (2 * a), Math.pow(-discriminant, 0.5) / (2 * a));
            Complex r2 = new Complex(-b / (2 * a), -Math.pow(-discriminant, 0.5) / (2 * a));
            System.out.println("The roots are " + r1 + " and " + r2);
        }

    }

}
