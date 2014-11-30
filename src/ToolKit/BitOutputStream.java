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

    char[] byteBuffer = new char[8]; // represents 8 bits
    int index = 8;

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
        byteBuffer[--index] = bit;
        if (index == 0) {
            out.write(Byte.parseByte(new String(byteBuffer), 2));
            index = 8;
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
        for (int i = bit.length() - 1; i >= 0; i--) {
            writeBit(bit.charAt(i));
        }
    }

    /**
     * Closes BitOutputStream
     * <p>
     * Any remaining bits will get outputted to file
     *
     * @throws IOException
     */
    public void close() throws IOException {

        if (index < 8) {
            while (index >= 0) { // add leading zeros
                byteBuffer[index--] = '0';
            }
            out.write(Byte.parseByte(new String(byteBuffer), 2));
        }
        out.close();
    }

}
