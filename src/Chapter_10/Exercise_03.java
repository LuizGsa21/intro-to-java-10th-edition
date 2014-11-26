package Chapter_10;

import ToolKit.MyInteger;

/**
 * Chapter 10 Exercise 3:
 *
 *      (The MyInteger class) Design a class named MyInteger. The class contains:
 *
 *      ■ An int data field named value that stores the int value represented by this object.
 *      ■ A constructor that creates a MyInteger object for the specified int value.
 *      ■ A getter method that returns the int value.
 *      ■ The methods isEven(), isOdd(), and isPrime() that return true if the value in this object is even, odd, or prime, respectively.
 *      ■ The static methods isEven(int), isOdd(int), and isPrime(int) that return true if the specified value is even, odd, or prime, respectively.
 *      ■ The static methods isEven(MyInteger), isOdd(MyInteger), and isPrime(MyInteger) that return true if the specified value is even, odd, or prime, respectively.
 *      ■ The methods equals(int) and equals(MyInteger) that return true if the value in this object is equal to the specified value.
 *      ■ A static method parseInt(char[]) that converts an array of numeric characters to an int value.
 *      ■ A static method parseInt(String) that converts a string into an int value.
 *
 *      Draw the UML diagram for the class and then implement the class. Write a client program that tests all methods in the class.
 * Created by Luiz Arantes Sa on 9/2/14.
 */
public class Exercise_03 {

    public static void main(String[] args) {

        MyInteger num1 = new MyInteger(7);
        MyInteger num2 = new MyInteger(7);
        MyInteger num3 = new MyInteger(25);

        System.out.printf("Number 1 = %d isPrime: %b isOdd: %b isEven %b\n",
                num1.getValue(), num1.isPrime(), num1.isOdd(), num1.isEven());

        System.out.printf("Number 2 = %d isPrime: %b isOdd: %b isEven %b\n",
                num2.getValue(), num2.isPrime(), num2.isOdd(), num2.isEven());
        System.out.printf("Number 3 = %d isPrime: %b isOdd: %b isEven %b\n",
                num3.getValue(), num3.isPrime(), num3.isOdd(), num3.isEven());

        System.out.printf("Num 1 == Num 2: %b\n", num1.equals(num2));
        System.out.printf("Num 1 == Num 3: %b\n", num1.equals(num3));
        System.out.printf("Parse int 100 string value == %d\n", MyInteger.parseInt("100"));
        System.out.printf("Parse int 150 char array value == %d\n", MyInteger.parseInt("150".toCharArray()));

    }
}
