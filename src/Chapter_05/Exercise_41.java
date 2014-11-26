package Chapter_05;

import java.util.Scanner;

/**
 * Chapter 5 Exercise 41:
 *
 *      (Occurrence of max numbers) Write a program that reads integers, finds
 *      the largest of them, and counts its occurrences. Assume that the input
 *      ends with number 0. Suppose that you entered 3 5 2 5 5 5 0; the program
 *      finds that the largest is 5 and the occurrence count for 5 is 4.
 *
 * Created by Luiz Arantes Sa on 8/24/14.
 */
public class Exercise_41 {

    public static void main(String[] strings) {

        Scanner input = new Scanner(System.in);
        int largest = 0;
        int occurrence = 0;
        int number;

        System.out.print("Enter number: ");
        do {
            number = input.nextInt();
            if (number > largest) {
                occurrence = 0;
                largest = number;
            }
            if (number == largest) {
                occurrence++;
            }

        } while (number != 0);

        System.out.println("The largest number is " + largest);
        System.out.println("The occurrence count is " + occurrence);
    }
}
