package Chapter_12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Chapter 12 Exercise 16:
 *
 *      (Replace text)
 *      Listing 12.16, ReplaceText.java, gives a program that replaces text
 *      in a source file and saves the change into a new file. Revise the
 *      program to save the change into the original file. For example,
 *      invoking:
 *          java Exercise12_16 file oldString newString
 *      replaces oldString in the source file with newString
 *
 * Created by Luiz Arantes Sa on 9/9/14.
 */
public class Exercise_16 {

    public static void main(String[] args) {

        if (args.length != 3) {
            System.out.println("Invalid arguments...");
            System.out.println("Usage: filename oldString newString");
            System.exit(1);
        }

        File filename = new File(args[0]);
        if (!filename.exists()) {
            System.out.println(filename.getAbsoluteFile());
            System.out.println(filename + " does not exist.");
            System.exit(2);
        }

        String oldString = args[1];
        String newString = args[2];

        String buffer = "";
        try {
            Scanner input = new Scanner(filename);
            while (input.hasNext()) {
                buffer += input.nextLine();
                buffer += "\n";
            }
            input.close();
            System.out.println("Old file: ");
            System.out.println(buffer);
            buffer = buffer.replaceAll(oldString, newString);
            PrintWriter out = new PrintWriter(filename);
            out.write(buffer);
            out.close();
            System.out.println("File saved...");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        System.out.println("Updated file:");
        System.out.println(buffer);

    }
}
