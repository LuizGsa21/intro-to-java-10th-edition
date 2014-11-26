package Chapter_10;

import ToolKit.StackOfIntegers;

/**
 * Chapter 10 Exercise 6:
 *
 *     (Displaying the prime numbers)
 *     Write a program that displays all the prime numbers less than 120
 *     in decreasing order. Use the StackOfIntegers class to store the prime
 *     numbers (e.g., 2, 3, 5, ...) and retrieve and display them in reverse order.
 *
 * Created by Luiz Arantes Sa on 9/2/14.
 */
public class Exercise_06 {

    public static void main(String[] args) {

        System.out.println("Printing prime numbers under 120.. ");

        StackOfIntegers stack = new StackOfIntegers(20);

        for (int i = 2; i < 120; i++) {
            if (isPrime(i)) {
                stack.push(i);
            }
        }
        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static boolean isPrime(int n) {

        double range = Math.sqrt(n);
        for (int i = 2; i < range ; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }


}
