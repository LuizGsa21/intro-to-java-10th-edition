package ToolKit;

/**
 * Chapter 10 Exercise 8:
 *
 *      My class for Chapter 10 Exercise 8.
 *
 * Created by Luiz Arantes Sa on 9/2/14.
 */
public class Tax {

    public static final int SINGLE_FILER = 0;
    public static final int MARRIED_JOINTLY_OR_QUALIFYING_WIDOW= 1;
    public static final int MARRIED_SEPARATELY = 2;
    public static final int HEAD_OF_HOUSEHOLD = 3;

    private int filingStatus;
    private int[][] brackets;
    private double[] rates;
    private double taxableIncome;

    public Tax(int filingStatus, int[][] brackets, double[] rates, double taxableIncome) {
        this.filingStatus = filingStatus;
        this.brackets = brackets;
        this.rates = rates;
        this.taxableIncome = taxableIncome;

    }

    public int getFilingStatus() {
        return filingStatus;
    }

    public void setFilingStatus(int filingStatus) {
        this.filingStatus = filingStatus;
    }

    public int[][] getBrackets() {
        return brackets;
    }

    public void setBrackets(int[][] brackets) {
        this.brackets = brackets;
    }

    public double[] getRates() {
        return rates;
    }

    public void setRates(double[] rates) {
        this.rates = rates;
    }

    public double getTaxableIncome() {
        return taxableIncome;
    }

    public void setTaxableIncome(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    public double getTax() {
        double tax;
        if (taxableIncome <= brackets[filingStatus][0]) return Math.round(taxableIncome * rates[0]);

        tax = brackets[filingStatus][0] * rates[0];

        for (int i = 1; i < brackets[filingStatus].length; i++) {

            if (taxableIncome > brackets[filingStatus][i]) {
                tax += (brackets[filingStatus][i] - brackets[filingStatus][i - 1]) * rates[i];

            } else {
                return Math.round(tax + (taxableIncome - brackets[filingStatus][i - 1]) * rates[i]);
            }
        }
        return Math.round(tax + (taxableIncome - brackets[filingStatus][4]) * rates[5]);
    }




}

//int[][] brackets = new int[][] {
//        // stat 0 single
//        {8350,33950, 82250, 171550, 372950},
//        // stat 1 Married Filing Jointly
//        {16700, 67900, 137050, 208850, 372950},
//        // stat 2 Married Filing Separately
//        {8350, 33950, 68525, 104425, 186475},
//        // stat 3 Head of Household
//        {11950, 45500, 117450, 190200, 372950}};

// double[] rates = new double[] { 0.10, 0.15,0.25,0.28,0.33,0.35 };