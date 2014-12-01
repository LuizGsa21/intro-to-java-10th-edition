package ToolKit;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Part of Chapter 17 ex-17
 * <p>
 * Creates a bit output stream to write bits to a file.
 * <p>
 * Created by Luiz Arantes Sa on 11/30/14.
 */
public class BitOutputStream implements AutoCloseable {

    FileOutputStream out;
    int bits; // bit buffer
    int bitPos; // bitPos bit index, gets reset when bitPos == 8


    public BitOutputStream(File file) throws IOException {
        out = new FileOutputStream(file);
    }


    /**
     * Writes bit into byte buffer.
     * Byte Buffer writes to file when full
     *
     * @param bit char representing a bit value '1' or '0'
     * @throws IOException
     */
    public void writeBit(char bit) throws IOException {
        bits = bits << 1;

        if (bit == '1')
            bits = bits | 1;

        if (++bitPos == 8) {
            out.write(bits);
            bitPos = 0;
        }

    }


    /**
     * Writes bits into byte buffer.
     * Byte buffer writes to file when full
     *
     * @param bit a string sequence in 1's and 0's
     * @throws IOException
     */
    public void writeBit(String bit) throws IOException {
        for (int i = 0; i < bit.length(); i++)
            writeBit(bit.charAt(i));
    }

    /**
     * Closes BitOutputStream
     * <p>
     * Any remaining bits will get outputted to file
     *
     * @throws IOException
     */
    public void close() throws IOException {


        if (bitPos > 0) {
            bits = bits << 8 - bitPos; // add 0's to end of byte
            out.write(bits);
        }

        out.close();

    }

}
