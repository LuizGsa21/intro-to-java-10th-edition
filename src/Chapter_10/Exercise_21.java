package Chapter_10;

import java.math.BigDecimal;

/**
 * Chapter 10 Exercise 21:
 *
 *      (Divisible by 5 or 6) Find the first ten numbers greater than Long.MAX_VALUE"
 *      "that are divisible by 5 or 6."
 *      "Sections 10.10–10.11"
 *
 * Created by Luiz Arantes Sa on 9/6/14.
 */
public class Exercise_21 {

    public static void main(String[] args) {

        int count = 0;
        BigDecimal num = new BigDecimal(Long.MAX_VALUE).add(BigDecimal.ONE);
        while (count < 10) {

            if (num.remainder(new BigDecimal(5)).equals(BigDecimal.ZERO) ||
                num.remainder(new BigDecimal(6)).equals(BigDecimal.ZERO)) {
                count++;
                System.out.println(count+ ": " +num);
            }
            num = num.add(BigDecimal.ONE);
        }
    }
}
