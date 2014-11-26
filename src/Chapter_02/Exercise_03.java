package Chapter_02;

import java.util.Scanner;

/**
 * Chapter 2 Exercise 3:
 *
 *      (Convert feet into meters) Write a program that reads a number in feet,
 *      converts it to meters, and displays the result. One foot is 0.305 meter.
 *
 * Created by Luiz Arantes Sa on 8/23/14.
 */
public class Exercise_03 {

    public static void main(String[] Strings) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a value for feet: ");
        double feet = input.nextDouble();
        double meters = feet * 0.305;
        System.out.println(feet + " feet is " + meters + " meters");

    }
}
