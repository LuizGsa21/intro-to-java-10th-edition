package Chapter_07;

/**
 * Chapter 7 Exercise 6:
 *
 *      (Revise Listing 5.15, PrimeNumber.java)
 *      Listing 5.15 determines whether a number n is prime by checking
 *      whether 2, 3, 4, 5, 6, ..., n/2 is a divisor. If a divisor is found, n is
 *      not prime. A more efficient approach is to check whether any of the prime
 *      numbers less than or equal to √n can divide n evenly. If not, n is prime.
 *      Rewrite Listing 5.15 to display the first 50 prime numbers using this approach.
 *      You need to use an array to store the prime numbers and later use them to check whether
 *      they are possible divisors for n.
 *
 * Created by Luiz Arantes Sa on 8/27/14.
 */
public class Exercise_06 {

    static final int NUMBER_OF_PRIMES = 50;
    public static void main(String[] args) {

        int[] primeNumbers = new int[NUMBER_OF_PRIMES];
        int index = 0;

        for (int i = 2; index < NUMBER_OF_PRIMES; i++) {

            if (isPrime(i)) {
                primeNumbers[index++] = i;
            }
        }

       printArray(primeNumbers, 10);

    }

    public static boolean isPrime(int number) {

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;

        }

        return true;
    }

    public static void printArray(int[] array, int numberPerLine) {

        for (int i = 0; i < array.length; i++) {

            System.out.printf("%10d ", array[i]);
            if ((i + 1) % numberPerLine == 0) System.out.println("");
        }
    }





}
