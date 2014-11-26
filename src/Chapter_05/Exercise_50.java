package Chapter_05;

import java.util.Scanner;

/**
 * Chapter 5 Exercise 50:
 *
 *      (Count uppercase letters) Write a program that prompts the user to
 *      enter a string and displays the number of the uppercase letters in the string.
 *
 * Created by Luiz Arantes Sa on 8/24/14.
 */
public class Exercise_50 {

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String s = input.nextLine();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {

            if (isUpper(s.charAt(i))) {
                count++;
            }
        }
        System.out.println("The number of uppercase letters is " + count);

    }

    public static boolean isUpper(char ch) {

        return isVowel(ch) || isConsonant(ch);
    }
    public static boolean isVowel(char ch) {

        return ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';

    }

    public static boolean isConsonant(char ch) {

        return !isVowel(ch) && ch >= 'A' && ch <= 'Z';
    }
}
