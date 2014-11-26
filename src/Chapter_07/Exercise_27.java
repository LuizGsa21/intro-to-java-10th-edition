package Chapter_07;

import java.util.Scanner;

/**
 * Chapter 7 Exercise 27:
 *
 *      (Strictly identical arrays)
 *      The arrays list1 and list2 are strictly identical if
 *      their corresponding elements are equal. Write a method
 *      that returns true if list1 and list2 are strictly identical,
 *      using the following header:
 *
 *      public static boolean equals(int[] list1, int[] list2)
 *
 *      Write a test program that prompts the user to enter two lists of
 *      integers and displays whether the two are strictly identical.
 *      Here are the sample runs. Note that the first number in the input
 *      indicates the number of the elements in the list.
 *      This number is not part of the list.
 *
 * Created by Luiz Arantes Sa on 8/28/14.
 */
public class Exercise_27 {


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter list1: ");
        int size = input.nextInt();

        int[] list1 = new int[size];
        for (int i = 0; i < size; i++) list1[i] = input.nextInt(); // save input to array

        System.out.print("Enter list2: ");
        size = input.nextInt();

        int[] list2 = new int[size];
        for (int i = 0; i < size; i++) list2[i] = input.nextInt(); // save input to array

        if (equals(list1, list2)) {
            System.out.println("Two lists are strictly identical");
        } else {
            System.out.println("Two lists are not strictly identical");
        }



    }

    public static boolean equals(int[] list1, int[] list2) {

        if (list1.length != list2.length) return false;


        for (int i = 0; i < list1.length; i++) {
            if (list1[i] != list2[i]) return false;
        }

        return true;
    }
}
