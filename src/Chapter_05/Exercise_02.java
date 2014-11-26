package Chapter_05;

import java.util.Scanner;

/**
 * Chapter 5 Exercise 2:
 *
 *      (Repeat additions) Listing 5.4, SubtractionQuizLoop.java, generates five random
 *      subtraction questions. Revise the program to generate ten random addition questions
 *      for two integers between 1 and 15. Display the correct count and test time.
 *
 * Created by Luiz Arantes Sa on 8/24/14.
 */
public class Exercise_02 {

    public static void main(String[] args) {

        final int NUMBER_OF_QUESTIONS = 10; // Number of questions
        int correctCount = 0; // Count the number of correct answers
        int count = 0; // Count the number of questions
        long startTime = System.currentTimeMillis();
        String output = ""; // output string is initially empty
        Scanner input = new Scanner(System.in);

        while (count < NUMBER_OF_QUESTIONS) {
            // 1. Generate two random integers between 1-15
            int number1 = (int)(Math.random() * 16 + 1);
            int number2 = (int)(Math.random() * 16 + 1);

            // 2. If number1 < number2, swap number1 with number2
            if (number1 < number2) {
                int temp = number1;
                number1 = number2;
                number2 = temp;
            }

            // 3. Prompt the student to answer ìWhat is number1 ñ number2?î
            System.out.print(
                    "What is " + number1 + " + " + number2 + "? ");
            int answer = input.nextInt();

            // 4. Grade the answer and display the result
            if (number1 + number2 == answer) {
                System.out.println("You are correct!\n");
                correctCount++;
            }
            else
                System.out.println("Your answer is wrong.\n" + number1
                        + " + " + number2 + " should be " + (number1 + number2) + "\n");

            // Increase the count
            count++;

            output += "\n" + number1 + "+" + number2 + "=" + answer +
                    ((number1 + number2 == answer) ? " correct" : " wrong");
        }

        long endTime = System.currentTimeMillis();
        long testTime = endTime - startTime;

        System.out.println("Correct count is " + correctCount +
                "\nTest time is " + testTime / 1000 + " seconds\n" + output);
    }

}
