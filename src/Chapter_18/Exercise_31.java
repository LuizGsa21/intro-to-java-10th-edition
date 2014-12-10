package Chapter_18;

import java.io.*;
import java.util.Scanner;

/**
 * (Replace words)
 * Write a program that replaces all occurrences of a word
 * with a new word in all the files under a directory, recursively.
 * Pass the parameters from the command line as follows:
 *
 *  java Exercise18_31 dirName oldWord newWord
 *
 * Created by Luiz Arantes Sa on 12/10/14.
 */
public class Exercise_31 {


    public static void main(String[] args) {

        if (args.length != 3) {
            System.out.println("Usage: dirName oldWord newWord");
            System.exit(0);
        }

        File file = new File(args[0]);
        if (!file.isFile() && !file.isDirectory()) {
            System.out.println(file.getAbsoluteFile() + " is not a file or a directory");
            System.exit(0);
        }
        renameOccurrence(file, args[1], args[2]);
    }

    private static void renameOccurrence(File file, String oldWord, String newWord) {

        if (file.isFile()) {
            String s = "";
            try(Scanner in = new Scanner(file)) {
                while (in.hasNext()) {
                    s += in.nextLine();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            if (s.length() > 0) {

                s = s.replace(oldWord, newWord);

                try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file, false))) {
                    out.write(s.getBytes());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        } else {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    renameOccurrence(f, oldWord, newWord);
                }
            }
        }
    }
}
