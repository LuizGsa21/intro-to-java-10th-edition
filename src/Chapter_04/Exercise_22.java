package Chapter_04;

import java.util.Scanner;

/**
 * Chapter 4 Exercise 22:
 *
 *      (Check substring)
 *      Write a program that prompts the
 *      user to enter two strings and reports whether the second
 *      string is a substring of the first string.
 *
 * Created by Luiz Arantes Sa on 8/23/14.
 */
public class Exercise_22 {

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        System.out.println("Enter String 1: ");
        String s1 = input.nextLine();
        System.out.print("Enter String 2: ");
        String s2 = input.nextLine();
        input.close();

        if (s1.contains(s2)) {
            System.out.println(s2 + " is a substring of " + s1);
        } else {
            System.out.println(s2 + " is NOT a substring of " + s1);
        }

    }
}
