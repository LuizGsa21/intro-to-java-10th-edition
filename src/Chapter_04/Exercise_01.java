package Chapter_04;

import java.util.Scanner;

/**
 * Chapter 4 Exercise 1:
 *
 *      (Geometry: area of a pentagon) Write a program that prompts
 *      the user to enter the length from the center of a pentagon to a vertex
 *      and computes the area of the pentagon
 *
 * Created by Luiz Arantes Sa on 8/23/14.
 */
public class Exercise_01 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a length from the center to a vertex: ");
        double radius = input.nextDouble();
        input.close();

        // Calculating the area of the pentagon
        double s = 2 * radius * Math.sin(Math.PI / 5);
        double area = (5 * s * s) / (4 * Math.tan(Math.PI/5));

        System.out.printf("The area of the pentagon is %.2f", area);
    }
}
