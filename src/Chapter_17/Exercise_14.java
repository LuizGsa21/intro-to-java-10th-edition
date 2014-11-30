package Chapter_17;

import java.io.*;

/**
 * (Encrypt files)
 * Encode the file by adding 5 to every byte in the file. Write a program
 * that prompts the user to enter an input file name and an output file name
 * and saves the encrypted version of the input file to the output file.
 * <p>
 * Created by Luiz Arantes Sa on 11/30/14.
 */
public class Exercise_14 {

    public static void main(String[] args) {

        if (args.length != 2) {
            System.out.println("Invalid number of arguments. Usage: src target");
        }

        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(args[0]));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(args[1]))) {

            int buffer;
            while ((buffer = in.read()) != -1) {
                out.write(buffer + 5);
            }

            System.out.println("Encrypted file saved");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
