package Chapter_04;

import ToolKit.Kit;

import java.util.Scanner;

/**
 * Chapter 4 Exercise 12:
 *
 *      (Hex to binary)
 *      Write a program that prompts the user to enter a hex digit
 *      and displays its corresponding binary number.
 *
 * Created by Luiz Arantes Sa on 8/23/14.
 */
public class Exercise_12 {

    public static final int NOT_VALID = -1;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a hex digit: ");
        String s = input.next();

        if (isHexadecimal(s)) {
            System.out.println(s + " = " + Kit.binaryFormat(hexToBinary(s)) + " in binary");

        } else {
            System.out.println("Invalid input");
        }

    }

    public static String hexToBinary(String hex) {

        return decimalToBinary(hexToDecimal(hex));
    }

    public static String decimalToBinary(long n) {

        StringBuilder stringBuilder = new StringBuilder();
        while (n > 0) {

            stringBuilder.insert(0, n & 1);
            n >>= 1;
        }

        return stringBuilder.toString();
    }

    public static long hexToDecimal(String hex) {

        if (!isHexadecimal(hex)) return NOT_VALID;

        long n = 0;

        int placeValue = hex.length() - 1;
        for (int i = 0; i < hex.length(); i++) {

            char ch = hex.charAt(i);

            if (isNumeric(ch)) {
                n += (charToDecimal(ch) * Math.pow(16, placeValue--));
            } else {
                n += hexLetterToInt(ch) * Math.pow(16, placeValue--);

            }
        }
        return n;
    }

    private static int hexLetterToInt(char ch) {

        ch = Character.toUpperCase(ch);

        return (ch - 'A' + 10);
    }


    public static int charToDecimal(char ch) {

        if (!isNumeric(ch)) return NOT_VALID;

        return ch - '0';

    }

    public static boolean isNumeric(char ch) {

        return (ch >= '0' && ch <= '9');
    }

    public static boolean isHexadecimal(String s) {

        for (int i = 0; i < s.length(); i++) {

            if (!isHexValid(s.charAt(i))) return false;
        }

        return true;
    }

    public static boolean isHexValid(char ch) {

        ch = Character.toUpperCase(ch);

        return isCharAtRange(ch, '0', '9') || isCharAtRange(ch, 'A', 'F');

    }


    public static boolean isCharAtRange(char ch, char start, char end) {

        return !(ch < start || ch > end);

    }
}
