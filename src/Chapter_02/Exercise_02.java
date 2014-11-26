package Chapter_02;

import java.util.Scanner;

/**
 * Chapter 2 Exercise 2:
 *
 *      (Compute the volume of a cylinder) Write a program that reads in the radius
 *      and length of a cylinder and computes the area and volume.
 *
 * Created by Luiz Arantes Sa on 8/23/14.
 */
public class Exercise_02 {

    public static void main(String[] Strings) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the radius and the length of a cylinder: ");
        double radius = input.nextDouble();
        double length = input.nextDouble();

        double area = radius * radius * 3.14159265359;
        double volume = area * length;

        System.out.println("The area is " + area);
        System.out.println("The volume is " + volume);
    }
}
