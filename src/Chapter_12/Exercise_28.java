package Chapter_12;

import java.io.File;

/**
 * Chapter 12 Exercise 28:
 *
 *      (Replace words)
 *      Suppose you have a lot of files in a directory that contain words Exercisei_j,
 *      where i and j are digits. Write a program that pads a 0 before i if i is a
 *      single digit and 0 before j if j is a single digit. For example, the word Exercise2_1
 *      in a file will be replaced by Exercise02_01. In Java, when you pass the symbol *
 *      from the command line, it refers to all files in the directory (see Supplement III.V).
 *      Use the following command to run your program.
 *
 * Created by Luiz Arantes Sa on 9/9/14.
 */
public class Exercise_28 {

    public static void main(String[] args) {

        //Kit.display(args);
        if (args.length == 0) {
            System.out.println("Invalid Arguments.");
            System.out.println("Usage: java Chapter_12.Exercise_28");
            System.exit(1);
        }
        for (String s : args) {

            if (s.matches("Exercise[\\d]_[\\d].*")) {
                StringBuilder sb = new StringBuilder(s);
                sb.insert(s.indexOf('_') - 1, "0");
                new File(s).renameTo(new File(sb.toString()));
            }
        }

    }

}
