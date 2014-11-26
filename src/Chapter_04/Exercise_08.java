package Chapter_04;

import java.util.Scanner;

/**
 * Chapter 4 Exercise 8:
 *
 *      (Find the character of an ASCII code)
 *      Write a program that receives an ASCII code (an integer between 0 and 127)
 *      and displays its character.
 *
 * Created by Luiz Arantes Sa on 8/23/14.
 */
public class Exercise_08 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter an ASCII code: ");
        int number = input.nextInt();
        input.close();

        System.out.println("The character for ASCII code " + number + " is " + (char) number);
    }
}
