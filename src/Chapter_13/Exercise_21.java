package Chapter_13;

import ToolKit.BigRational;

import java.util.Scanner;

/**
 * Chapter 13 Exercise 21:
 *
 *      (Algebra: vertex form equations)
 *      The equation of a parabola can be expressed in either standard form
 *      (y = ax^2 + bx + c) or vertex form (y = a(x - h)^2 + k).
 *      Write a program that prompts the user to enter a, b, and c as integers
 *      in standard form and displays h and k in the vertex form.
 *
 * Created by Luiz Arantes Sa on 9/12/14.
 */
public class Exercise_21 {

    public static void main(String[] args) {

        System.out.println("As integers..");
        System.out.print("Enter a, b, c: ");
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();


        BigRational h = new BigRational(Double.toString((double)-b / (2 * a)));
        BigRational k = new BigRational(Double.toString(c - (Math.pow(b,2) / (4.0 * a))));
        System.out.println("h is " + h);
        System.out.println("k is " + k);


    }

}
