package Chapter_06;

import java.util.Scanner;

/**
 * Chapter 6 Exercise 20:
 *
 *      (Count the letters in a string)
 *      Write a method that counts the number of letters in a string using the following header:
 *       
 *          public static int countLetters(String s)
 *
 *       Write a test program that prompts the user to enter a string and displays
 *      the number of letters in the string.
 *
 * Created by Luiz Arantes Sa on 8/26/14.
 */
public class Exercise_20 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = input.nextLine();

        System.out.println("The number of letters inside the string is: " + countLetters(s));
    }
    public static int countLetters(String s) {

        int letterCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (isLetter(s.charAt(i))) letterCount++;
        }
        return letterCount;
    }

    public static boolean isLetter(char ch) {
        ch = Character.toUpperCase(ch);
        return (ch >= 'A' && ch <= 'Z');
    }
}
