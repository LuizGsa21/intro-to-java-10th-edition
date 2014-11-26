package Chapter_13;

import ToolKit.BigRational;

import java.util.Scanner;

/**
 * Chapter 13 Exercise :
 *
 *      (Convert decimals to fractions)
 *      Write a program that prompts the user to enter a decimal number
 *      and displays the number in a fraction. Hint: read the decimal number
 *      as a string, extract the integer part and fractional part from the string,
 *      and use the BigInteger implementation of the Rational class in Programming
 *      Exercise 13.15 to obtain a rational number for the decimal number.
 *
 * Created by Luiz Arantes Sa on 9/11/14.
 */
public class Exercise_19 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        String s = input.next();
        System.out.println("The fractional number is " + new BigRational(s));
    }
}
