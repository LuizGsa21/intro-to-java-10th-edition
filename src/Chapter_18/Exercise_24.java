package Chapter_18;

import java.util.Scanner;

/**
 * (Hex to decimal)
 *  Write a recursive method that parses a hex number
 *  as a string into a decimal integer. The method header is:
 *
 *  public static int hex2Dec(String hexString)
 *
 *  Write a test program that prompts the user to enter a
 *  hex string and displays its decimal equivalent.
 *
 * Created by Luiz Arantes Sa on 12/7/14.
 */
public class Exercise_24 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a hexadecimal number: ");
        String hex = input.next();

        System.out.println(hex + " = " + hex2Dec(hex));

    }

    public static int hex2Dec(String hex) {

        if (hex.length() == 1)
            return convertHex(hex.charAt(0));
        else
            return (int)Math.pow(16, hex.length() - 1) * convertHex(hex.charAt(0)) + hex2Dec(hex.substring(1));
    }

    public static int convertHex(char ch) {

        System.out.println(ch + " Text " + (ch - 10));
        if (ch - '0' < 10)
            return ch - '0';
        ch = Character.toUpperCase(ch);
        return ch - 'A' + 10;
    }
}
