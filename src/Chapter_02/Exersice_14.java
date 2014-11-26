package Chapter_02;

import java.util.Scanner;

/**
 * Chapter 2 Exercise 14:
 *      (Health application: computing BMI)
 * Created by Luiz Arantes Sa on 6/20/14.
 */
public class Exersice_14 {

    public static void main(String[] Strings) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter weight in pounds: ");
        double weight = input.nextDouble();

        System.out.print("Enter height in inches: ");
        double inches = input.nextDouble();

        double bmi = weight * 0.45359237 / (inches * 0.0254 * inches * 0.0254);
        System.out.print("BMI is " + bmi);
    }
}
