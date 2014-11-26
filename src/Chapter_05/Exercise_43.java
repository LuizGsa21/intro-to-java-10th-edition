package Chapter_05;

import java.util.Scanner;

/**
 * Chapter 5 Exercise 43:
 *
 *      (Math: combinations) Write a program that displays all possible combinations
 *      for picking two numbers from integers 1 to 7. Also display
 *      the total number of all combinations.
 *
 * Created by Luiz Arantes Sa on 8/24/14.
 */
public class Exercise_43 {

    public static void main(String[] strings) {

        int counter = 0;
        for (int i = 1; i < 8; i++){
            for (int j = i + 1; j < 8; j++) {
                System.out.println(i + " " + j);
                counter++;
            }
        }

        System.out.println("Total combination: " + counter);
    }
}
