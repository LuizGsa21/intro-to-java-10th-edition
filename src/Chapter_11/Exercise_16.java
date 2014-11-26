package Chapter_11;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Chapter 11 Exercise 16:
 *
 *      (Addition quiz)
 *      Rewrite Listing 5.1 RepeatAdditionQuiz.java to alert the user if an answer is
 *      entered again. Hint: use an array list to store answers.
 *
 * Created by Luiz Arantes Sa on 9/8/14.
 */
public class Exercise_16 {

    public static void main(String[] args) {
        int number1 = (int)(Math.random() * 10);
        int number2 = (int)(Math.random() * 10);

        // Create a Scanner
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> repeatedAnswers = new ArrayList<>();

        System.out.print( "What is " + number1 + " + " + number2 + "? ");
        int answer = input.nextInt();

        while (number1 + number2 != answer) {
            if (repeatedAnswers.contains(answer)) {
                System.out.println("You already answered " + answer);
            }
            System.out.print("Wrong answer. Try again. What is " + number1 + " + " + number2 + "? ");
            repeatedAnswers.add(answer);
            answer = input.nextInt();
        }

        System.out.println("You got it!");
    }
}
