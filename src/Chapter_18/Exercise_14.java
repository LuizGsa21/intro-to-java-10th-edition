package Chapter_18;

import java.util.Scanner;

/**
 * (Find the number of uppercase letters in a string)
 * Write a recursive method to return the number of uppercase
 * letters in a string. Write a test program that prompts the
 * user to enter a string and displays the number of uppercase
 * letters in the string.
 *
 * Created by Luiz Arantes Sa on 12/2/14.
 */
public class Exercise_14 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = input.nextLine();

        System.out.print("Number of uppercase letters: " + numOfUppercase(s));

    }

    private static int numOfUppercase(String s) {
        return numOfUppercase(s, 0);
    }

    private static int numOfUppercase(String s, int count) {
        if (s.length() == 0)
            return count;
        if (s.charAt(0) >= 65 && s.charAt(0) <= 90)
            count++;

        return numOfUppercase(s.substring(1), count);
    }
}
