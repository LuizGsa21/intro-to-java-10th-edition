package Chapter_17;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * (View bits)
 * Write the following method that displays the bit
 * representation for the last byte in an integer:
 * <p>
 * public static String getBits(int value)
 * <p>
 * Write a program that prompts the user to enter a
 * file name, reads bytes from the file, and displays
 * each byte’s binary representation.
 * <p>
 * Created by Luiz Arantes Sa on 11/30/14.
 */
public class Exercise_18 {


    public static void main(String[] args) throws Exception {

        System.out.print(
                "Bit viewer\n" +
                        "Enter a filename: ");
        File file = new File(new Scanner(System.in).nextLine());

        String bits = "";
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(file))) {

            int r;
            while ((r = in.read()) != -1)
                bits += " " + getBits(r);
        }
        System.out.println(bits);
    }

    public static String getBits(int value) {

        String byteString = "";

        for (int i = 7; i >= 0; i--)
            byteString += ((value >> i) & 1);

        return byteString;
    }
}
