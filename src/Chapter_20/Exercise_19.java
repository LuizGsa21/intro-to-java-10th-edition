package Chapter_20;

import ToolKit.PostfixNotation;
import java.math.BigInteger;
import java.util.ArrayList;

/**
 * (Game: solution ratio for 24-point game)
 * When you pick four cards from a deck of 52 cards for the 24-point game introduced
 * in Programming Exercise 20.13, the four cards may not have a 24-point solution.
 * What is the number of all possible picks of four cards from 52 cards? Among all
 * possible picks, how many of them have 24-point solutions? What is the success
 * ratio—that is, (number of picks with solutions)/ (number of all possible picks
 * of four cards)? Write a program to find these answers.
 *
 * Created by Luiz Arantes Sa on 1/23/15.
 */
public class Exercise_19 {

    public static void main(String[] args) {

        // Possible card combinations
        long possiblePermutation = factorial(new BigInteger("52"), new BigInteger("4")).longValue();
        System.out.println("Possible 52 cards permutation: " + possiblePermutation);

        // Possible permutations
        String[] operators = allOperators();
        int possibleSolutions = possibleSolutions(operators);
        System.out.println("Possible solutions: " + possibleSolutions);

        System.out.println("Success ratio = " + possibleSolutions / (double)possiblePermutation);

        System.out.println(24336.0 / 6497400.0);

    }

    public static int possibleSolutions(String[] operators) {

        ArrayList<String> expression = new ArrayList<>();
        for (int i = 1; i <= 13; i++)
            for (int k = 1; k <= 13; k++)
                for (int j = 1; j <= 13; j++)
                    for (int m = 1; m <= 13; m++)
                        for (String s : operators)
                            expression.add(i + " " + k + " " + j + " " + m +" " + s);
        int count = 0;

        ArrayList<String> solutions = new ArrayList<>(10000);

        for (String s : expression) {
            if (PostfixNotation.evaluate(s) == 24) {
                solutions.add(s);
                count++;
            }
        }

        return count;
    }
    public static String[] allOperators() {

        String[] op = {"+", "/", "*", "-"};
        String[] operators = new String[64];
        int index = 0;
        for (int i = 0; i < 4; i++)
            for (int k = 0; k < 4; k++)
                for (int j = 0; j < 4; j++, index++)
                    operators[index] = " " + op[i] + " " + op[k] + " " + op[j];

        return operators;

    }

    /**
     * n! / (n - r)!
     *
     * @param n Number of things to choose from
     * @param r Number of things chosen
     * @return Number of permutations
     */
    private static long factorial(int n, int r) {
        return factorial(n) / factorial(n - r);
    }

    /**
     * n!
     * @param n start value
     * @return Factorial value of n
     */
    private static long factorial(int n) {
        if (n == 1)
            return 1;
        else
            return n * factorial(n - 1);

    }

    /**
     * n! / (n - r)!
     *
     * @param n Number of things to choose from
     * @param r Number of things chosen
     * @return Number of permutations
     */
    private static BigInteger factorial(BigInteger n, BigInteger r) {
        return factorial(n).divide(factorial(n.subtract(r)));
    }

    /**
     * n!
     * @param n start value
     * @return Factorial value of n
     */
    private static BigInteger factorial(BigInteger n) {
        if (n.compareTo(BigInteger.ONE) == 0)
            return BigInteger.ONE;
        else
            return n.multiply(factorial(n.subtract(BigInteger.ONE)));
    }

}