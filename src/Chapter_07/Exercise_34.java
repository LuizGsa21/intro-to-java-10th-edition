package Chapter_07;

import ToolKit.Kit;

import java.util.Scanner;

/**
 * Chapter 7 Exercise 34:
 *
 *      (Sort characters in a string)
 *      Write a method that returns a sorted string using the following header:
 *
 *      public static String sort(String s)
 *
 *      For example, sort("acb") returns abc.
 *      Write a test program that prompts the user to enter a string and displays the sorted string.
 *
 * Created by Luiz Arantes Sa on 8/29/14.
 *
 */
public class Exercise_34 {

    public static void main(String[] args) {

        System.out.print("Enter a string: ");
        Scanner input = new Scanner(System.in);
        String s = input.next();
        System.out.println(sort(s));
    }

    public static String sort(String s) {

        StringBuilder temp = new StringBuilder(s);

        for (int i = 0; i < temp.length() - 1; i++) {

            int currentIndex = i;
            char currentMin = temp.charAt(i);

            for (int k = i + 1; k < temp.length(); k++) {

                if (currentMin > temp.charAt(k)) {
                    currentMin = temp.charAt(k);
                    currentIndex = k;
                }

            }

            if (currentIndex != i) {
                char tempChar = temp.charAt(i);
                temp = temp.deleteCharAt(i);
                temp = temp.insert(i, currentMin);
                temp = temp.deleteCharAt(currentIndex);
                temp = temp.insert(currentIndex, tempChar);
            }
        }

        return temp.toString();
    }


}
