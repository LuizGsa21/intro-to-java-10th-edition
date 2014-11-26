package Chapter_06;

import org.w3c.dom.ls.LSException;

import java.util.Scanner;

/**
 * Chapter 6 Exercise 22:
 *
 *      (Math: approximate the square root) There are several techniques for implementing
 *      the sqrt method in the Math class. One such technique is known as the Babylonian method.
 *      It approximates the square root of a number, n, by repeatedly performing a calculation
 *      using the following formula:
 *
 *          nextGuess = (lastGuess + n / lastGuess) / 2
 *
 *      When nextGuess and lastGuess are almost identical, nextGuess is the approximated square root.
 *      The initial guess can be any positive value (e.g., 1). This value will be the starting value
 *      for lastGuess. If the difference between nextGuess and lastGuess is less than a very small
 *      number, such as 0.0001, you can claim that nextGuess is the approximated square root of n.
 *      If not, next- Guess becomes lastGuess and the approximation process continues. Implement
 *      the following method that returns the square root of n.
 *
 *      public static double sqrt(long n)
 *
 * Created by Luiz Arantes Sa on 8/26/14.
 */
public class Exercise_22 {


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a integer number: ");
        long num = input.nextLong();
        System.out.println("The square root of "+num +" is " +sqrt(num));
    }

    public static double sqrt(long n) {

        double accuracy = 0.00000000001;
        double positive;
        double lastGuess;

        double nextGuess = 1;
        do {
             lastGuess = nextGuess;
             nextGuess = (lastGuess + (n / lastGuess)) * 0.5;

              positive = (nextGuess - lastGuess > 0) ? nextGuess - lastGuess : lastGuess - nextGuess;
        } while (positive > accuracy);

        return lastGuess;
    }
}








