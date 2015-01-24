package Chapter_20;

import java.io.File;
import java.security.InvalidParameterException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

/**
 * (Directory size)
 * Rewrite Programming Exercise 18.28 using a stack instead of a queue.
 * Created by Luiz Arantes Sa on 1/23/15.
 */
public class Exercise_20 {


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
        Stack<File> stack = new Stack<>();
        stack.push(file);

        while (!stack.isEmpty()) {
            file = stack.pop();
            if (file.isFile()) {
                size += file.length();
            } else {
                File[] files = file.listFiles();
                if (files != null)
                    Collections.addAll(stack, file);
            }
        }
        return size;
    }
}
