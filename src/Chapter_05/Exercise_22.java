package Chapter_05;

import java.util.Scanner;

/**
 * Chapter 5 Exercise 22:
 *
 *      (Financial application: loan amortization schedule)
 *      The monthly payment for a given loan pays the principal and the interest.
 *      The monthly interest is computed by multiplying the monthly interest rate
 *      and the balance (the remaining principal). The principal paid for
 *      the month is therefore the monthly payment minus the monthly interest.
 *      Write a program that lets the user enter the loan amount,number of years,
 *      and interest rate and displays the amortization schedule for the loan.
 *      loan.
 *
 * Created by Luiz Arantes Sa on 8/24/14.
 */
public class Exercise_22 {

    public static void main(String[] strings) {


        // making scanner buffer
        Scanner input = new Scanner(System.in);

        // getting loan amount
        System.out.printf("Loan amount: ");
        double loanAmount = input.nextDouble();

        // asking number of years
        System.out.print("Number of Years: ");
        int numberOfYears = input.nextInt();

        System.out.print("Annual Interest Rate (8.25): ");
        double annualInterestRate = input.nextDouble();

        // Obtain monthly interest rate
        double monthlyInterestRate = annualInterestRate/1200;

        // Compute mortgage
        double monthlyPayment = loanAmount*monthlyInterestRate / (1 - (Math.pow(1 / (1 + monthlyInterestRate), numberOfYears * 12)));
        double balance = loanAmount;
        double interest;
        double principal;

        System.out.println("Monthly Payment: " + (int)(monthlyPayment * 100) / 100.0 );
        System.out.println("Total Payment: " + (int)(monthlyPayment * 12 * numberOfYears * 100) / 100.0 + "\n" );

        // Display the header
        System.out.println("Payment#\tInterest\tPrincipal\tBalance");
        for (int i = 1; i <= numberOfYears * 12; i++) {
            interest = (int)(monthlyInterestRate * balance * 100) / 100.0;
            principal = (int)((monthlyPayment - interest) * 100) / 100.0;
            balance = (int)((balance - principal) * 100) / 100.0;
            System.out.println(i + "\t\t\t" + interest + "\t\t" + principal + "\t\t" + balance);
        }
    }
}
