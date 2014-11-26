package Chapter_04;

import java.util.Scanner;

/**
 * Chapter 4 Exercise 24:
 *
 *      (Order three cities)
 *      Write a program that prompts the user to
 *      enter three cities and displays them in ascending order.
 *
 *      NOTE: Can't use sort() method or any type of arrays
 *
 * Created by Luiz Arantes Sa on 8/23/14.
 */
public class Exercise_24 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first city: ");
        String s1 = input.nextLine();
        System.out.print("Enter the second city: ");
        String s2 = input.nextLine();
        System.out.print("Enter the third city: ");
        String s3 = input.nextLine();
        input.close();

        // NOTE: For the purpose of this assignment, I'm not using an ArrayList/Array
        String temp;
        if (s1.compareTo(s2) > 0) {
            temp = s1;
            s1 = s2;
            s2 = temp;
        }
        if (s2.compareTo(s3) > 0) {
            temp = s2;
            s2 = s3;
            s3 = temp;
        }
        if (s1.compareTo(s2) > 0) {
            temp = s1;
            s1 = s2;
            s2 = temp;
        }

        System.out.println("The three cities in alphabetical order are: ");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

    }
}
