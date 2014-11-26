package Chapter_07;

import java.util.Scanner;

/**
 * Chapter 7 Exercise 17:
 *
 *      (Sort students)
 *      Write a program that prompts the user to enter the
 *      number of students, the students’ names, and their
 *      scores, and prints student names in decreasing order
 *      of their scores.
 *
 * Created by Luiz Arantes Sa on 8/27/14.
 */
public class Exercise_17 {

    static final int NAME = 0;
    static final int SCORE = 1;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int size = input.nextInt();
        String[][] students = new String[2][size];

        for (int i = 0; i < students[SCORE].length; i++) {
            System.out.print("Enter student #"+ (i + 1) + " name: " );
            students[NAME][i] = input.next();
            System.out.print("Enter student #"+ (i + 1) + " score: " );
            students[SCORE][i] = input.next();
        }
        sort(students);
        printArray(students); // display decrementing

    }

    public static void sort(String[][] students) {

        for (int i = 0; i < students[SCORE].length - 1; i++) {

            int currentIndex = i;
            int currentMin = new Integer(students[SCORE][i]);
            String name = "";
            for (int k = i + 1; k < students[SCORE].length; k++) {

                if (currentMin > Integer.parseInt(students[SCORE][k])) {
                    currentMin = Integer.parseInt(students[SCORE][k]);
                    name = students[NAME][k];
                    currentIndex = k;
                }
            }

            if (currentIndex != i) {
                students[NAME][currentIndex] = students[NAME][i];
                students[SCORE][currentIndex] = students[SCORE][i];
                students[NAME][i] = name;
                students[SCORE][i] = Integer.toString(currentMin);
            }
        }

    }

    public static void printArray(String[][] array) {

                for (int i =  array[SCORE].length - 1; i >= 0; i--) {

                    System.out.println("Student: " + array[NAME][i] + " Score: " + array[SCORE][i]);

                }
    }
}
