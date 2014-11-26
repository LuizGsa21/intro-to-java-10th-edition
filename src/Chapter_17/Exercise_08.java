package Chapter_17;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * (Update count)
 * Suppose you wish to track how many times a
 * program has been executed. You can store an int
 * to count the file. Increase the count by 1 each
 * time this program is executed. Let the program
 * be Exercise17_08 and store the count in Exercise17_08.dat.
 *
 * Created by luizsa on 10/5/14.
 */
public class Exercise_08 {

    public static void main(String[] args) throws IOException {

        File file = new File("src/text files/Exercise17_08.dat");

        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
            int count = (raf.length() != 0) ? raf.readInt() + 1 : 1;
            raf.seek(0);
            raf.writeInt(count);
            System.out.println("The count is " + count);
        }


    }
}
