package Chapter_02;

import java.util.Scanner;

/**
 * Chapter 2 Exercise 4:
 *
 *      (Convert pounds into kilograms) Write a program that converts pounds into kilo- grams.
 *      The program prompts the user to enter a number in pounds, converts it to kilograms,
 *      and displays the result. One pound is 0.454 kilograms.
 *
 * Created by Luiz Arantes Sa on 8/23/14.
 */
public class Exercise_04 {

    public static void main(String[] Strings) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number in pounds: ");

        double pounds = input.nextDouble();
        double kilograms = pounds * 0.454;

        System.out.println(pounds + " pounds is " + kilograms + " kilograms.");
    }
}
