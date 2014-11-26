package Chapter_03;

/**
 * Chapter 3 Exercise 16:
 *
 *      (Random point) Write a program that displays a random coordinate in a rectangle.
 *      The rectangle is centered at (0, 0) with width 100 and height 200.
 *
 * Created by Luiz Arantes Sa on 6/22/14.
 */
public class Exercise_16 {

    public static void main(String[] strings) {

        int x = (int) getRandomNPR(51);
        int y = (int) getRandomNPR(100);

        System.out.println("(" + x + "," + y + ")");

    }

    /**
     * NPR - negative and positive range
     * @return a random number, r, in the range -n < r < n
     */
    public static double getRandomNPR(double n) {
        return Math.random() * n * 2 - n ;
    }

}
