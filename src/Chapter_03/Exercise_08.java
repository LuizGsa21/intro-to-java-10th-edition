package Chapter_03;

import javax.swing.*;
import java.util.Scanner;

/**
 * Chapter 3 Exercise 8:
 *
 *      (Sort three integers) Write a program that prompts the user to enter
 *      three integers and display the integers in non-decreasing order without
 *      using the Java's sort() method.
 *
 *
 *
 * Created by Luiz Arantes Sa on 6/22/14.
 */
public class Exercise_08 {

    public static void main(String[] strings) {

        int num1;
        int num2;
        int num3;

        // Grabbing input from user
        Scanner input = new Scanner(System.in);
        System.out.print("Enter three Integers: ");
        num1 = input.nextInt();
        num2 = input.nextInt();
        num3 = input.nextInt();
        input.close();

        // I'm using bitwise operators, so I don't have to create
        // a temp variable to swap the numbers
        if (num1 > num2) {
            num1 ^= num2;
            num2 ^= num1;
            num1 ^= num2;
        }

        if (num2 > num3) {
            num2 ^= num3;
            num3 ^= num2;
            num2 ^= num3;
        }

        if (num1 > num2) {
            num1 ^= num2;
            num2 ^= num1;
            num1 ^= num2;
        }
        System.out.println("Sorted Numbers: " + num1 + " " + num2 + " " + num3);
    }
}
