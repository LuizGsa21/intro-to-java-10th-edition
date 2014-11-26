package Chapter_04;

import java.util.Scanner;

/**
 * Chapter 4 Exercise 20:
 *
 *      (Process a string)
 *      Write a program that prompts the user
 *      to enter a string and displays its length and its first character.
 *
 * Created by Luiz Arantes Sa on 8/23/14.
 */
public class Exercise_20 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = input.next();
        input.close();

        System.out.println("String: " + s);
        System.out.println("Length = " + s.length());
        System.out.println("The first character is: " + s.charAt(0));

    }
}
