package Chapter_17;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 * (View hex)
 * Write a program that prompts the user to enter a file name,
 * reads bytes from the file, and displays each byte’s hex
 * representation.
 * <p>
 * Created by Luiz Arantes Sa on 11/30/14.
 */
public class Exercise_19 {

    public static void main(String[] args) throws Exception {

        System.out.print(
                "Bit viewer\n" +
                        "Enter a filename: ");
        File file = new File(new Scanner(System.in).nextLine());
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(file))) {

            int r;
            while ((r = in.read()) != -1)
                System.out.print(Integer.toHexString(r));

        }

    }

}
