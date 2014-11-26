package Chapter_05;

import java.util.Scanner;

/**
 * Chapter 5 Exercise 21:
 *
 *      (Financial application: compare loans with various interest rates)
 *      Write a program that lets the user enter the loan amount and
 *      loan period in number of years and displays the monthly and
 *      total payments for each interest rate starting from 5% to 8%,
 *      with an increment of 1/8.
 *
 * Created by Luiz Arantes Sa on 8/24/14.
 */

public class Exercise_21 {

    public static void main(String[] args) {

        double annualInterestRate = 5.00;

        // making scanner buffer
        Scanner input = new Scanner(System.in);

        // getting loan amount
        System.out.printf("Loan amount: ");
        double loanAmount = input.nextDouble();

        // asking number of years
        System.out.print("Number of Years: ");
        int numberOfYears = input.nextInt();

        // formating title display

        System.out.printf("%-1s%20s%20s\n", "Interest Rate", "Monthly Payment","Total Payment");
        // making loop to display different interest rates
        for ( ; annualInterestRate <= 8.00; annualInterestRate += 0.125) {

            // calculating monthly and total payment rates
            double monthlyInterestRate = annualInterestRate / 1200;
            double monthlyPayment = loanAmount * monthlyInterestRate / (1 - 1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12));

            double totalPayment = monthlyPayment * numberOfYears * 12;

            // making % string for formatting reasons...
            String str = "%";

            // Displaying formatted info
            System.out.printf("%-1.3f%s%17.2f%24.2f \n",annualInterestRate , str, ((int)(monthlyPayment * 100) / 100.0), ((int)(totalPayment * 100) / 100.0));

        }

    }
}
