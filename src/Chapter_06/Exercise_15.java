package Chapter_06;

import java.util.Scanner;

/**
 * Chapter 6 Exercise 15:
 *
 *      (Financial application: print a tax table) Listing 3.5 gives
 *      a program to compute tax. Write a method for computing tax using the following header:
 *
 *      public static double computeTax(int status, double taxableIncome)
 *
 * Created by Luiz Arantes Sa on 8/25/14.
 */
public class Exercise_15 {


        public static void main(String[] args){

            String s1 = "Taxable Income";
            String s2 = "Single";
            String s3 = "Married Joint";
            String s4 = "Married Separate";
            String s5 = "Head of house";

            System.out.printf("%-20s%-12s%-4s%21s%16s\n", s1, s2, s3, s4, s5);
            for (int i = 50000; i <= 60000; i += 50) {
                System.out.printf("%4d%19.0f%16.0f%16.0f%20.0f\n", i,
                        computeTax(0, i),
                        computeTax(1, i),
                        computeTax(2, i),
                        computeTax(3, i)
                );

            }
        }

    public static double computeTax(int stats, double taxableIncome) {

        double tax;
        double[] taxPercent = new double[] { 0.10, 0.15,0.25,0.28,0.33,0.35 }; // tax rate
        double[][] taxRates = new double[][] {
                // stat 0 single
        {8350,33950, 82250, 171550, 372950},
                // stat 1 Married Filing Jointly
        {16700, 67900, 137050, 208850, 372950},
                // stat 2 Married Filing Separately
        {8350, 33950, 68525, 104425, 186475},
                // stat 3 Head of Household
        {11950, 45500, 117450, 190200, 372950}};


        if (taxableIncome <= taxRates[stats][0]) return Math.round(taxableIncome * taxPercent[0]);

        tax = taxRates[stats][0] * taxPercent[0];

        for (int i = 1; i < taxRates[stats].length; i++) {

            if (taxableIncome > taxRates[stats][i]) {

                tax += (taxRates[stats][i] - taxRates[stats][i - 1]) * taxPercent[i];

            } else {
                return Math.round(tax + (taxableIncome - taxRates[stats][i - 1]) * taxPercent[i]);
            }
        }
        return Math.round(tax + (taxableIncome - taxRates[stats][4]) * taxPercent[5]);
    }
}
