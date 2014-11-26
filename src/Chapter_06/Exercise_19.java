package Chapter_06;

import java.util.Scanner;

/**
 * Chapter 6 Exercise 19:
 *
 *     (The MyTriangle class) Create a class named MyTriangle
 *     that contains the following two methods:
 *
 * Created by Luiz Arantes Sa on 8/26/14.
 */
public class Exercise_19 {


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter 3 sides of a triangle: ");
        double s1 = input.nextDouble();
        double s2 = input.nextDouble();
        double s3 = input.nextDouble();

        if (MyTriangle.isValid(s1, s2, s3)) {
            System.out.println("This is a triangle! area = " + MyTriangle.area(s1, s2, s3));
        } else {
            System.out.println("Sorry, you entered an invalid triangle...");
        }
    }


}
