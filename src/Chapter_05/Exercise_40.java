package Chapter_05;

/**
 * Chapter 5 Exercise 40:
 *
 *      (Simulation: heads or tails)
 *      Write a program that simulates flipping a coin
 *      one million times and displays the number of heads and tails.
 *
 * Created by Luiz Arantes Sa on 8/24/14.
 */
public class Exercise_40 {

    public static void main(String[] strings) {
        int tails = 0;
        int heads = 0;
        for (int i = 0; i < 1000000; i++) {

            int flip = (int) (Math.random() * 2);
            if (flip == 1) {
                heads++;
            } else
                tails++;
        }
        System.out.println("Heads: " + heads + " Tails: " + tails);
    }
}
