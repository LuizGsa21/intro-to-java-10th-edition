package Chapter_05;

import java.util.Scanner;

/**
 * Chapter 5 Exercise 8:
 *
 *      (Find the highest score)
 *      Write a program that prompts the user to enter the number
 *      of students and each student’s name and score, and finally
 *      displays the name of the student with the highest score.
 *
 * Created by Luiz Arantes Sa on 8/24/14.
 */
public class Exercise_08 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of student: ");
        int studentCount = input.nextInt();
        input.nextLine();
        String topStudentName = null;
        double topStudentScore = 0;
        for (int i = 0; i < studentCount; i++) {
            System.out.print("Enter name for student #" + (i + 1) + ": ");
            String s = input.next();
            System.out.print("Enter score for student #" + (i + 1) + ": ");
            double score = input.nextDouble();

            if (score > topStudentScore) {
                topStudentName = s;
                topStudentScore = score;
            }
        }
        System.out.println("Top student " + topStudentName + "'s score is " + topStudentScore);
    }
}
