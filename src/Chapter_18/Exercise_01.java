package Chapter_18;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * (Factorial)
 * Using the BigInteger class introduced in Section 10.9, you can
 * find the factorial for a large number (e.g., 100!). Implement the
 * factorial method using recursion. Write a program that prompts the
 * user to enter an integer and displays its factorial.
 *
 * Created by Luiz Arantes Sa on 11/30/14.
 */
public class Exercise_01 {

    public static void main(String[] args) {

        System.out.print("Enter an integer: ");
        int n = new Scanner(System.in).nextInt();

        System.out.println("It's factorial is: " + factorial(new BigInteger(n+"")));
    }

    private static BigInteger factorial(BigInteger n) {
        if (n.compareTo(BigInteger.ONE) == 0)
            return BigInteger.ONE;
        else
            return n.multiply(factorial(n.subtract(BigInteger.ONE)));

    }
}
