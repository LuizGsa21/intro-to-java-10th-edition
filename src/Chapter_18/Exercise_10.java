package Chapter_18;

import java.util.Scanner;

/**
 * (Occurrences of a specified character in a string)
 * Write a recursive method that finds the number of occurrences of
 * a specified letter in a string using the following method header:
 *
 * public static int count(String str, char a)
 *
 * For example, count("Welcome", 'e') returns 2. Write a test program that
 * prompts the user to enter a string and a character, and displays the
 * number of occurrences for the character in the string.
 *
 * Created by Luiz Arantes Sa on 12/2/14.
 */
public class Exercise_10 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = input.next();
        char ch = input.next().charAt(0);
        System.out.println(count(str, ch));

    }

    public static int count(String s, char ch) {

        int n =  (ch == s.charAt(0)) ? 1 : 0;
        if (s.length() == 1)
            return n;
        else
            return n + count(s.substring(1), ch);

    }

}
