package Chapter_06;

import java.util.Scanner;

/**
 * Chapter 6 Exercise 2:
 *
 *      (Sum the digits in an integer)
 *      Write a method that computes the sum of the digits in an integer.
 * Created by Luiz Arantes Sa on 8/25/14.
 */
public class Exercise_02 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a integer: ");
        long num = input.nextLong();

        System.out.println("The sum of the DIGITS is " + sumDigits(num));
    }

    public static int sumDigits(long n) {
        int sum = 0;

        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum;
    }
}
