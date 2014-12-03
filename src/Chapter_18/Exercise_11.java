package Chapter_18;

import java.util.Scanner;

/**
 * (Sum the digits in an integer using recursion)
 * Write a recursive method that computes the sum of
 * the digits in an integer. Use the following method header:
 *
 *  public static int sumDigits(long n)
 *
 * For example, sumDigits(234) returns 2 + 3 + 4 = 9. Write a test program
 * that prompts the user to enter an integer and displays its sum.
 *
 * Created by Luiz Arantes Sa on 12/2/14.
 */
public class Exercise_11 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        long n = input.nextLong();
        System.out.println(sumDigits(n));

    }

    public static long sumDigits(long n) {

        if (n == 0)
            return n;

        return n % 10 + sumDigits(n / 10);
    }
}
