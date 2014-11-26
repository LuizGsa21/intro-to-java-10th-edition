package Chapter_12;

import java.io.File;
import java.util.Scanner;

/**
 * Chapter 12 Exercise 26:
 *
 *      (Create a directory)
 *      Write a program that prompts the user to enter a directory name
 *      and creates a directory using the File’s mkdirs method. The program
 *      displays the message “Directory created successfully” if a directory
 *      is created or “Directory already exists” if the directory already exists.
 *
 * Created by Luiz Arantes Sa on 9/9/14.
 */
public class Exercise_26 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a directory to create: ");
        File dir = new File(input.next());

        if (!dir.exists() && dir.mkdir()) {
            System.out.println(dir.getAbsolutePath());
            System.out.println("created...");
        } else {
            System.out.println("This directory already exits.");

        }
    }
}
