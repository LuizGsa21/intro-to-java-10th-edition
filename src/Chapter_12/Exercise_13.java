package Chapter_12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Chapter 12 Exercise 13:
 *
 *      (Count characters, words, and lines in a file)
 *      Write a program that will count the number of characters,
 *      words, and lines in a file. Words are separated by whitespace characters.
 *      The file name should be passed as a command-line argument, as shown in Figure 12.13.
 *
 * Created by Luiz Arantes Sa on 9/9/14.
 */
public class Exercise_13 {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Invalid arguments.");
            System.out.println("Usage: java Chapter_12.Exercise_13 filename");
            System.exit(1);
        }
        File filename = new File(args[0]);
        if (!filename.exists()) {
            System.out.println(filename + " does not exist.");
            System.exit(2);
        }

        int characters = 0;
        int words = 0;
        int lines = 0;

        try {
            Scanner input = new Scanner(filename);
            while (input.hasNext()) {
                String s = input.nextLine();
                lines++;
                characters += s.length();
                String[] split = s.split(" ");
                for (String word : split) {
                    words++;
                }
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        System.out.println("Characters: " + characters);
        System.out.println("Words: " + words);
        System.out.println("Lines: " + lines);


    }
}
