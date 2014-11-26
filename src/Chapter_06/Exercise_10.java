package Chapter_06;

/**
 * Chapter 6 Exercise 10:
 *
 *      (Use the isPrime Method)
 *
 * Created by Luiz Arantes Sa on 8/25/14.
 */
public class Exercise_10 {

    public static void main(String[] args) {

        int primeCount = 0;
        for (int i = 2; i <= 10000; i++) {

            if (isPrime(i)) {
             primeCount++;
            }
        }

        System.out.println("Total number of prime numbers from 1-1000 is " + primeCount);

    }

    /** Check whether number is prime */
    public static boolean isPrime(int number) {
        for (int divisor = 2; divisor <= number / 2; divisor++) {
            if (number % divisor == 0) { // If true, number is not prime
                return false; // number is not a prime
            }
        }

        return true; // number is prime
    }

}
