package Chapter_06;

/**
 * Chapter 6 Exercise 28:
 *
 *
 *      (Mersenne prime) A prime number is called a Mersenne prime if it can be
 *      written in the form 2p - 1 for some positive integer p.
 *      Write a program that finds all Mersenne primes
 *      with p <= 31 p 2^p –1
 * Created by Luiz Arantes Sa on 8/26/14.
 */
public class Exercise_28 {

    public static void main(String[] args) {

        System.out.printf("%-10s%7s\n", "P", "2 * P -1");
        for (int i = 2; i <= 31; i++) {
            if (isPrime(i)) {
                System.out.printf("%-10d%-10d\n", i, getMersennePrime(i));
            }
        }
    }

    public static boolean isPrime(long n) {

        if (n < 2) return false;

        for (int i = 2; i <= n / 2; i++) {

            if (n % i == 0) return false;
        }

        return true;
    }

    public static int getMersennePrime(int p) {

        return (int)Math.pow(2, p) - 1;
    }
}
