package Chapter_12;

import ToolKit.Kit;

import java.util.Scanner;

/**
 * Chapter 12 Exercise 6:
 *
 *      (NumberFormatException)
 *      Listing 6.8 implements the hex2Dec(String hexString) method,
 *      which converts a hex string into a decimal number.
 *      Implement the hex2Dec method to throw a NumberFormatException
 *      if the string is not a hex string.
 *
 * Created by Luiz Arantes Sa on 9/9/14.
 */
public class Exercise_06 {

    public static void main(String[] args) {
        // Create a Scanner
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter a string
        boolean isValid = false;
        String hex = "";
        int decimal = 0;
        while (!isValid) {
            try {
                System.out.print("Enter a hex number: ");
                hex = input.nextLine();
                decimal = hexToDecimal(hex);
                isValid = true;
            } catch (NumberFormatException ex) {
                System.out.println(ex.getLocalizedMessage());
                System.out.println("Try again...");
            }

        }
        System.out.println("The decimal value for hex number "
                + hex + " is " + decimal);
    }

    public static int hexToDecimal(String hex) throws NumberFormatException {
        if (!Kit.isHexadecimal(hex)) {
            throw new NumberFormatException("Not a hexadecimal number.");
        }
        int decimalValue = 0;
        for (int i = 0; i < hex.length(); i++) {
            char hexChar = hex.charAt(i);
            decimalValue = decimalValue * 16 + hexCharToDecimal(hexChar);
        }

        return decimalValue;
    }


    public static int hexCharToDecimal(char ch) {
        if (ch >= 'A' && ch <= 'F')
            return 10 + ch - 'A';
        else // ch is '0' - '9'
            return ch - '0';
    }
}
