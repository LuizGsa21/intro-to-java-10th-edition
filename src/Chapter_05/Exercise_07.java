package Chapter_05;

import java.text.DecimalFormat;

/**
 * Chapter 5 Exercise 7:
 *
 *      (Financial application: compute future tuition)
 *      Suppose that the tuition for a university is $10,000 this year and
 *      increases 5% every year. In one year, the tuition will be $10,500.
 *      Write a program that computes the tuition in ten years and the total
 *      cost of four years’ worth of tuition after the tenth year.
 *
 * Created by Luiz Arantes Sa on 8/24/14.
 */
public class Exercise_07 {

    private static final double TUITION = 10000; // tuition cost
    public static void main(String[] args) {


        double increaseRate = 0.05; // tuition percent increase rate
        double tInTenYears = TUITION; // tuition cost in 10 years
        double fourYearTuitionCost = 0;
        for (int i = 0; i < 10; i++) {
            tInTenYears *= (1 + increaseRate);
        }
        fourYearTuitionCost = tInTenYears;
        System.out.println("Tuition cost in 10 years: " +
                DecimalFormat.getCurrencyInstance().format(tInTenYears));
        for (int i = 0; i < 4; i++) {
            fourYearTuitionCost *= (1 + fourYearTuitionCost);

        }
        System.out.println("Total cost of 4 years starting today: " +
                DecimalFormat.getCurrencyInstance().format(tInTenYears));

    }
}
