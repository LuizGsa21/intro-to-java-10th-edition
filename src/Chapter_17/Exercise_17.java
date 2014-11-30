package Chapter_17;

import ToolKit.BitOutputStream;

import java.io.File;
import java.io.IOException;

/**
 * (BitOutputStream)
 * Implement a class named BitOutputStream, as shown in Figure 17.22,
 * for writing bits to an output stream. The writeBit(char bit) method
 * stores the bit in a byte variable. When you create a BitOutputStream,
 * the byte is empty. After invoking writeBit('1'), the byte becomes
 * 00000001. After invoking writeBit("0101"), the byte becomes 00010101.
 * The first three bits are not filled yet. When a byte is full, it is sent
 * to the output stream. Now the byte is reset to empty. You must close the
 * stream by invoking the close() method. If the byte is neither empty nor
 * full, the close() method first fills the zeros to make a full 8 bits in
 * the byte, and then outputs the byte and closes the stream. For a hint,
 * see Programming Exercise 5.44. Write a test program that sends the bits
 * 010000100100001001101 to the file named Exercise17_17.dat.
 * <p>
 * Created by Luiz Arantes Sa on 11/30/14.
 */
public class Exercise_17 {

    public static void main(String[] args) {

        File file = new File("Exercise17_17.dat");
        String bits = "010000100100001001101";

        try (BitOutputStream out = new BitOutputStream(file)) {

            out.writeBit(bits);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
