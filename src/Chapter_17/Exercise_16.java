package Chapter_17;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * (Frequency of characters)
 * Write a program that prompts the user to enter the name
 * of an ASCII text file and displays the frequency of the
 * characters in the file.
 * <p>
 * Created by Luiz Arantes Sa on 11/30/14.
 */
public class Exercise_16 {

    public static void main(String[] args) throws Exception {

        System.out.print("ASCII UTF-8 counter");
        System.out.print("Enter filename: ");
        File file = new File(new Scanner(System.in).nextLine());

        int[] ascii = new int[128];
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(file))) {

            int buffer;
            while ((buffer = in.read()) != -1)
                ascii[buffer]++;
        }

        // Display occurrences
        System.out.printf("%10s %10s %10s\n", "Character", "ASCII code", "Count");
        for (int i = 0; i < ascii.length; i++) {
            if (ascii[i] != 0)
                System.out.printf("%10c %10d %10d\n", i, ascii[i], i);
        }
    }

}
