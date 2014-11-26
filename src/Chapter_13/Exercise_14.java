package Chapter_13;

import ToolKit.Rational;

/**
 * Chapter 13 Exercise 14:
 *
 *  (Demonstrate the benefits of encapsulation)
 *      Rewrite the Rational class in Listing 13.13 using a new internal
 *      representation for the numerator and denomina- tor. Create an array
 *      of two integers as follows:
 *      private long[] r = new long[2];
 *      Use r[0] to represent the numerator and r[1] to represent the denominator.
 *      The signatures of the methods in the Rational class are not changed, so a client
 *      application that uses the previous Rational class can continue to use this new Rational
 *      class without being recompiled.
 *
 * Created by Luiz Arantes Sa on 9/10/14.
 */
public class Exercise_14 {

    public static void main(String[] args) {

        Rational rational = new Rational(4, 10);
        rational = rational.multiply(new Rational(2, 4));
        System.out.println(rational);
    }
}
