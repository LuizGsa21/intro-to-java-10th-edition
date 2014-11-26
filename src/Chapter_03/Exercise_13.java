package Chapter_03;

import java.util.Scanner;

/**
 * Chapter 3 Exercise 13:
 *
 *      (Financial application: compute taxes)
 *
 * Created by Luiz Arantes Sa on 6/22/14.
 */
public class Exercise_13 {

    public static void main(String[] strings) {

        // Create a Scanner
        Scanner input = new Scanner(System.in);

        // Prompt the user to enter filing status
        System.out.print("(0-single filer, 1-married jointly or qualifying widow(er), " +
                "\n2-married separately, 3-head of household)\n"
                + "Enter the filing status: ");

        int status = input.nextInt();

        // Prompt the user to enter taxable income
        System.out.print("Enter the taxable income: ");
        double income = input.nextDouble();

        // Compute tax
        double tax = 0;

        if (status == 0) { // Compute tax for single filers
            if (income <= 8350) {
                tax = income * 0.10;
            } else if (income <= 33950) {
                tax = 8350 * 0.10 + (income - 8350) * 0.15;
            } else if (income <= 82250) {
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (income - 33950) * 0.25;
            } else if (income <= 171550) {
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 +
                        (income - 82250) * 0.28;
            } else if (income <= 372950) {
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 +
                        (171550 - 82250) * 0.28 + (income - 171550) * 0.33;
            } else {
                tax = 8350 * 0.10 + (33950 - 8350) * 0.15 + (82250 - 33950) * 0.25 +
                        (171550 - 82250) * 0.28 + (372950 - 171550) * 0.33 +
                        (income - 372950) * 0.35;
            }
        } else if (status == 1) {
            if (income <= 16700.0) {
                tax = income * 0.1;
            } else if (income <= 67900.0) {
                tax = 1670.0 + (income - 16700.0) * 0.15;
            } else if (income <= 137050.0) {
                tax = 9350.0 + (income - 67900.0) * 0.25;
            } else if (income <= 208850.0) {
                tax = 26637.5 + (income - 137050.0) * 0.28;
            } else if (income <= 372950.0) {
                tax = 46741.5 + (income - 208850.0) * 0.33;
            } else {
                tax = 90562.5 + (income - 372950.0) * 0.35;
            }

        } else if (status == 2) {
            if (income <= 8350.0) {
                tax = income * 0.1;
            } else if (income <= 33950.0) {
                tax = 835.0 + (income - 8350.0) * 0.15;
            } else if (income <= 68525.0) {
                tax = 4675.0 + (income - 33950.0) * 0.25;
            } else if (income <= 104425.0) {
                tax = 13318.75 + (income - 68525.0) * 0.28;
            } else if (income <= 186475.0) {
                tax = 23370.75 + (income - 104425.0) * 0.33;
            } else {
                tax = 50447.25 + (income - 186475.0) * 0.35;
            }

        } else if (status == 3) {
            if (income <= 11950.0) {
                tax = income * 0.1;
            } else if (income <= 45500.0) {
                tax = 1195.0 + (income - 11950.0) * 0.15;
            } else if (income <= 117450.0) {
                tax = 6227.5 + (income - 45500.0) * 0.25;
            } else if (income <= 190200.0) {
                tax = 24215.0 + (income - 117450.0) * 0.28;
            } else if (income <= 372950.0) {
                tax = 44585.0 + (income - 190200.0) * 0.33;
            } else {
                tax = 104892.5 + (income - 372950.0) * 0.35;
            }

        } else {
            System.out.println("Invalid status...");
            System.exit(1);
        }

        // Display the result
        System.out.println("Tax is " + (int) (tax * 100) / 100.0);
    }
}
