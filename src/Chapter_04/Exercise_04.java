package Chapter_04;

import java.util.Scanner;

/**
 * Chapter 4 Exercise 4:
 *
 *      (Geometry: area of a hexagon)
 *
 * Created by Luiz Arantes Sa on 8/23/14.
 */
public class Exercise_04 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the side: ");
        double side = input.nextDouble();
        input.close();

        // Calculate the are of a hexagon
        double area = (6.0 * side * side) / (4.0 * Math.tan(Math.PI / 6.0));
        System.out.println("The area of a hexagon is " + area);

    }
}
