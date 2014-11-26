package Chapter_06;

import java.util.Scanner;

/**
 * Chapter 6 Exercise 36:
 *
 *      (Geometry: area of a regular polygon)
 *      A regular polygon is an n-sided polygon in which all sides are of the same
 *      length and all angles have the same degree (i.e., the polygon is both equilateral and equiangular).
 *      Write a method that returns the area of a regular polygon using the following header:
 *
 *              public static double area(int n, double side)
 *
 *      Write a main method that prompts the user to enter the number of sides and the
 *      side of a regular polygon and displays its area.
 *
 ** Created by Luiz Arantes Sa on 8/26/14.
 */
public class Exercise_36 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of sides: ");
        int n = input.nextInt();
        System.out.print("Enter the side: ");
        double side = input.nextDouble();

        System.out.println("The area of the pentagon is " + area(n, side));


    }

    public static double area(int n, double s) {
        return  (n * s * s) / (4 * Math.tan(Math.PI/n));
    }
}
