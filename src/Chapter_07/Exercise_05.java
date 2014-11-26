package Chapter_07;

import java.util.Scanner;

/**
 * Chapter 7 Exercise 5:
 *
 *      (Print distinct numbers)
 *      Write a program that reads in ten numbers and displays the number
 *      of distinct numbers and the distinct numbers separated by exactly
 *      one space (i.e., if a number appears multiple times, it is displayed only once).
 *      (Hint: Read a number and store it to an array if it is new.
 *      If the number is already in the array, ignore it.) After the input,
 *      the array contains the distinct numbers.
 *
 * Created by Luiz Arantes Sa on 8/27/14.
 */
public class Exercise_05 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int[] numbers = new int[10];
        int index = 0;
        System.out.print("Enter ten numbers: ");


        for (int i = 0; i < numbers.length; i++) {
            int num = input.nextInt();

            if (isNew(numbers, num)) {
                numbers[index++] = num;
            }
        }
        System.out.println("The number of distinct number is " + index);
        System.out.print("The distinct numbers are: ");
        for (int i = 0; i < index; i++) {
            System.out.print(numbers[i] + " ");
        }
    }

    public static boolean isNew(int[] numbers, int n) {

        for (int i : numbers){
            if (n == i) return false;
        }
        return true;
    }






}
