package Chapter_12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Chapter 12 Exercise 14:
 *
 *      (Process scores in a text file)
 *      Suppose that a text file contains an unspecified number of scores
 *      separated by blanks. Write a program that prompts the user to enter
 *      the file, reads the scores from the file, and displays their total
 *      and average.
 *
 * Created by Luiz Arantes Sa on 9/9/14.
 */
public class Exercise_14 {

    public static void main(String[] args) {

        // creating a random number of scores to test exercise
        int numberOfScores = (int) (Math.random() * 100 + 100);
        try {
            PrintWriter output = new PrintWriter("scores.txt");
            output.write(randomNumbers(numberOfScores));
            output.close();
            System.out.println("Saved " + numberOfScores + " scores to scores.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Scanner input = new Scanner(System.in);
        System.out.print("Enter filename: ");
        File filename = new File(input.next());
        input.close();

        if (!filename.exists()) {
            System.out.println(filename + " does not exist.");
            System.exit(1);
        }
        // Creating arrayList to hold an unspecified number of scores
        ArrayList<Integer> scores = new ArrayList<>();
        try {
            input = new Scanner(filename);
            while (input.hasNextInt()) {
                scores.add(input.nextInt());
            }
            System.out.println("Read " + scores.size() +" scores from " + filename);
        } catch (FileNotFoundException ex) {

            System.out.println("Error reading " + filename);
            ex.printStackTrace();
        }
    }

    public static String randomNumbers(int size) {

        String s = "";
        for (int i = 0; i < size; i++) {
            s += " " + (int) (Math.random() * 100);
        }

        return s;
    }
}
