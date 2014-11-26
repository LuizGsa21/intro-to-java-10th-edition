package Chapter_05;

import java.util.Scanner;

/**
 * Chapter 5 Exercise 16:
 *
 *      (Find the factors of an integer)
 *      Write a program that reads an integer and displays all its smallest
 *      factors in increasing order. For example, if the input integer is 120,
 *      the output should be as follows: 2, 2, 2, 3, 5.
 * Created by Luiz Arantes Sa on 8/24/14.
 */
public class Exercise_16 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter first integer number: ");
        int num = input.nextInt();
        input.close();

        for (int i = 2; i < num; ) {

            if (num % i == 0) {
                System.out.print(i +" ");
                num /= i;
            } else {
                i++;
            }
        }
    }
}
