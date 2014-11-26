package Chapter_17;

import java.io.*;

/**
 * (Create a text file)
 * Write a program to create a file named Exercise17_01.txt if it does
 * not exist. Append new data to it if it already exists. Write 100
 * integers created randomly into the file using text I/O.
 * Integers are separated by a space.
 * Created by luizsa on 10/5/14.
 */
public class Exercise_01 {

    public static void main(String[] args) throws IOException {

        File file = new File("src/Text Files/Exercise17_01.txt");

        boolean append = file.exists();

        try (PrintWriter printWriter = new PrintWriter(new BufferedOutputStream(new FileOutputStream(file, append)))) {

            for (int i = 0; i < 100; i++) {
                printWriter.write((int) (Math.random() * (Integer.MAX_VALUE + 1L)) + " ");
            }
        }
    }
}
