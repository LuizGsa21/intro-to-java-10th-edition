package Chapter_06;

/**
 * Chapter 6 Exercise 29:
 *
 *
 *      (Twin primes) Twin primes are a pair of prime numbers that differ by 2.
 *      For example, 3 and 5 are twin primes, 5 and 7 are twin primes, and 11 and 13 are twin primes.
 *      Write a program to find all twin primes less than 1,000. Display the output as follows:
 *
 *      (3, 5)
 *      (5, 7)
 *
 * Created by Luiz Arantes Sa on 8/26/14.
 */
public class Exercise_29 {

    public static void main(String[] args) {

        for (int i = 2; i < 1000; i++) {

            if (isPrime(i) && isPrime(i + 2)) {
                System.out.printf("(%d, %d)\n", i, i + 2);
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

}
