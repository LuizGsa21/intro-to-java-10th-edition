package Chapter_18;

import java.util.Scanner;

/**
 * (Binary to decimal)
 *  Write a recursive method that parses a binary number as a
 *  string into a decimal integer. The method header is:
 *
 *      public static int bin2Dec(String binaryString)
 *
 *  Write a test program that prompts the user to enter a binary
 *  string and displays its decimal equivalent.
 *
 * Created by Luiz Arantes Sa on 12/7/14.
 */
public class Exercise_23 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a binary number: ");
        String binary = input.next();

        System.out.println(binary + " is equal to " + bin2Dec(binary));

    }

    public static int bin2Dec(String s) {

        int i = (s.charAt(0) == '1') ? 1 : 0;
        if (s.length() == 1)
            return i;

        return (int)Math.pow(2, s.length() - 1) * i + bin2Dec(s.substring(1));
    }

}
