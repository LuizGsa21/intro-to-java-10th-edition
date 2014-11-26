package Chapter_12;

import ToolKit.Kit;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Chapter 12 Exercise 21:
 *
 *      (Data sorted?)
 *      Write a program that reads the strings from file SortedStrings.txt
 *      and reports whether the strings in the files are stored in increasing order.
 *      If the strings are not sorted in the file, displays the first two strings that are out
 *      of the order.
 *
 * Created by Luiz Arantes Sa on 9/9/14.
 */
public class Exercise_21 {

    public static void main(String[] args) {

        File filename = new File("SortedStrings.txt");
        if (!filename.exists()) {
            System.out.println(filename.getAbsolutePath());
            System.out.println(filename + " does not exist...");
            System.exit(1);
        }
        String s = "";
        try (Scanner input = new Scanner(filename)) {

            while (input.hasNext()) {
                s += input.nextLine() + " ";
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        // put words into an array
        String[] words = s.split(" ");
        String[] unordered = isSorted(words);
        if (unordered == null) {
            System.out.println("File is ordered in ascending order.");
        } else {
            System.out.println("First two unordered words: ");
            Kit.display(unordered);
        }
    }


    /**
     * Returns null if string array is in ascending order.
     * Else it will return the first two strings that are out of order.
     */
    private static String[] isSorted(String[] words) {

        String[] twoString = new String[2];
        for (int i = 0; i < words.length - 1; i++) {

            if (words[i].compareTo(words[i + 1]) > 0) {
                return new String[] {words[i], words[i + 1]};
            }
        }
        return null;
    }


}
