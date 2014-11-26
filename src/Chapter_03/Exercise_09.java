package Chapter_03;

import java.util.Scanner;

/**
 * Chapter 3 Exercise 9:
 *
 *      (Business: check ISBN-10) An ISBN-10 (International Standard Book Number) consists of 10 digits:
 *      d1d2d3d4d5d6d7d8d9d10. The last digit, d10, is a checksum, which is calculated from the
 *      other nine digits using the following formula:
 *
 *      (d1 * 1 + d2 * 2 + d3 * 3 + d4 * 4 + d5 * 5 + d6 * 6 + d7 * 7+ d8 * 8 + d9 * 9 ) % 11
 *
 *      If the checksum is 10, the last digit is denoted as X according to the ISBN-10 convention.
 *      Write a program that prompts the user to enter the first 9 digits and displays the 10-digit ISBN
 *      (including leading zeros). Your program should read the input as an integer.
 *
 * Created by Luiz Arantes Sa on 6/22/14.
 */
public class Exercise_09 {

    static final int ISBN = 10;

    public static void main(String[] strings) {

        // Getting user input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first 9 digits of an ISBN as integer: ");
        int nineDigitISBN = input.nextInt();
        input.close();

        // Splitting the nineDigitISBN into an array and counting the digit sum
        char[] tenDigitISBN = new char[ISBN];

        int nineDigitSum = 0;
        for (int i = ISBN - 2; i >= 0; i--) {
            int digit = nineDigitISBN % 10;
            tenDigitISBN[i] = Integer.toString(digit).charAt(0);

            digit = digit * (i + 1);
            nineDigitSum += digit;
            nineDigitISBN /= 10;
        }

        // Placing correct format for digit 10
        int lastDigit = nineDigitSum % 11;
        if (lastDigit == 10) {
            tenDigitISBN[ISBN - 1] = 'X';
        } else {
            tenDigitISBN[ISBN - 1] = Integer.toString(lastDigit).charAt(0);
        }

        System.out.println("The ISBN-10 number is " + new String(tenDigitISBN));




    }
}
