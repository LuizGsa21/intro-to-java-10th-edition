package Chapter_04;

import java.util.Scanner;

/**
 * Chapter 4 Exercise 5:
 *
 *      (Geometry: area of a regular polygon)
 *
 * Created by Luiz Arantes Sa on 8/23/14.
 */
public class Exercise_05 {

    public static void main(String[] args) {

        // Asking user for information to calculate the area of a regular polygon
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of sides: ");
        double numOfSides = input.nextDouble();
        System.out.print("Enter the side: ");
        double length = input.nextDouble();
        input.close();

        double area = (numOfSides * length * length) / (4.0 * Math.tan(Math.PI / numOfSides));
        System.out.print("The area of the polygon is " + area);
    }
}
