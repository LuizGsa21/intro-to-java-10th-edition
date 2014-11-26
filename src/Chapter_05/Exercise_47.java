package Chapter_05;

import java.util.Scanner;

/**
 * Chapter 5 Exercise 47:
 *
 *      (Business: check ISBN-13) ISBN-13 is a new standard for identifying books.
 *      It uses 13 digits d1d2d3d4d5d6d7d8d9d10d11d12d13. The last digit d13 is a checksum,
 *      which is calculated from the other digits using the following formula:
 *      10-(d1 +3d2 +d3 +3d4 +d5 +3d6 +d7 +3d8 +d9 +3d10 +d11 +3d12)%10
 *      If the checksum is 10, replace it with 0. Your program should read the input as a string.
 *
 * Created by Luiz Arantes Sa on 8/24/14.
 */
public class Exercise_47 {

    public static void main(String[] strings) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the first 12 digits of an ISBN as string: ");
        String s = input.next();

        if (s.length() != 12) {
            System.out.println(s + " is Invalid input");
            System.exit(0);
        }

        int checkSum = 0;
        for (int i = 0; i < s.length(); i++) {

            if ((i + 1) % 2 == 0) {
                checkSum +=  (s.charAt(i) - '0') * 3;

            } else {
                checkSum  += s.charAt(i) - '0';
            }
        }
        checkSum %= 10;
        checkSum = 10 - checkSum;
        if (checkSum == 10) s += "0";
        else  s += checkSum;

        System.out.println("The ISBN-13 number is " + s);
    }
}
