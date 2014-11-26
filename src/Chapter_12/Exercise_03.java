package Chapter_12;

import java.util.Scanner;

/**
 * Chapter 12 Exercise 3:
 *
 *  (ArrayIndexOutOfBoundsException) Write a program that meets the fol- lowing requirements:
 *      ■ Creates an array with 100 randomly chosen integers.
 *      ■ Prompts the user to enter the index of the array, then displays the corresponding
 *          element value. If the specified index is out of bounds, display the message Out of Bounds.
 *
 * Created by Luiz Arantes Sa on 9/8/14.
 */
public class Exercise_03 {

    public static void main(String[] args) {

        // creating an array with 100 random integers
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100);
        }
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an index: ");
        try {
            int index = input.nextInt();
            System.out.println("array[" + index + "] = " + array[index]);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("INDEX " + ex.getLocalizedMessage() + " is out of bounds");
        } catch (Exception ex) {
            System.out.println("INVALID INPUT");
        }
    }
}
