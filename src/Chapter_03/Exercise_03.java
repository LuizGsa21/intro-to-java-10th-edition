package Chapter_03;

import java.util.Scanner;

/**
 * Chapter 3 Exercise 3:
 *      (Algebra: solve 2 * 2 linear equations)
 *
 * Created by Luiz Arantes Sa on 6/22/14.
 */
public class Exercise_03 {

    public static void main(String[] strings) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a, b, c, d, e, f: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        double d = input.nextDouble();
        double e = input.nextDouble();
        double f = input.nextDouble();

        double ab_Minus_bc = a * d - b * c;
        if (ab_Minus_bc == 0.0) {

            System.out.println("The equation has no solution.");
        } else {
            double x = (e * d - b * f) / ab_Minus_bc;
            double y = (a * f - e * c) / ab_Minus_bc;
            System.out.println("x is " + x + " and y is " + y);
        }
    }
}
