package Chapter_13;

import ToolKit.Complex;

/**
 * Chapter 13 Exercise 17:
 *
 *      (Math: The Complex class)
 *      A complex number is a number in the form a + bi, where a and b are real
 *      numbers and i is 2-1. The numbers a and b are known as the real part and
 *      imaginary part of the complex number, respectively. You can perform addition,
 *      subtraction, multiplication, and division for complex numbers using the following
 *
 *      (A complex number can be interpreted as a point on a plane by identifying the (a,b)
 *      values as the coordinates of the point. The absolute value of the complex number corresponds
 *      to the distance of the point to the origin, as shown in Figure 13.10b.)
 *      Design a class named Complex for representing complex numbers and the methods add, subtract,
 *      multiply, divide, and abs for performing complex- number operations, and override toString
 *      method for returning a string repre- sentation for a complex number. The toString method returns (a + bi) as a string. If b is 0, it simply returns a. Your Complex class should also implement the Cloneable interface.
 *      Provide three constructors Complex(a, b), Complex(a), and Complex(). Complex() creates a
 *      Complex object for number 0 and Complex(a) cre- ates a Complex object with 0 for b. Also
 *      provide the getRealPart() and getImaginaryPart() methods for returning the real and imaginary
 *      part of the complex number, respectively.
 *      Write a test program that prompts the user to enter two complex numbers and displays the
 *      result of their addition, subtraction, multiplication, division, and abso- lute value.
 *
 * Created by Luiz Arantes Sa on 9/11/14.
 */
public class Exercise_17 {

    public static void main(String[] args) {

        System.out.println(new Complex(3.5, 5.5).add(new Complex(-3.5, 1)));
        System.out.println(new Complex(3.5, 5.5).subtract(new Complex(-3.5, 1)));

        // This output is correct... http://www.mathsisfun.com/numbers/complex-number-calculator.html
        System.out.println(new Complex(3.5, 5.5).multiply(new Complex(-3.5, 1)));
        System.out.println(new Complex(3.5, 5.5).divide(new Complex(-3.5, 1)));




    }


}
