package Chapter_06;

import java.util.Scanner;

/**
 * Chapter 6 Exercise 3:
 *
 *      (Palindrome integer)
 *      Write a test program that prompts the user to enter an integer
 *      and reports whether the integer is a palindrome.
 *
 * Created by Luiz Arantes Sa on 8/25/14.
 */
public class Exercise_03 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a integer: ");
        int num = input.nextInt();

        if (isPalindrome(num)) {
            System.out.println(num + " is a palindrome.");
        } else {
            System.out.println(num + " is NOT a palindrome.");

        }

    }

    public static int reverse(int number) {

        int reverse = 0;
        while (number != 0) {

            reverse *= 10; // is ignored first iteration
            reverse += number % 10;
            number /= 10;
        }

        return reverse;
    }

    public static boolean isPalindrome(int number) {

        return (number == reverse(number));
    }
}
