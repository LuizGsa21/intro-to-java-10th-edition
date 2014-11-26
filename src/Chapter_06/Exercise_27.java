package Chapter_06;

/**
 * Chapter 6 Exercise 27:
 *
 *
 *      (Emirp) An emirp (prime spelled backward) is a nonpalindromic prime number whose
 *      reversal is also a prime. For example, 17 is a prime and 71 is a prime, so 17 and 71
 *      are emirps. Write a program that displays the first 100 emirps.
 *      Display 10 numbers per line, separated by exactly one space, as follows:
 *
 *      13 17 31 37 71 73 79 97 107 113
 *      149 157 167 179 199 311 337 347 359 389
 *      ...
 * Created by Luiz Arantes Sa on 8/26/14.
 */
public class Exercise_27 {

    public static void main(String[] args) {

        int count = 0;
        for (int i = 10; count < 100; i++) {

            if (isPrime(i) && isPrime(reverse(i)) && !isPalindrome(i)) {
                System.out.printf("%10d", i);
                count++;
                if (count % 10 == 0 && i != 0) System.out.println();

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

    public static long reverse(long number) {

        long reverse = 0;
        while (number != 0) {

            reverse *= 10; // is ignored first iteration
            reverse += number % 10;
            number /= 10;
        }

        return reverse;
    }

    public static boolean isPalindrome(long number) {

        return (number == reverse(number));
    }
}
