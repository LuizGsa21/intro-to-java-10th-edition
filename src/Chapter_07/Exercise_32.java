package Chapter_07;

import ToolKit.Kit;

import java.util.Scanner;

/**
 * Chapter 7 Exercise 32:
 *
 *      (Partition of a list) Write the following method that partitions the list
 *       using the first element, called a pivot.
 *
 *            public static int partition(int[] list)
 *
 *       After the partition, the elements in the list are rearranged so that all the elements before
 *       the pivot are less than or equal to the pivot and the elements after the pivot are greater than the pivot.
 *       The method returns the index where the pivot is located in the new list. For example, suppose the
 *       list is {5, 2, 9, 3, 6, 8}. After the partition, the list becomes {3, 2, 5, 9, 6, 8}.
 *       Implement the method in a way that takes at most list.length comparisons.
 *       Write a test program that prompts the user to enter a list and displays the list after the partition.
 *       Here is a sample run. Note that the first number in the input indicates the number of
 *       the elements in the list. This number is not part of the list.
 *
 *       Created by Luiz Arantes Sa on 8/29/14.
 */
public class Exercise_32 {


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("First number = size of array, second number = pivot ");
        System.out.print("Enter a list:");
        int size = input.nextInt();
        int[] list = new int[size];
        for (int i = 0; i < size; i++) list[i] = input.nextInt();

        partition(list);
        Kit.displayGrid(list);


    }

    public static int partition(int[] list) {

        int first = 0;
        int low = first + 1;
        int high = list.length - 1;
        int pivot = list[first];

        while (high > low) {

            while (low <= high && list[low] <= pivot) low++;
            while (low <= high && list[high] > pivot) high--;

            if (high > low) {
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }

        while (high >= low && list[high] >= pivot) high--;

        if (high > first) {
            int temp = list[high];
            list[high] = list[first];
            list[first] = temp;
            return high;
        } else {
            return first;
        }


    }




}
