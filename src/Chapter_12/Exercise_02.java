package Chapter_12;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Chapter 12 Exercise 2:
 *
 *      (InputMismatchException)
 *      Write a program that prompts the user to read two integers and
 *      displays their sum. Your program should prompt the user to read
 *      the number again if the input is incorrect.
 *
 * Created by Luiz Arantes Sa on 9/8/14.
 */
public class Exercise_02 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter two integers: ");
        int num1 = 0;
        int num2 = 0;
        boolean isValid = false;
        while (!isValid) {
            try {
                num1 = input.nextInt();
                num2 = input.nextInt();
                isValid = true;
            } catch (InputMismatchException ex) {

                input.nextLine();
                System.out.println("Invalid input..." );
                System.out.print("Enter two integers: ");
            }
        }
        System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
    }
}
