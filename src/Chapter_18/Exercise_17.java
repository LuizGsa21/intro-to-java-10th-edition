package Chapter_18;

import java.util.Scanner;

/**
 * (Occurrences of a specified character in an array)
 * Write a recursive method that finds the number of occurrences
 * of a specified character in an array. You need to define the
 * following two methods. The second one is a recursive helper method.
 *
 * public static int count(char[] chars, char ch)
 * public static int count(char[] chars, char ch, int high)
 *
 * Write a test program that prompts the user to enter a list of characters in one line,
 * and a character, and displays the number of occurrences of the character in the list.
 *
 * Created by Luiz Arantes Sa on 12/2/14.
 */
public class Exercise_17 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a list of characters in one line: ");
        String s = input.nextLine();
        System.out.print("Enter a character: ");
        char ch = input.next().charAt(0);

        char[] chars = s.replaceAll(" ", "").toCharArray();
        System.out.println("The occurrences of '" + ch + "' in \"" + s + "\" = " + count(chars, ch));
    }

    private static int count(char[] chars, char ch) {
        return count(chars, ch, chars.length - 1);
    }

    private static int count(char[] chars, char ch, int high) {

        int count = (chars[high] == ch) ? 1 : 0;

        if (high == 0)
            return count;
        else
            return count + count(chars, ch, high - 1);
    }

}
