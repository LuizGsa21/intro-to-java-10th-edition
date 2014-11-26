package Chapter_10;

import ToolKit.Tax;

/**
 * Chapter 10 Exercise 8:
 *
 *      (Financial: the Tax class) Programming Exercise 8.12 writes a program for computing taxes using arrays. Design a class named Tax to contain the follow- ing instance data fields:
 *       ■ int filingStatus: One of the four tax-filing statuses:
 *              0—single filer,
 *              1— married filing jointly or qualifying widow(er),
 *              2—married filing separately, and 3—head of household.
 *              Use the public static constants SINGLE_FILER (0),
 *              MARRIED_JOINTLY_OR_QUALIFYING_WIDOW(ER) (1),
 *              MARRIED_ SEPARATELY (2),
 *              HEAD_OF_HOUSEHOLD (3) to represent the statuses.
 *
 *       ■ int[][] brackets: Stores the tax brackets for each filing status.
 *       ■ double[] rates: Stores the tax rates for each bracket.
 *       ■ double taxableIncome: Stores the taxable income.
 *
 *       Provide the getter and setter methods for each data field and the getTax() method
 *       that returns the tax. Also provide a no-arg constructor and the
 *       constructorTax(filingStatus, brackets, rates, taxableIncome).
 *       Draw the UML diagram for the class and then implement the class.
 *       Write a test program that uses the Tax class to print the 2001 and 2009
 *       tax tables for taxable income from $50,000 to $60,000 with intervals of $1,000
 *       for all four statuses. The tax rates for the year 2009 were given in Table 3.2.
 *       The tax rates for 2001 are shown in Table 10.1.
 *
 * Created by Luiz Arantes Sa on 9/2/14.
 */
public class Exercise_08 {

    public static void main(String[] args){

        int[][] brackets = new int[][] {
        // stat 0 single
        {8350,33950, 82250, 171550, 372950},
        // stat 1 Married Filing Jointly
        {16700, 67900, 137050, 208850, 372950},
        // stat 2 Married Filing Separately
        {8350, 33950, 68525, 104425, 186475},
        // stat 3 Head of Household
        {11950, 45500, 117450, 190200, 372950}};

        double[] rates = new double[] { 0.10, 0.15,0.25,0.28,0.33,0.35 };

        String s1 = "Taxable Income";
        String s2 = "Single";
        String s3 = "Married Joint";
        String s4 = "Married Separate";
        String s5 = "Head of house";

        System.out.printf("%-20s%-12s%-4s%21s%16s\n", s1, s2, s3, s4, s5);
        for (int i = 50000; i <= 60000; i += 1000) {
            System.out.printf("%4d%19.0f%16.0f%16.0f%20.0f\n", i,
                    new Tax(Tax.SINGLE_FILER,brackets,rates,i).getTax(),
                    new Tax(Tax.MARRIED_JOINTLY_OR_QUALIFYING_WIDOW,brackets,rates,i).getTax(),
                    new Tax(Tax.MARRIED_SEPARATELY,brackets,rates,i).getTax(),
                    new Tax(Tax.HEAD_OF_HOUSEHOLD,brackets,rates,i).getTax()
            );


        }
    }
}
