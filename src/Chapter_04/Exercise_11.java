package Chapter_04;

import java.util.Scanner;

/**
 * Chapter 4 Exercise 11:
 *
 *      (Decimal to hex)
 *      Write a program that prompts the user to
 *      enter an integer between 0 and 15 and displays
 *      its corresponding hex number.
 *
 * Created by Luiz Arantes Sa on 8/23/14.
 */
public class Exercise_11 {

    public static void main(String[] args) {

        // Get user input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a decimal value (0 to 15): ");
        int number = input.nextInt();
        input.close();


        String hex = getHexValue(number);

        if (hex != null) {
            System.out.println("The hex value is: " + hex);
        } else {
            System.out.println("Invalid input");
        }

    }

    /**
     * Accepts a number of range 0 <= number >= 15
     *
     * @return
     *  <p>a type <strong>String</strong> hex value</p>
     *  <p>returns null if out of range</p>
     */
    public static String getHexValue(int number) {

        // returns null if out of range
        if (number < 0 || number > 15) return null;

        if (number <= 9) {
            return Character.toString((char)(number + '0'));
        } else {
            return Character.toString((char) (number - 10 + 'A'));
        }

    }
}
