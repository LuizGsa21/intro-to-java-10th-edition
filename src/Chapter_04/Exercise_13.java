package Chapter_04;

import java.util.Scanner;

/**
 * Chapter 4 Exercise 13:
 *
 *      (Vowel or consonant?)
 *      Write a program that prompts
 *      the user to enter a letter and check whether the
 *      letter is a vowel or consonant.
 *
 * Created by Luiz Arantes Sa on 8/23/14.
 */
public class Exercise_13 {

    public static void main(String[] args) {



        Scanner input = new Scanner(System.in);
        System.out.print("Enter a letter: ");
        char ch = input.next().charAt(0);


        if (isVowel(ch)) {
            System.out.println(ch + " is a vowel.");
        } else if (isConsonant(ch)) {
            System.out.println(ch + " is a consonant.");
        } else {
            System.out.println("Input error.");
        }


    }

    // checks to see if char is a vowel a e i o u
    // note: not case sensitive
    public static boolean isVowel(char ch) {

        ch = Character.toUpperCase(ch);

        return !(ch != 'A' && ch != 'E' && ch != 'I' && ch != 'O' &&ch != 'U');

    }

    public static boolean isConsonant(char ch) {

        ch = Character.toUpperCase(ch);

        return !isVowel(ch) && (ch >= 'A' && ch <= 'Z');

    }

}
