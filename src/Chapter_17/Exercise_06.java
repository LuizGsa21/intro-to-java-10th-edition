package Chapter_17;

import ToolKit.Loan;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * (Store Loan objects)
 * The Loan class in Listing 10.2 does not implement Serializable.
 * Rewrite the Loan class to implement Serializable. Write a program
 * that creates five Loan objects and stores them in a file named Exercise17_06.dat.
 *
 * Created by luizsa on 10/5/14.
 */
public class Exercise_06 {

    public static void main(String[] args) throws IOException {

        File file = new File("src/text files/Exercise17_06.dat");

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {

            for (int i = 0; i < 5; i++) {
                out.writeObject(new Loan(0.6, 23, 50 + (Math.random() * 101)));
            }
        }
    }
}
