package Chapter_03;

import java.util.Scanner;

/**
 * Chapter 3 Exercise 26:
 *
 *      (Use the &&, || and ^ operators)
 *
 * Created by Luiz Arantes Sa on 6/22/14.
 */
public class Exercise_26 {

    public static void main(String[] strings) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int number = input.nextInt();

        boolean isDivByFiveAndSix = (number % 5 == 0) && (number % 6 == 0);
        boolean isDivByFiveOrSix = (number % 5 == 0) || (number % 6 == 0);
        boolean isDivByFiveOrSixButNotBoth = (number % 5 == 0) ^ (number % 6 == 0);

        System.out.println("Is " + number + " divisible by 5 and 6? " + isDivByFiveAndSix);
        System.out.println("Is " + number + " divisible by 5 or 6? " + isDivByFiveOrSix);
        System.out.println("Is " + number + " divisible by 5 or 6, but not both? " + isDivByFiveOrSixButNotBoth);
    }
}
