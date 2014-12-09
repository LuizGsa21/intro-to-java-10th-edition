package Chapter_18;

import java.util.Scanner;

/**
 * (String permutation)
 * Write a recursive method to print all the permutations of a
 * string. For example, for the string abc, permutation is:
 *  abc
 *  acb
 *  bac
 *  bca
 *  cab
 *  cba
 * Created by Luiz Arantes Sa on 12/7/14.
 */
public class Exercise_25 {

    public static void main(String[] args) {

        System.out.print("Enter a string: ");
        String s = new Scanner(System.in).next();
        System.out.println("All possible permutations of " + s + " are: ");

        displayPermutation(s);
    }

    public static void displayPermutation(String s) {
        displayPermutation("", s);
    }

    public static void displayPermutation(String s1, String s2) {

        if (s2.length() == 0) {
            System.out.println(s1);
        } else {
            for (int i = 0; i < s2.length(); i++) {
                displayPermutation(s1 + s2.charAt(i), s2.substring(0, i) + s2.substring(i + 1));
            }
        }
    }

}
