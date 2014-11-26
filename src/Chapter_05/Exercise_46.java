package Chapter_05;

import java.util.Scanner;

/**
 * Chapter 5 Exercise 46:
 *
 *      (Reverse a string)
 *      Write a program that prompts the user to enter a string
 *      and displays the string in reverse order.
 *
 * Created by Luiz Arantes Sa on 8/24/14.
 */
public class Exercise_46 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = input.next();
        String reverse = "";
        for (int i = s.length() - 1; i >= 0; i--) {

            reverse += s.charAt(i);
        }
        System.out.print(s + " in reverse is " + reverse);

    }

}
