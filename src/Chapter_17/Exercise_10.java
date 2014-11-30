package Chapter_17;

import java.io.*;

/**
 * (Split files)
 *
 *  Suppose you want to back up a huge file (e.g., a 10-GB AVI file) to a CD-R.
 *  You can achieve it by splitting the file into smaller pieces and backing up
 *  these pieces separately. Write a utility program that splits a large file into
 *  smaller ones using the following command: java Exercise17_10 SourceFile numberOfPieces
 *  The command creates the files SourceFile.1, SourceFile.2, . . . , SourceFile.n, where n is numberOfPieces
 *  and the output files are about the same size.
 *
 * Created by Luiz Arantes Sa on 11/29/14.
 */
public class Exercise_10 {

    /**
     *
     * @param args - arg[0] sourceFile | arg[1] number of divisions
     * @throws IOException
     */
    public static void main(String[] args) throws Exception {

        if (args.length != 2)
            throw new IOException("Usage: SourceFile numberOfPieces");

        File file = new File(args[0]);

        if (!file.exists())
            throw new IOException("File does not exist");
        if (file.isDirectory())
            throw new IOException(args[0] + "is not a file");

        int divisions = Integer.parseInt(args[1]);
        long limit = file.length() / divisions + 1;

        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(file))) {

            for (int i = 1; i <= divisions; i++) {
                int current = 0;

                try (BufferedOutputStream out =
                             new BufferedOutputStream(new FileOutputStream(new File(args[0] + "." + i)))) {

                    int buffer;
                    while(current++ < limit && (buffer = in.read()) != -1) {
                        out.write(buffer);
                    }
                }

            }


        }






    }
}
