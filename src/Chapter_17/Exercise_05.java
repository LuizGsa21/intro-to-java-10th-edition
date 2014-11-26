package Chapter_17;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * (Store objects and arrays in a file)
 * Write a program that stores an array of the five int
 * values 1, 2, 3, 4, and 5, a Date object for the current time,
 * and the double value 5.5 into the file named Exercise17_05.dat.
 *
 * Created by luizsa on 10/5/14.
 */
public class Exercise_05 {

    public static void main(String[] args) throws IOException {

        int[] numbers = {1, 2, 3, 4, 5};
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Exercise17_05.dat"))) {
            out.writeObject(numbers);
            out.writeObject(new Date());
            out.writeDouble(2.5);
        }

    }
}
