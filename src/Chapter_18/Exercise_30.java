package Chapter_18;

import java.io.*;
import java.util.Scanner;

/**
 * (Find words) Write a program that finds all occurrences of a
 * word in all the files under a directory, recursively.
 * Pass the parameters from the command line as follows:
 *
 * java Exercise18_30 dirName word
 *
 * Created by Luiz Arantes Sa on 12/10/14.
 */
public class Exercise_30 {

    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Usage: directoryName word");
            System.exit(0);
        }

        File file = new File(args[0]);
        if (!file.isDirectory() && !file.isFile()) {
            System.out.println(file.getAbsoluteFile() + " is not a file or directory");
            System.exit(0);
        }



        System.out.println("Searching...");
        getWordOccurrence(file, args[1]);
        System.out.println("Search Complete.");
    }

    private static void getWordOccurrence(File file, String word) {

        if (file.isFile()) {
            try (Scanner in = new Scanner(file)) {

                while (in.hasNextLine()) {
                    String s = in.nextLine();
                    if (s.contains(word)) {
                        System.out.println("File: " + s);
                    }
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    getWordOccurrence(f, word);
                }
            }
        }
    }

}
