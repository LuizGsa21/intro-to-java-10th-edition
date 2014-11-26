package Chapter_04;

import java.util.Scanner;

/**
 * Chapter 4 Exercise 21:
 *
 *      (Check SSN) Write a program that prompts the user to enter a
 *      Social Security number in the format DDD-DD-DDDD, where D is a digit.
 *      Your program should check whether the input is valid.
 *
 * Created by Luiz Arantes Sa on 8/23/14.
 */
public class Exercise_21 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Format: DDD-DD-DDDD");
        System.out.print("Enter SSN: ");
        String s = input.nextLine();
        input.close();

        if (isSSNValidFormat(s)) {
            System.out.println(s + " is a valid social security number.");
        } else {
            System.out.println(s + " is a INVALID social security number.");
        }
    }

    public static boolean isSSNValidFormat(String s) {

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            if (i == 3 && ch != '-') return false;
            if (i == 6 && ch != '-') return false;
            if (i != 6 && i != 3 && !Character.isDigit(ch)) return false;
        }
        return true;

    }
}
