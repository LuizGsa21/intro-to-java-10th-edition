package Chapter_06;

import java.util.Scanner;

/**
 * Chapter 6 Exercise 23:
 *
 *      (Occurrences of a specified character) Write a method that finds the number of
 *       occurrences of a specified character in a string using the following header:
 *
 *          public static int count(String str, char a)
 *
 *       For example, count("Welcome", 'e') returns 2. Write a test program that prompts the user
 *       to enter a string followed by a character and displays the number of occurrences of the
 *       character in the string.
 *
 * Created by Luiz Arantes Sa on 8/26/14.
 */
public class Exercise_23 {


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = input.nextLine();
        System.out.print("Enter a character: ");
        char ch = input.next().charAt(0);

        System.out.println("The number of occurrences of \'" + ch +"\' in \"" + s + "\" is " + count(s,ch));
    }

    public static int count(String str, char a) {

        int count = 0;
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == a) count++;
        }

        return count;
    }
}
