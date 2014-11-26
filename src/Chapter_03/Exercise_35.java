package Chapter_03;

import java.util.Scanner;

/**
 * Chapter 3 Exercise 35:
 *
 *      (Decimal to hex)
 *
 * Created by Luiz Arantes Sa on 6/22/14.
 */
public class Exercise_35 {

    public static void main(String[] strings) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a decimal value (0 to 15): ");
        int number = input.nextInt();

        if (number < 0 || number > 15) {
            System.out.println("Invalid input");
        } else {
            String hexString = Integer.toHexString(number);
            hexString = hexString.toUpperCase();
            System.out.println(hexString);
        }

    }
}
