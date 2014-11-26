package Chapter_05;

import java.util.Scanner;

/**
 * Chapter 5 Exercise 37:
 *
 *      (Decimal to binary) Write a program that prompts the user to enter a
 *      decimal integer and displays its corresponding binary value. Don’t use
 *      Java’s Integer .toBinaryString(int) in this program.
 *
 * Created by Luiz Arantes Sa on 8/24/14.
 */
public class Exercise_37 {

    public static void main(String[] strings) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int number = input.nextInt();

        String binaryString = "";
        while (number >= 1) {
            if (number % 2 == 0) {
                binaryString = "0" + binaryString ;
            } else {
                binaryString = "1" + binaryString ;
            }
            number /= 2;
        }
        System.out.println(binaryString);
    }
}
