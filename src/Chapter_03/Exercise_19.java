package Chapter_03;

import java.util.Scanner;

/**
 * Chapter 3 Exercise 19:
 *
 *      (Compute the perimeter of a triangle)
 *
 * Created by Luiz Arantes Sa on 6/22/14.
 */
public class Exercise_19 {

    public static void main(String[] strings) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter 3 edge lengths of a triangle: ");
        double side1 = input.nextDouble();
        double side2 = input.nextDouble();
        double side3 = input.nextDouble();

        boolean isTriangle = ((side1 + side2 > side3) &&
                (side1 + side3 > side2) &&
                (side3 + side2 > side1));

        if (isTriangle) {
            double perimeter = side1 + side2 + side3;
            System.out.println("You entered a real triangle with the perimeter of " + perimeter + ".");
        } else {
            System.out.println("Your input is not a valid triangle.");
        }
    }
}
