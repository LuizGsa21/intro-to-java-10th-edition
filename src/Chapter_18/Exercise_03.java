package Chapter_18;

import java.util.Scanner;

/**
 * (Compute greatest common divisor using recursion)
 *
 *  Write a recursive method to find the GCD. Write a test
 *  program that prompts the user to enter two integers and
 *  displays their GCD.
 *
 * Created by Luiz Arantes Sa on 12/1/14.
 */
public class Exercise_03 {

    public static void main(String[] args) {
        System.out.println("Enter two integers: ");
        Scanner input = new Scanner(System.in);
        int n1 = input.nextInt();
        int n2 = input.nextInt();

        System.out.println("The GCD is " + gcd(n1,n2));

    }

    private static int gcd(int n1, int n2) {
        if (n1 % n2 == 0)
            return n2;
        else
            return gcd(n2, n1 % n2);
    }

}
