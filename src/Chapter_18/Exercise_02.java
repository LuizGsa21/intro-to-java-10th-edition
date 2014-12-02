package Chapter_18;

import java.util.Scanner;

/**
 * (Fibonacci numbers)
 *  Rewrite the fib method in Listing 18.2 using iterations.
 *
 * Created by Luiz Arantes Sa on 12/1/14.
 */
public class Exercise_02 {

    public static void main(String[] args) {

        System.out.print("Enter a fibonacci index: ");
        int index = new Scanner(System.in).nextInt();
        System.out.println("The fibonacci value is " + fibonacci(index));

    }

    public static long fibonacci(int index) {

        if (index == 0)
            return 0;
        if (index == 1)
            return 1;

        int f0 = 0;
        int f1 = 1;
        int fib;
        for (int i = 2; i <= index; i++) {
            fib = f0 + f1;
            f0 = f1;
            f1 = fib;
        }
        return f1;
    }
}
