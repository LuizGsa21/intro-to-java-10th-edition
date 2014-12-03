package Chapter_18;

import java.util.Scanner;

/**
 * (Occurrences of a specified character in a string)
 * Rewrite Programming Exercise 18.10 using a helper method
 * to pass the substring high index to the method.
 * The helper method header is:
 *
 * public static int count(String str, char a, int high)
 *
 * Created by Luiz Arantes Sa on 12/2/14.
 */
public class Exercise_15 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = input.next();
        char ch = input.next().charAt(0);
        System.out.println(count(str, ch));

    }

    public static int count(String s, char ch) {
        return count(s, ch, s.length() - 1);
    }

    public static int count(String s, char ch, int high) {
        int n =  (ch == s.charAt(0)) ? 1 : 0;
        if (high <= 0)
            return n;
        return n + count(s.substring(1), ch, high - 1);
    }
}
