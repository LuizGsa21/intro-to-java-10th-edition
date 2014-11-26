package Chapter_05;

import java.util.Scanner;

/**
 * Chapter 5 Exercise 38:
 *
 *      (Decimal to octal) Write a program that prompts the user to enter a decimal
 *      integer and displays its corresponding octal value. Don’t use Java’s Integer
 *      .toOctalString(int) in this program.
 *
 * Created by Luiz Arantes Sa on 8/24/14.
 */
public class Exercise_38 {

    public static void main(String[] strings) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int number = input.nextInt();

        String hexString = "";
        while (number > 0) {
            int digit = number % 16;

            if (digit == 15)
                hexString = "F" + hexString;
            else if (digit == 14)
                hexString = "E" + hexString;
            else if (digit == 13)
                hexString = "D" + hexString;
            else if (digit == 12)
                hexString = "C" + hexString;
            else if (digit == 11)
                hexString = "B" + hexString;
            else if (digit == 10)
                hexString = "A" + hexString;
            else
                hexString = digit + hexString;

            number = number / 16;
        }
        System.out.println(hexString);
    }
}
