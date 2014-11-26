package Chapter_06;

import java.util.Scanner;

/**
 * Chapter 6 Exercise 5:
 *
 *      (Sort three numbers) Write a method with the
 *      following header to display three numbers in increasing order:
 *
 * Created by Luiz Arantes Sa on 8/25/14.
 */
public class Exercise_05 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a integer: ");
        double num1 = input.nextDouble();
        double num2 = input.nextDouble();
        double num3 = input.nextDouble();

        displaySortedNumbers(num1,num2,num3);
    }

    public static void displaySortedNumbers( double num1, double num2, double num3) {

        double temp;
        if (num1 > num2) {
            temp = num1;
            num1 = num2;
            num2 = temp;
        }

        if (num2 > num3) {
            temp = num2;
            num2 = num3;
            num3 = temp;
        }
        if (num1 > num2) {
            temp = num1;
            num1 = num2;
            num2 = temp;
        }
        System.out.println(num1 + " " + num2 + " " + num3);
    }
}
