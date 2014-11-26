package Chapter_12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Chapter 12 Exercise 12:
 *
 *      (Reformat Java source code)
 *      Write a program that converts the Java source code from the next-line brace
 *      style to the end-of-line brace style. For example, the following Java source
 *      in (a) uses the next-line brace style. Your program converts it to the end-of-line
 *      brace style in (b).
 *
 *      Your program can be invoked from the command line with the Java sourcecode file
 *      as the argument. It converts the Java source code to a new format.
 *      For example, the following command converts the Java source-code file Test.java
 *      to the end-of-line brace style.
 *
 * Created by Luiz Arantes Sa on 9/9/14.
 */
public class Exercise_12 {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Invalid argument.");
            System.out.println("Usage: java Chapter_10.Exercise_12 Test.java");
            System.exit(1);
        }

        File filename = new File(args[0]);
        if (!filename.exists()) {
            System.out.println(filename + " does not exist.");
            System.exit(2);
        }

        StringBuilder buffer = new StringBuilder();
        try {
            Scanner input = new Scanner(filename);
            while (input.hasNext()) {
                String s = input.nextLine();

                if (s.contains("{")) {
                    buffer.append(" {");
                } else {
                    buffer.append("\n" + s );
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            PrintWriter output = new PrintWriter(filename);
            output.write(buffer.toString());
            output.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(buffer);
    }

    public static int getIndex(String s, char ch) {

        for (int i = 0; i < s.length(); i++) {
            if (ch == s.charAt(i)) {
                return i;
            }
        }
        return -1;
    }
}
