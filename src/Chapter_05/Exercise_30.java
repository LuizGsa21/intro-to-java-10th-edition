package Chapter_05;

import java.util.Scanner;

/**
 * Chapter 5 Exercise 30:
 *
 *      (Financial application: compound value)
 *      Write a program that prompts the user to enter an amount (e.g., 100),
 *      the annual interest rate (e.g., 5), and the number of months (e.g., 6)
 *      and displays the amount in the savings account after the given month.
 *
 * Created by Luiz Arantes Sa on 8/24/14.
 */
public class Exercise_30 {

    public static void main(String[] strings) {

        Scanner input = new Scanner(System.in);

        System.out.print("Amount to save each month: ");
        double monthlySavings = input.nextDouble();

        System.out.print("Annual interest: ");
        double annualInterestRate = input.nextDouble();

        System.out.print("Number of months: ");
        int numberOfMonths = input.nextInt();

        double monthlyInterestRate = annualInterestRate / 1200.0D;
        double accountValue = monthlySavings * (1.0D + monthlyInterestRate);

        for (int i = 1; i < numberOfMonths; i++) {
            accountValue = (accountValue + monthlySavings) * (1.0D + monthlyInterestRate);
        }
        System.out.println("After month #" + numberOfMonths +
                ", the account value is " + accountValue);

    }
}
