package Chapter_05;

import java.util.Scanner;

/**
 * Chapter 5 Exercise 14:
 *
 *      (Compute the greatest common divisor)
 *      Another solution for Listing 5.9 to find the greatest common
 *      divisor of two integers n1 and n2 is as follows: First find d
 *      to be the minimum of n1 and n2, then check whether d, d-1, d-2, ..., 2, or 1
 *      is a divisor for both n1 and n2 in this order. The first such common divisor
 *      is the greatest common divisor for n1 and n2. Write a program that prompts the
 *      user to enter two positive integers and displays the gcd.
 *
 * Created by Luiz Arantes Sa on 8/24/14.
 */
public class Exercise_14 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter first integer number: ");
        int num1 = input.nextInt();
        System.out.print("Enter second integer number: ");
        int num2 = input.nextInt();
        input.close();

        int denominator = (num1 > num2) ? num2 : num1;

        for (; denominator > 0; denominator--)
            if (num1 % denominator == 0 && num2 % denominator == 0) break;

        System.out.println("GCD of " + num1 + " and " + num2 + " is " + denominator);
    }
}
