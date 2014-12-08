package Chapter_18;

import java.util.Scanner;

/**
 * (Decimal to hex)
 * Write a recursive method that converts a decimal number
 * into a hex number as a string. The method header is:
 *
 * public static String dec2Hex(int value)
 *
 * Write a test program that prompts the user to enter
 * a decimal number and displays its hex equivalent.
 *
 * Created by Luiz Arantes Sa on 12/2/14.
 */
public class Exercise_22 {

    public static void main(String[] args) {

        System.out.print("Enter a number: ");
        int number = new Scanner(System.in).nextInt();

        System.out.print(number + " in binary is " + dec2Hex(number));
    }

    private static String dec2Hex(int number) {

        if (number < 16)
            return getHexFormat(number);
        else
            return  dec2Hex(number / 16) + getHexFormat(number % 16);
    }

    private static String getHexFormat(int n) {

        if (n > 9 && n < 16)
            return (char)(n - 10 + 'A') + "";
        if (n >= 0)
            return n + "";
        else
            return "INVALID";
    }
}
