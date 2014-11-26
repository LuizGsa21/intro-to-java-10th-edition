package Chapter_03;

import java.util.Scanner;

/**
 * Chapter 3 Exercise 1:
 *      (Algebra: solve quadratic equations)
 * Created by Luiz Arantes Sa on 6/20/14.
 */
public class Exercise_01 {

    public static void main(String[] Strings) {

        Scanner input = new Scanner(System.in);

            System.out.print("Enter a, b, c: ");
            double a = input.nextDouble();
            double b = input.nextDouble();
            double c = input.nextDouble();

            double discriminant = b * b - 4.0 * a * c;

            if (discriminant > 0.0) {
                double r1 = (-b + Math.pow(discriminant, 0.5)) / (2.0 * a);
                double r2 = (-b - Math.pow(discriminant, 0.5)) / (2.0 * a);
                System.out.println("The roots are " + r1 + " and " + r2);
            } else if (discriminant == 0.0) {
                double r1 = -b / (2.0 * a);
                System.out.println("The root is " + r1);
            } else {
                System.out.println("The equation has no real roots.");
            }

    }
}
