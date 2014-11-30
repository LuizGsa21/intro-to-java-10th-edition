package Chapter_17;

import java.io.*;

/**
 * (Decrypt files)
 *  Suppose a file is encrypted using the scheme in Programming Exercise 17.14.
 *  Write a program to decode an encrypted file. Your program should prompt the
 *  user to enter an input file name for the encrypted file and an output file
 *  name for the unencrypted version of the input file.
 *
 * Created by Luiz Arantes Sa on 11/30/14.
 */
public class Exercise_15 {

    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Invalid number of arguments. Usage: src target");
        }

        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(args[0]));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(args[1]))) {

            int buffer;
            while ((buffer = in.read()) != -1) {
                out.write(buffer - 5);
            }

            System.out.println("File Unencrypted!");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
