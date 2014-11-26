package Chapter_06;

import java.util.Scanner;

/**
 * Chapter 6 Exercise 7:
 *
 *      (Financial application: compute the future investment value)
 *      Write a method that computes future investment value at a given interest
 *      rate for a specified number of years. The future investment is determined
 *      using the formula in Programming Exercise 2.21
 *
 * Created by Luiz Arantes Sa on 8/25/14.
 */

public class Exercise_07 {

    public static void main(String[] Strings) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter investment amount: ");
        double investmentAmount = input.nextDouble();

        System.out.print("Enter annual interest rate in percentage: ");
        double annualInterestRate = input.nextDouble() / 100;

        System.out.print("Enter number of years: ");
        int years = input.nextInt();

        System.out.printf("%3s%20s\n", "Years", "Future Value");
        for (int i = 1; i <= years; i++) {

            System.out.printf("%-4d%20.2f\n", i, futureInvestmentValue(investmentAmount, annualInterestRate / 12, i));


        }

    }

    public static double futureInvestmentValue
            (double investmentAmount, double monthlyInterestRate, int years) {

        return investmentAmount *  Math.pow((1 + monthlyInterestRate), (years * 12));
    }
}
