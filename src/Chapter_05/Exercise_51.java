package Chapter_05;

import java.util.Scanner;

/**
 * Chapter 5 Exercise 51:
 *
 *      (Longest common prefix) Write a program that prompts the user to enter two strings
 *      and displays the largest common prefix of the two strings.
 *
 * Created by Luiz Arantes Sa on 8/24/14.
 */
public class Exercise_51 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String s1 = input.nextLine();
        System.out.print("Enter second string: ");
        String s2 = input.nextLine();

        System.out.println(commonPrefix(s1, s2));

    }

    public static String commonPrefix(String s1, String s2) {

        String prefix = "";

        int limit = (s1.length() < s2.length()) ? s1.length() : s2.length();

        for (int i = 0; i < limit; i++) {

            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);

            String temp = commonPrefix(ch1, ch2);
            if (temp == null) break;

            prefix += temp;
        }
        return prefix;
    }

    public static String commonPrefix(char ch1, char ch2) {

        if (ch1 == ch2) return "" + ch1;

        return null;
    }
}
