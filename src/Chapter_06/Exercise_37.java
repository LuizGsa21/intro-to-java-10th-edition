package Chapter_06;

import java.util.Scanner;

/**
 * Chapter 6 Exercise 37:
 *
 *      (Format an integer)
 *      Write a method with the following header to format the integer with the specified width.
 *
 *         - public static String format(int number, int width)
 *
 *      The method returns a string for the number with one or more prefix 0s.
 *      The size of the string is the width. For example,
 *         - format(34, 4) returns 0034
 *         - format(34, 5) returns 00034
 *      If the number is longer than the width, the method returns the string representation for the number.
 *         - For example, format(34, 1) returns 34.
 *
 *      Write a test program that prompts the user to enter a number and its width and displays
 *      a string returned by invoking format(number, width).
 *
 * Created by Luiz Arantes Sa on 8/26/14.
 */
public class Exercise_37 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number and a width: ");
        int n = input.nextInt();
        int width = input.nextInt();

        String s = format(n, width);
        System.out.println("The number formatted: " + s);
    }

    public static String format(int number, int width) {

        int size = getNumberSize(number);

        if (size > width) return "" + number;

        StringBuilder s = new StringBuilder();
        s.append(number);

        for (int i = 0; i < width - size; i++) {
            s.insert(0,'0');
        }

        return s.toString();
    }

    public static int getNumberSize(int n) {

        int size = 0;
        while (n > 0) {
            size++;
            n /= 10;
        }
        return size;
    }
}
