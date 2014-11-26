package Chapter_06;

/**
 * Chapter 6 Exercise 11:
 *
 *      Financial application: compute commissions)
 *      Write a method that computes the commission,
 *      using the scheme in Programming Exercise 5.39
 *
 * Created by Luiz Arantes Sa on 8/25/14.
 */
public class Exercise_11 {

    public static void main(String[] args) {

        System.out.printf("%12s%15s\n", "Sales Amount", "Commission");
        for (int i = 10000; i <= 100000; i += 5000) {

            System.out.printf("%-6d%20.1f\n", i, computeCommission(i));
        }

    }

    public static double computeCommission(double salesAmount) {

        double commission;
        if (salesAmount >= 10000.01) commission = 900.0 + (salesAmount - 10000.0) * 0.12;
         else if (salesAmount >= 5000.01)  commission = 400.0 + (salesAmount - 5000.0) * 0.1;
         else commission = salesAmount * 0.08;

        return commission;
    }


}
