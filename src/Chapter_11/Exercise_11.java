package Chapter_11;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Chapter 11 Exercise 11:
 *
 *      (Sort ArrayList) Write the following method that sorts an ArrayList of
 *      numbers:
 *      public static void sort(ArrayList<Integer> list)
 *      Write a test program that prompts the user to enter 5 numbers, stores them in an
 *      array list, and displays them in increasing order.
 *
 * Created by Luiz Arantes Sa on 9/8/14.
 */
public class Exercise_11 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter 5 numbers: ");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) list.add(input.nextInt());

        System.out.println("Sorting numbers...");
        sort(list);
        System.out.println("Displaying numbers...");
        System.out.println(list);

    }

    public static void sort(ArrayList<Integer> list) {

        // simple solution
        //list.sort(null);

        // manual solution
        for (int i = 0; i < list.size() - 1; i++) {
            int currentMin = list.get(i);
            int currentIndex = i;

            for (int j = i + 1; j < list.size(); j++) {
                if (currentMin > list.get(j)) {
                    currentMin = list.get(j);
                    currentIndex = j;
                }
            }

            if (currentIndex != i) {
                list.set(currentIndex, list.get(i));
                list.set(i, currentMin);
            }
        }

    }
}
