package Chapter_18;

import java.util.Scanner;

/**
 * (Decimal to binary)
 * Write a recursive method that converts a decimal number
 * into a binary number as a string. The method header is:
 *
 *  public static String dec2Bin(int value)
 *
 * Write a test program that prompts the user to enter a decimal
 * number and displays its binary equivalent.
 *
 * Created by Luiz Arantes Sa on 12/2/14.
 */
public class Exercise_21 {

    public static void main(String[] args) {

        System.out.print("Enter a number: ");
        int number = new Scanner(System.in).nextInt();

        System.out.print(number + " in binary is " + dec2Bin(number));
    }

    public static String dec2Bin(int value) {

        String s = ((value & 1) == 1) ? "1" : "0";
        if (value == 0 || value == 1)
            return s;
        else
            return dec2Bin(value >> 1) + s;
    }
}
