package Chapter_06;

import java.util.Random;

/**
 * Chapter 6 Exercise 30:
 *
 *      (Game: craps) Craps is a popular dice game played in casinos. Write a program
 *      to play a variation of the game, as follows:
 *      Roll two dice. Each die has six faces representing values
 *      1, 2, ..., and 6, respectively. Check the sum of the two dice.
 *      If the sum is 2, 3, or 12 (called craps), you lose; if the sum is 7 or 11 (called natural),
 *      you win; if the sum is another value (i.e., 4, 5, 6, 8, 9, or 10), a point is established.
 *      Continue to roll the dice until either a 7 or the same point value is rolled.
 *      If 7 is rolled, you lose. Otherwise, you win.
 *
 * Created by Luiz Arantes Sa on 8/26/14.
 */
public class Exercise_30 {

    public static void main(String[] args) {

        int roll1 = rollDie();
        int roll2 = rollDie();
        System.out.println("You rolled " + roll1 + " + " + roll2 + " = " + (roll1 + roll2));
        System.out.println(getStats(roll1 + roll2));
    }

    public static String getStats(int n) {

        if (n == 7 || n == 11) return "You win.";
        if (n == 2 || n == 3 || n == 12) return "You lose.";

        return "point is " + n;

    }

    public static int rollDie() {

        return (int) (Math.random() * 6 + 1);
    }
}
