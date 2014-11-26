package Chapter_04;

import java.util.Scanner;

/**
 * Chapter 4 Exercise 19:
 *
 *      (Business: check ISBN-10) Rewrite the Programming
 *      Exercise 3.9 by entering the ISBN number as a string.
 *
 * Created by Luiz Arantes Sa on 8/23/14.
 */
public class Exercise_19 {

    static final int ISBN = 10;

    public static void main(String[] strings) {

        // Getting user input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first 9 digits of an ISBN as integer: ");
        String s = input.next();
        input.close();

        // Splitting the nineDigitISBN into an array and counting the digit sum
        int nineDigitISBN = Integer.parseInt(s);
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
