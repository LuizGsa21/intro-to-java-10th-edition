package Chapter_06;

/**
 * Chapter 6 Exercise 32:
 *
 *  Game: chance of winning at craps)
 *  Revise Exercise 6.30 to run it 10,000 times
 *  and display the number of winning games
 *
 * Created by Luiz Arantes Sa on 8/26/14.
 */
public class Exercise_32 {

    public static void main(String[] args) {

        int wins = 0;
        for (int i = 0; i < 10000; i++) {
            int roll1 = rollDie();
            int roll2 = rollDie();
            if (getStats(roll1 + roll2).equals("You win.")) {
                wins++;
            }
        }

        System.out.println("The total number of wins: " + wins);

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
