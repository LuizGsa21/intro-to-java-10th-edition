package Chapter_09;

import java.util.Random;

/**
 * Chapter 9 Exercise 4:
 *
 *      (Use the Random class)
 *      Write a program that creates a Random object with seed 1000
 *      and displays the first 50 random integers between 0 and 100
 *      using the nextInt(100) method.
 *
 * Created by Luiz Arantes Sa on 9/1/14.
 */
public class Exercise_04 {

    public static void main(String[] args) {

        Random random = new Random(1000);

        for (int i = 0; i < 50; i++) {

            System.out.printf("%3d ", random.nextInt(101)); // displays 1-99
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }


    }


}
