package Chapter_07;

import java.util.Scanner;

/**
 * Chapter 7 Exercise 1:
 *
 *      (Assign grades)
 *      Write a program that reads student scores, gets the best score,
 *      and then assigns grades based on the following scheme:
 *    ￼￼￼￼￼￼￼Grade is A if score is >= best - 10
 *           Grade is B if score is >= best - 20
 *           Grade is C if score is >= best - 30
 *           Grade is D if score is >= best - 40
 *           Grade is F otherwise.
 * Created by Luiz Arantes Sa on 8/26/14.
 */
public class Exercise_01 {

    static final int THRESHOLD = 4;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = input.nextInt();
        System.out.print("Enter " + n + " scores: ");

        int[][] students = new int[3][n + THRESHOLD];

        for (int i = 0; i < n; i++) {
            students[0][i] = input.nextInt();
        }

        int bestScore = getBestScore(students);
        setGradeRange(students, bestScore);

        for (int i = 0; i < students[0].length - THRESHOLD; i++) {

            char grade = getStudentGrade(students, i);
            System.out.println("Student " + i + " score is " + students[0][i] + " and grade is " + grade);
        }
    }

    public static int getBestScore(int[][] students) {
        int bestScore = students[0][0];

        for (int i : students[0]) {
            if (i > bestScore) {
                bestScore = i;
            }
        }


        return bestScore;
    }

    public static void setGradeRange(int[][] students, int bestScore) {

        for (int i = 0; i < 4; i++) {
            students[1][i] = bestScore - (10 * (i + 1));

            students[2][i] = ('A' + i);
        }
    }

    public static char getStudentGrade(int[][] students, int index) {

        int grade = students[0][index];
        for (int i = 0; i < 4; i++) {
            if (grade >= students[1][i]) {
                return (char) students[2][i];
            }
        }
        return 'F';
    }
}
