package Chapter_05;

/**
 * Chapter 5 Exercise 13:
 *
 *      (Find the largest n such that n3 6 12,000)
 *      Use a while loop to find the largest integer n, such that n^3 is less than 12,000.
 * Created by Luiz Arantes Sa on 8/24/14.
 */
public class Exercise_13 {

    public static void main(String[] args) {

        int n = 0;

        while (Math.pow(n, 3) < 12000) {
            n++;
        }
        n--;
        System.out.println(n + " is the largest integer n, such that n^3 is less than 12,000");
        System.out.println("Proof: " + (n - 1) + "^3 = " + Math.pow(n - 1, 3));
        System.out.println("Proof: " + n + "^3 = " + Math.pow(n, 3));
        System.out.println("Proof: " + (n + 1) + "^3 = " + Math.pow(n + 1, 3));


    }
}
