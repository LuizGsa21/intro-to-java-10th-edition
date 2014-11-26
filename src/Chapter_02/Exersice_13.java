package Chapter_02;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Chapter 2 Exercise 13:
 *      (Financial application: compound value)
 *
 * Created by Luiz Arantes Sa on 6/20/14.
 */
public class Exersice_13 {

    public static void main(String[] Strings) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter monthly saving amount: ");
        double savingsAmount = input.nextDouble();

        for (int i = 1; i <= 6; i++) {

            if (i == 1) {
                savingsAmount = savingsAmount * (1.0 + 0.00417);
            } else {
                savingsAmount = (100 + savingsAmount) * (1.0 + 0.00417);
            }
        }


        DecimalFormat df = new DecimalFormat(".##");

        df.setRoundingMode(RoundingMode.DOWN);

        System.out.println("After the sixth month, the account value is $" + df.format(savingsAmount));
    }
}
