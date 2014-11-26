package Chapter_05;

import java.util.Scanner;

/**
 * Chapter 5 Exercise 9:
 *
 *      (Find the two highest scores)
 *      Write a program that prompts the user to enter the number of
 *      students and each student’s name and score, and finally displays the
 *      student with the highest score and the student with the second highest score.
 *
 * Created by Luiz Arantes Sa on 8/24/14.
 */
public class Exercise_09 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of student: ");
        int studentCount = input.nextInt();
        input.nextLine();

        String topSName = null;
        double topSScore = 0;
        String secondSName = null;
        double secondSScore = 0;

        for (int i = 0; i < studentCount; i++) {
            System.out.print("Enter name for student #" + (i + 1) + ": ");
            String s = input.next();

            System.out.print("Enter score for student #" + (i + 1) + ": ");
            double score = input.nextDouble();

            if (score > topSScore) {
                if (topSName != null) {
                    secondSName = topSName;
                    secondSScore = topSScore;
                }
                topSName = s;
                topSScore = score;
            } else if (score > secondSScore) {
                secondSName = s;
                secondSScore = score;
            }

        }
        System.out.println("Top student " + topSName + "'s score is " + topSScore);
        System.out.println("Second top student " + secondSName + "'s score is " + secondSScore);
    }
}
