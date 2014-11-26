package Chapter_01;

/**
 * Chapter 1 Exercise 13:
 *
 *      (Algebra: solve 2 * 2 linear equations)
 *      You can use Cramer’s rule to solve the following 2 * 2 system of linear equation.
 *      Write a program that solves the following equation and displays the value for x and y:
 *
 *          3.4x + 50.2y = 44.5
 *          2.1x + .55y = 5.9
 *
 * Created by Luiz Arantes Sa on 8/23/14.
 */
public class Exercise_13 {

    public static void main(String[] args) {

        // Variables for Cramer's formula
        double a = 3.4;
        double b = 50.2;
        double c = 2.1;
        double d = 0.55;
        double e = 44.5;
        double f = 5.9;

        double x = (e * d - b * f) / (a * d - b * c);
        double y = (a * f - e * c) / (a * d - b * c);

        System.out.println("x = " + x + " y = " + y);

    }
}
