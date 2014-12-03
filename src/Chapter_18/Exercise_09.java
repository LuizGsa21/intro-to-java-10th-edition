package Chapter_18;

import java.util.Scanner;

/**
 * (Print the characters in a string reversely)
 * Write a recursive method that displays a string
 * reversely on the console using the following header:
 *
 * public static void reverseDisplay(String value)
 *
 * For example, reverseDisplay("abcd") displays dcba.
 * Write a test program that prompts the user
 * to enter a string and displays its reversal.
 *
 * Created by Luiz Arantes Sa on 12/2/14.
 */
public class Exercise_09 {

    public static void main(String[] args) {

        System.out.print("Enter a string: ");
        String value = new Scanner(System.in).nextLine();
        reverseDisplay(value);

    }

    private static void reverseDisplay(String value) {
        if (value.length() == 0)
            return;
        System.out.print(value.substring(value.length() - 1));
        reverseDisplay(value.substring(0, value.length()-1));
    }
}
