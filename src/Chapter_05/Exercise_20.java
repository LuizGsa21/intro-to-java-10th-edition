package Chapter_05;

/**
 * Chapter 5 Exercise 20:
 *
 *
 *      (Display prime numbers between 2 and 1,000)
 *      Modify Listing 5.15 to display all the prime numbers
 *      between 2 and 1,000, inclusive. Display eight prime numbers per line.
 *      Numbers are separated by exactly one space.
 *
 * Created by Luiz Arantes Sa on 8/24/14.
 */
public class Exercise_20 {

    public static void main(String[] args) {
        final int NUMBER_OF_PRIMES_PER_LINE = 8; // Display 10 per line
        int count = 0; // Count the number of prime numbers
        int number = 2; // A number to be tested for primeness

        System.out.println("The first 50 prime numbers are \n");

        // Repeatedly find prime numbers
        while (number <= 1000) {
            // Assume the number is prime
            boolean isPrime = true; // Is the current number prime?

            // Test if number is prime
            for (int divisor = 2; divisor <= number / 2; divisor++) {
                if (number % divisor == 0) { // If true, number is not prime
                    isPrime = false; // Set isPrime to false
                    break; // Exit the for loop
                }
            }

            // Print the prime number and increase the count
            if (isPrime) {
                count++; // Increase the count

                if (count % NUMBER_OF_PRIMES_PER_LINE == 0) {
                    // Print the number and advance to the new line
                    System.out.println(number);
                }
                else
                    System.out.print(number + " ");
            }

            // Check if the next number is prime
            number++;
        }
    }
}
