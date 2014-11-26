package Chapter_02;

import java.util.Scanner;

/**
 * Chapter 2 Exercise 16:
 *
 *      (Geometry: area of a hexagon)
 *
 * Created by Luiz Arantes Sa on 6/20/14.
 */
public class Exersice_16 {

    public static void main(String[] Strings) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the side: ");
        double side = input.nextDouble();

        double area = 3 * 1.732 * side * side / 2;

        System.out.println("The area of the hexagon is " + area);

    }
}
