package Chapter_03;

import java.util.Scanner;

/**
 * Chapter 3 Exercise 31:
 *
 *      (Financials: currency exchange)
 *
 * Created by Luiz Arantes Sa on 6/22/14.
 */
public class Exercise_31 {

    public static void main(String[] strings) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the exchange rate from dollars to RMB: ");
        double dollarToRMBRate = input.nextDouble();

        System.out.print("Enter 0 to convert dollars to RMB and 1 vice versa: ");
        int convertOption = input.nextInt();

        double dollars;
        double RMB;

        if (convertOption == 0) {
            System.out.print("Enter the dollar amount: ");
            dollars = input.nextDouble();
            RMB = dollars * dollarToRMBRate;
            System.out.println("$" + dollars + " is " + RMB + " Yuan");
        } else if (convertOption == 1) {
            System.out.print("Enter the RMB amount: ");
            RMB = input.nextDouble();
            dollars = RMB / dollarToRMBRate;
            System.out.println(RMB + " Yuan" + " is " + "$" + dollars);
        } else {
            System.out.println("Invalid option");
        }

    }
}
