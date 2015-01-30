package Chapter_21;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * (Addition quiz)
 * Rewrite Programming Exercise 11.16 to store the answers
 * in a set rather than a list.
 *
 * Created by Luiz Arantes Sa on 1/30/15.
 */
public class Exercise_15 {

    public static void main(String[] args) {
        int number1 = (int)(Math.random() * 10);
        int number2 = (int)(Math.random() * 10);

        // Create a Scanner
        Scanner input = new Scanner(System.in);
        Set<Integer> repeatedAnswers = new HashSet<>();

        System.out.print( "What is " + number1 + " + " + number2 + "? ");
        int answer = input.nextInt();

        while (number1 + number2 != answer) {
            if (repeatedAnswers.contains(answer)) {
                System.out.println("You already answered " + answer);
            }
            System.out.print("Wrong answer. Try again.\nWhat is " + number1 + " + " + number2 + "? ");
            repeatedAnswers.add(answer);
            answer = input.nextInt();
        }

        System.out.println("You got it!");
    }
}
