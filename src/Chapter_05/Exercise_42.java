package Chapter_05;

import java.util.Scanner;

/**
 * Chapter 5 Exercise 42:
 *
 *      (Financial application: find the sales amount) Rewrite Programming Exercise 5.39 as follows:
 *       Use a for loop instead of a do-while loop.
 *       Let the user enter COMMISSION_SOUGHT instead of fixing it as a constant.
 *
 * Created by Luiz Arantes Sa on 8/24/14.
 */
public class Exercise_42 {

    public static void main(String[] strings) {
        Scanner input = new Scanner(System.in);

        double commission;
        double salesAmount = 0.01;

        System.out.print("Enter commission amount: ");
        double customCommission = input.nextInt();



        for (commission = 0; commission < customCommission;  salesAmount += 0.01) {

            if (salesAmount >= 10000.01) {
                commission = 900.0 + (salesAmount - 10000.0) * 0.12;
            } else if (salesAmount >= 5000.01) {
                commission = 400.0 + (salesAmount - 5000.0) * 0.1;
            } else {
                commission = salesAmount * 0.08;
            }
        }

        System.out.println("You need $" + (int)(salesAmount * 100.0) / 100.0 +
                " sales amount to make a commission of $" + customCommission);
    }
}
