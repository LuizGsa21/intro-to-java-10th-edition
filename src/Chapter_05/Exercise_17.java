package Chapter_05;

import java.util.Scanner;

/**
 * Chapter 5 Exercise 17:
 *
 *      (Display pyramid )
 *      Write a program that prompts the user to enter an
 *      integer from 1 to 15 and displays a pyramid
 *
 * Created by Luiz Arantes Sa on 8/24/14.
 */
public class Exercise_17 {

    public static void main(String[] strings) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of lines (1-15): ");
        int numberOfLines = input.nextInt();

        while(numberOfLines < 1 || numberOfLines > 15) {
            System.out.println("Invalid input");
            System.out.print("Enter the number of lines (1-15): ");
            numberOfLines = input.nextInt();
        }

        for (int currentRow = 1; currentRow <= numberOfLines; currentRow++) {

            for (int currentColumn = 1; currentColumn <= numberOfLines - currentRow; currentColumn++) {
                System.out.printf("%3s", " ");
            }
            for (int number = currentRow; number >= 1; number--) {
                //System.out.print(" " + number);
                System.out.printf("%3d", number);
            }
            for (int number = 2; number <= currentRow; number++) {
                //System.out.print(" " + number);
                System.out.printf("%3d", number);

            }
            System.out.println();

        }
    }
}
