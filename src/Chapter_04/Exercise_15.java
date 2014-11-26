package Chapter_04;

import java.util.Scanner;

/**
 * Chapter 4 Exercise 15:
 * <p/>
 * (Phone key pads)
 * Write a program that prompts the user to enter a
 * letter and displays its corresponding number.
 * <p/>
 * Created by Luiz Arantes Sa on 8/23/14.
 */
public class Exercise_15 {

    private static final int INVALID_KEY = -1;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a letter: ");
        char ch = input.next().charAt(0);

        int numberPressed = correspondingNumber(ch);

        if (numberPressed != INVALID_KEY) {

            System.out.println("The corresponding number is " + numberPressed);
        } else {
            System.out.println(ch + " is an invalid input");
        }

    }

    public static int correspondingNumber(char ch) {

        ch = Character.toUpperCase(ch);

        if (ch >= 'A' && ch <= 'O') {
            int number = 2; // where 'A' start
            int n = ch - 'A';
            number += (n / 3);
            return number;
        }

        if (ch >= 'P' && ch <= 'S') return 7;
        if (ch >= 'T' && ch <= 'V') return 8;
        if (ch >= 'W' && ch <= 'Z') return 9;

        return INVALID_KEY;

    }




}
