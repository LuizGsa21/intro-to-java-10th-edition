package Chapter_12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Chapter 12 Exercise 22:
 *
 *      (Replace text)
 *      Revise Programming Exercise 12.16 to replace a string in a file with a
 *      new string for all files in the specified directory using the command:
 *
 * Created by Luiz Arantes Sa on 9/9/14.
 */
public class Exercise_22 {

    public static void main(String[] args) {

        if (args.length != 3) {
            System.out.println("Invalid argument.");
            System.out.println("Usage: java Chapter_12.Exercise_22 dir oldString newString");
            System.exit(1);
        }
        // get directory
        File dir = new File(args[0]);
        if (!dir.exists()) {
            System.out.println(dir.getAbsolutePath());
            System.out.println(dir + " does not exist.");
            System.exit(2);
        }
        if (!dir.isDirectory()) {
            System.out.println(dir.getAbsolutePath());
            System.out.println(dir + " is not a directory.");
            System.exit(2);
        }

        String oldString = args[1];
        String newString = args[2];

        File[] files = dir.listFiles();
        if (files == null) {
            System.out.println(dir.getAbsolutePath());
            System.out.println("No files in directory...");
            System.exit(3);
        }

        for (File file : files) {
            if (file.isFile() && file.getName().contains(".txt")) {
                replaceWord(file, oldString, newString);
            }
        }

    }

    private static void replaceWord(File file, String oldString, String newString) {
        String lineSeparator = System.getProperty("line.separator");
        String buffer = "";
        try (Scanner input = new Scanner(file)) {

            while (input.hasNext()) {
                buffer += input.nextLine() + lineSeparator;
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        buffer = buffer.replaceAll(oldString, newString);

        try (PrintWriter out = new PrintWriter(file)) {

            out.write(buffer);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

    }
}
