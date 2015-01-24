package Chapter_20;

import java.io.File;
import java.security.InvalidParameterException;
import java.util.Collections;
import java.util.LinkedList;

/**
 * (Directory size)
 * Listing 20.7, DirectorySize.java, gives a recursive method for finding a directory size.
 * Rewrite this method without using recursion. Your program should use a queue to store
 * the subdirectories under a directory.
 * Created by Luiz Arantes Sa on 1/23/15.
 */
public class Exercise_18 {

    public static void main(String[] args) {

        if (args.length != 1)
            throw new InvalidParameterException("Usage: fullPathName");

        File file = new File(args[0]);

        if (!file.isDirectory() && !file.isFile())
            throw new InvalidParameterException("Not a file or directory");

        String dirOrFile = (file.isDirectory()) ? "Directory" : "File";
        System.out.println(dirOrFile + " size = " + getSize(file));
    }

    public static long getSize(File file) {

        long size = 0;
        LinkedList<File> queue = new LinkedList<>();
        queue.offer(file);

        while (!queue.isEmpty()) {
            file = queue.poll();
            if (file.isFile()) {
                size += file.length();
            } else {
                File[] files = file.listFiles();
                if (files != null)
                    Collections.addAll(queue, file);
            }
        }
        return size;
    }
}
