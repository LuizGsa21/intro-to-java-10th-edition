package Chapter_13;

import ToolKit.BigRational;

import java.math.BigDecimal;

/**
 * Chapter 13 Exercise 15:
 *
 *      (Use BigInteger for the Rational class)
 *      Redesign and implement the Rational class in Listing 13.13 using BigInteger for
 *      the numerator and denominator.
 *
 * Created by Luiz Arantes Sa on 9/10/14.
 */
public class Exercise_15 {

    public static void main(String[] args) {

        BigRational bigRational = new BigRational(new BigDecimal(4), new BigDecimal(8));
        System.out.println(bigRational);
        bigRational = bigRational.multiply(bigRational);
        System.out.println(bigRational);
    }


}


