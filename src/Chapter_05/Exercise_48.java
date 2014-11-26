package Chapter_05;

import java.util.Scanner;

/**
 * Chapter 5 Exercise 48:
 *
 *      (Process string) Write a program that prompts the user
 *      to enter a string and displays the characters at odd positions.
 *
 * Created by Luiz Arantes Sa on 8/24/14.
 */
public class Exercise_48 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = input.nextLine();

        String oddChars = "";
        for (int i = 0; i < s.length(); i++) {

            if (i  % 2 == 0) {
                oddChars += s.charAt(i);
            }
        }

        System.out.println(oddChars);
    }
}
