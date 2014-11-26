package Chapter_17;

import java.io.*;

/**
 * (Create a binary data file)
 * Write a program to create a file named Exercise17_02.dat
 * if it does not exist. Append new data to it if it already exists.
 * Write 100 integers created randomly into the file using binary I/O.
 *
 * Created by luizsa on 10/5/14.
 */
public class Exercise_02 {

    public static void main(String[] args) throws IOException {

        File file = new File("src/text files/Exercise17_02.dat");
        boolean append = file.exists();

        try (DataOutputStream out =
                     new DataOutputStream(
                             new BufferedOutputStream(
                                     new FileOutputStream(file, append)))) {

            for (int i = 0; i < 100; i++) {
                out.writeInt((int)(Math.random() * (Integer.MAX_VALUE + 1L)));
            }
        }

    }
}
