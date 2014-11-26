package Chapter_10;

import java.math.BigDecimal;

/**
 * Chapter 10 Exercise 19:
 *
 *      (Mersenne prime) A prime number is called a Mersenne prime
 *      if it can be writ- ten in the form 2p - 1 for some positive integer p.
 *      Write a program that finds all Mersenne primes with p … 100 and displays
 *      the output as shown below. (Hint: You have to use BigInteger to store the number,
 *      because it is too big to be stored in long. Your program may take several hours to run.)"
 *
 * Created by Luiz Arantes Sa on 9/6/14.
 */
public class Exercise_19 {

    public static void main(String[] args) {

        System.out.printf("%-10s%7s\n", "P", "2 * P -1");
        int numberOfPrimes = 0;
        for (int i = 2; numberOfPrimes < 100; i++) {
            if (isPrime(i)) {
                numberOfPrimes++;
                System.out.printf("%-10d%-10s\n", i, getMersennePrime(i));
            }
        }

    }

    public static boolean isPrime(long n) {

        long square = (long) Math.sqrt(n);
        for (int i = 2; i <= square; i++) {

            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static BigDecimal getMersennePrime(int p) {

        return new BigDecimal(2).pow(p).subtract(BigDecimal.ONE);
    }
}
