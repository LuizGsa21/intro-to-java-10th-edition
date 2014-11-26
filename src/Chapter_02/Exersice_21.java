package Chapter_02;

import java.util.Scanner;

/**
 * Chapter 2 Exercise 21:
 *
 *      (Financial application: calculate future investment value)
 *
 * Created by Luiz Arantes Sa on 6/20/14.
 */
public class Exersice_21 {

    public static void main(String[] Strings) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter investment amount: ");
        double investmentAmount = input.nextDouble();

        System.out.print("Enter annual interest rate in percentage: ");
        double annualInterestRate = input.nextDouble() / 100;

        System.out.print("Enter number of years: ");
        double years = input.nextDouble();

        double futureInvestmentValue = investmentAmount *
                Math.pow((1 + (annualInterestRate / 12)), (years * 12));

        System.out.print("Accumulated value is $" + futureInvestmentValue);
    }
}
