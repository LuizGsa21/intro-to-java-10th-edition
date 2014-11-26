package Chapter_11;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Chapter 11 Exercise 13:
 *
 *      (Remove duplicates) Write a method that removes the duplicate elements from
 *      an array list of integers using the following header:
 *      public static void removeDuplicate(ArrayList<Integer> list)
 *      Write a test program that prompts the user to enter 10 integers to a list and displays
 *      the distinct integers separated by exactly one space.
 *
 * Created by Luiz Arantes Sa on 9/8/14.
 */
public class Exercise_13 {

    public static void main(String[] args) {

        System.out.print("Enter 10 integers: ");
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) list.add(input.nextInt());

        System.out.println("Removing duplicates...");
        removeDuplicate(list);
        System.out.println("Displaying list...");
        System.out.println(list);
    }

    public static void removeDuplicate(ArrayList<Integer> list) {

        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {

            if (!temp.contains(list.get(i))) {
                temp.add(list.get(i));
            }
        }
        list.clear();
        list.addAll(temp);

    }
}
