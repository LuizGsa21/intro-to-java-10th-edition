package Chapter_04;

import java.lang.reflect.Parameter;
import java.util.Scanner;

/**
 * Chapter 4 Exercise 14:
 *
 *      (Convert letter grade to number)
 *      Write a program that prompts the user to enter a
 *      letter grade A, B, C, D, or F and displays its
 *      corresponding numeric value 4, 3, 2, 1, or 0.
 *
 * Created by Luiz Arantes Sa on 8/23/14.
 */
public class Exercise_14 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a letter grade: ");
        char ch = input.next().charAt(0);
        input.close();

        if (isValidGrade(ch)) {
            System.out.println("The numeric value for grade " + ch + " " + gradeValue(ch));
        } else {
            System.out.print(ch + " is an invalid input");
        }

    }

    public static boolean isValidGrade(char ch) {
        ch = Character.toUpperCase(ch);

        return (ch >= 'A' && ch <= 'F' && ch != 'E');
    }

    public static int gradeValue(char ch) {
        ch = Character.toUpperCase(ch);
        switch (ch) {
            case 'A': return 4;
            case 'B': return 3;
            case 'C': return 2;
            case 'D': return 1;
            case 'F': return 0;
                default: return -1;
        }
    }
}
