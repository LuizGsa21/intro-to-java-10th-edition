package Chapter_18;

import java.io.File;

/**
 * (Number of files in a directory)
 * Write a program that prompts the user to enter a
 * directory and displays the number of the files in the directory.
 * Created by Luiz Arantes Sa on 12/9/14.
 */
public class Exercise_29 {

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Usage: directoryOrFilePath");
            System.exit(0);
        }

        File file = new File(args[0]);
        if (!file.isDirectory() && !file.isFile()) {
            System.out.println(file.getAbsoluteFile() + " is not a file or directory");
            System.exit(0);
        }

        System.out.println("Numbers of files = " + getFileCount(file));
    }

    private static long getFileCount(File file) {
        long count = 0;

        if (file.isFile())
            return 1;

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                        count += getFileCount(f);

                }
            }
        }

        return count;
    }
}
