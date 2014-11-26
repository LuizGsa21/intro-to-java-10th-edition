package Chapter_10;

import ToolKit.StopWatch;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Chapter 10 Exercise 18:
 * <p>
 * (Large prime numbers)
 * Write a program that finds five prime numbers larger than Long.MAX_VALUE.
 * <p>
 * Created by Luiz Arantes Sa on 9/5/14.
 */
public class Exercise_18 {

    private static ArrayList<Long> primeArray;

    private static StopWatch time = new StopWatch();

    public static void main(String[] args) {

        System.out.println("First using Mersenne algorithm to finishes this exercise..");
        System.out.printf("%-10s%7s\n", "P", "2 * P -1");

        for (int i = 270; i <= 300; i++) {
            if (isPrime2(i)) {
                System.out.printf("%-10d%-10s\n", i, getMersennePrime(i));
            }
        }

        System.out.println("5 prime numbers larger than Long.MAX_VALUE above...");

        System.out.println("\nPlaying around with primes.");
        System.out.println("Loading prime array...");
        primeArray = new primeArrayClass().getPrimeArrayList();
        System.out.println("loading finished... array size: " + primeArray.size());

        System.out.println("Current biggest prime: " + primeArray.get(primeArray.size() - 1));
        System.out.println("Prime needed to accurate calculate primes about Long.MaxValue: " + (long) Math.sqrt(Long.MAX_VALUE));
        System.out.println("Looking for other prime numbers starting from:");
        BigDecimal n = new BigDecimal(Long.MAX_VALUE).add(new BigDecimal(2));
        System.out.println(n);

        time.start();
        for (int primeCount = 0; primeCount < 5; n = n.add(new BigDecimal(2))) {

            if (time.nextFiveSeconds()) {
                System.out.println("Primes above Long.Max found: " + primeCount);
                System.out.println("Current biggest prime: " + primeArray.get(primeArray.size() - 1));

                System.out.println("Currently checking if " + n + " is prime.");
            }
            if (isPrime(sqrt(n).longValue())) {
                primeCount++;
            }

        }

        System.out.println("DONE. Found 5 primes...");


    }

    public static boolean isPrime2(long n) {

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

    private static boolean isPrime(long n) {


        for (long i : primeArray) {

            if (n % i == 0) {
                return false;
            }
            if (i > n) {
                break;
            }
        }

        for (long i = primeArray.get(primeArray.size() - 1); i < n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        primeArray.add(n);
        return true;
    }


    // Karp's Tricks, this can be implemented without a loop in only two lines, giving 32 digits precision
    private static BigDecimal sqrt(BigDecimal value) {
        BigDecimal x = new BigDecimal(Math.sqrt(value.doubleValue()));
        return x.add(new BigDecimal(value.subtract(x.multiply(x)).doubleValue() / (x.doubleValue() * 2.0)));
    }

}