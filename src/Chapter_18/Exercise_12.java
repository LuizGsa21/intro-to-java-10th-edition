package Chapter_18;

import java.util.Scanner;

/**
 * (Print the characters in a string reversely)
 * Rewrite Programming Exercise 18.9 using a helper method
 * to pass the substring high index to the method.
 * The helper method header is:
 *
 * public static void reverseDisplay(String value, int high)
 *
 * Created by Luiz Arantes Sa on 12/2/14.
 */
public class Exercise_12 {

    public static void main(String[] args) {

        System.out.print("Enter a string: ");
        String s = new Scanner(System.in).nextLine();
        reverseDisplay(s);

    }

    private static void reverseDisplay(String s) {
        reverseDisplay(s, s.length());
    }

    private static void reverseDisplay(String s, int high) {
        if (high == 0)
            return;
        System.out.print(s.substring(high - 1));
        reverseDisplay(s.substring(0, high - 1));
    }
}
