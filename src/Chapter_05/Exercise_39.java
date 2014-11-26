package Chapter_05;

/**
 * Chapter 5 Exercise 39:
 *
 *      (Financial application: find the sales amount)
 *
 * Created by Luiz Arantes Sa on 8/24/14.
 */
public class Exercise_39 {

    public static void main(String[] strings) {

        double commission;
        double salesAmount = 0.01;
        do
        {
            salesAmount += 0.01;

            if (salesAmount >= 10000.01) {
                commission = 900.0 + (salesAmount - 10000.0) * 0.12;
            } else if (salesAmount >= 5000.01) {
                commission = 400.0 + (salesAmount - 5000.0) * 0.1;
            } else {
                commission = salesAmount * 0.08;
            }
        } while (commission < 25000.0);

        System.out.println("You need $" + (int)(salesAmount * 100.0) / 100.0 +
                " sales amount to make a commission of $25000");
    }

}
