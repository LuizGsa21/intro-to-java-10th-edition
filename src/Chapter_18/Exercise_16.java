package Chapter_18;

import java.util.Scanner;

/**
 * (Find the number of uppercase letters in an array)
 * Write a recursive method to return the number of uppercase letters
 * in an array of characters. You need to define the following two methods.
 * The second one is a recursive helper method.
 *
 *  public static int count(char[] chars)
 *  public static int count(char[] chars, int high)
 *
 *  Write a test program that prompts the user to enter a list
 *  of characters in one line and displays the number of
 *  uppercase letters in the list.
 *
 * Created by Luiz Arantes Sa on 12/2/14.
 */
public class Exercise_16 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = input.nextLine();

        System.out.println("The number of uppercase letters = " + count(s.toCharArray()));
    }

    public static int count(char[] chars) {

        return count(chars, chars.length - 1);
    }

    public static int count(char[] chars, int high) {

        int count = Character.isUpperCase(chars[high]) ? 1 : 0;
        if (high == 0)
            return count;
        else
            return count + count(chars, high - 1);

    }
}
