package Chapter_13;

import ToolKit.BigRational;
import ToolKit.Rational;

import java.math.BigDecimal;

/**
 * Chapter 13 Exercise 18:
 *
 *      (Use the Rational class)
 *      Write a program that computes the following
 *      summation series using the Rational class:
 *
 *      You will discover that the output is incorrect because of integer overflow (too large).
 *      To fix this problem, see Programming Exercise 13.15.
 *
 * Created by Luiz Arantes Sa on 9/11/14.
 */
public class Exercise_18 {


    public static void main(String[] args) {

        // using rational class
        Rational total = new Rational();
        for (int i = 1; i < 100; i++) {
            total = total.add(new Rational(i, i + 1));
            if (i < 10) {
                System.out.println("total = " + total);
            }

        }
        System.out.println(total + " = " + total.doubleValue());

        // using BigRational class
        BigRational r = new BigRational( BigDecimal.ZERO, new BigDecimal(1));

        for (int i = 1; i < 100; i++) {
            r = r.add(new BigRational(new BigDecimal(i), new BigDecimal(i + 1)));
            if (i < 10) {
                System.out.println("r = " + r);
            }

        }
        System.out.println("BigRational total = " + r);
        System.out.println("BigRational decimal form = " + r.bigDecimalDouble());
    }

}
