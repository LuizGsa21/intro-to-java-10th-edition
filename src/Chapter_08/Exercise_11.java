package Chapter_08;

import java.util.Scanner;

/**
 * Chapter 8 Exercise 11:
 *
 *      (Game: nine heads and tails)
 *      Nine coins are placed in a 3-by-3 matrix with some face up and some face down.
 *      You can represent the state of the coins using a 3-by-3 matrix with
 *      values 0 (heads) and 1 (tails).
 *
 *      Each state can also be represented using a binary number.
 *      For example, the pre- ceding matrices correspond to the numbers
 *
 *      000010000 101001100 110100001 101110100 100111110
 *
 *      There are a total of 512 possibilities, so you can use decimal numbers
 *      0, 1, 2, 3, . . . , and 511 to represent all states of the matrix.
 *      Write a program that prompts the user to enter a number
 *      between 0 and 511 and displays the corresponding matrix with the characters H and T.
 *
 *      The user entered 7, which corresponds to 000000111.
 *      Since 0 stands for H and 1 for T, the output is correct.
 *
 * Created by Luiz Arantes Sa on 8/30/14.
 *
 */
public class Exercise_11 {

    public static void main(String[] args) {

        int[][] m = new int[3][3];

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number between 0 and 511: ");
        int n = input.nextInt();
        String binary = decimalToBinaryModified(n);

        // put 1's and 0's using binary string
        int bIndex = 0; // binary string index
        for (int i = 0; i < m.length; i++) {

            for (int k = 0; k < m[i].length; k++) {
                int coinSide = (binary.charAt(bIndex++) == '0') ? 0 : 1;
                m[i][k] = coinSide;
            }
        }
        for (int i = 0; i < m.length; i++) {

            for (int k = 0; k < m[i].length; k++) {
                char ch = (m[i][k] == 0) ? 'H' : 'T';
                System.out.print(ch + " ");
            }
            System.out.println("");
        }

    }

    public static String decimalToBinaryModified(int n) {

        StringBuilder s = new StringBuilder();
        while (n != 0) {
            s.append(n & 1);
            n = n >> 1;
        }
        while (s.length() < 9) {
            s.insert(0, "0");
        }
        return s.toString();
    }


}
