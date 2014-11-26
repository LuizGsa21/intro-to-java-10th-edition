package Chapter_04;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Chapter 4 Exercise 23:
 *
 *      (Financial application: payroll)
 *       Write a program that reads the following information and prints a payroll statement:
 *       Employee’s name (e.g., Smith)
 *       Number of hours worked in a week (e.g., 10) Hourly pay rate (e.g., 9.75)
 *       Federal tax withholding rate (e.g., 20%) State tax withholding rate (e.g., 9%)
 *
 * Created by Luiz Arantes Sa on 8/23/14.
 */
public class Exercise_23 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter employee's name: ");
        String name = input.next();
        System.out.print("Enter number of hours worked in a week: ");
        double hours = input.nextDouble();
        System.out.print("Enter hourly pay rate: ");
        double hourlyRate = input.nextDouble();
        System.out.print("Enter federal tax withholding rate: ");
        double fedTax = input.nextDouble();
        System.out.print("Enter state tax withholding rate: ");
        double stateTax = input.nextDouble();

        // calculating grosspay
        double grossPay = hours * hourlyRate;
        // calulating fed tax
        double fedTaxWithholding = grossPay * fedTax;
        // calculating state tax
        double stateTaxWithholding = grossPay * stateTax;
        // calculating reduction
        double totalDeduction = fedTaxWithholding + stateTaxWithholding;
        // calculating net pay
        double netPay = grossPay - totalDeduction;

        System.out.println("Employee Name: Smith" + name +
                "\nPay Rate: " + formatCurrency(hourlyRate) +
                "\nHours Worked: " + hours +
                "\nGross Pay: " + formatCurrency(grossPay) +
                "\nDeductions:" +
                "\n  Federal Withholding ("+ formatPercent(fedTax)+"): " + formatCurrency(fedTaxWithholding) +
                "\n  State Withholding ("+ formatPercent(stateTax)+"): " + formatCurrency(stateTaxWithholding) +
                "\n  Total Deduction: " + formatCurrency(totalDeduction) +
                "\nNet Pay: " + formatCurrency(netPay));
    }

    public static String formatCurrency(double money) {


        return  DecimalFormat.getCurrencyInstance().format(money);
    }
    public static String formatPercent(double percent) {


        return  DecimalFormat.getPercentInstance().format(percent);
    }
}
