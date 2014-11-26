package Chapter_06;

/**
 * Chapter 6 Exercise 26:
 *
 *      (Palindromic prime)
 *      A palindromic prime is a prime number and also palindromic.
 *      For example, 131 is a prime and also a palindromic prime, as are 313 and 757.
 *      Write a program that displays the first 100 palindromic prime numbers.
 *      Display 10 numbers per line, separated by exactly one space, as follows:
 *
 *        2 3 5 7 11 101 131 151 181 191
 *        313 353 373 383 727 757 787 797 919 929
 *        ...
 *
 * Created by Luiz Arantes Sa on 8/26/14.
 */
public class Exercise_26 {

    public static void main(String[] args) {

        int count = 0;
        for (int i = 0; count < 100; i++) {

            if (isPrime(i) && isPalindrome(i)) {
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
