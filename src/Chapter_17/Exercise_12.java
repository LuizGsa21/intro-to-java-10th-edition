package Chapter_17;

import java.io.*;

/**
 * (Combine files)
 * Write a utility program that combines the files together
 * into a new file using the following command:
 * java Exercise_12 SourceFile1 . . . SourceFilename TargetFile
 * The command combines SourceFile1, . . . , and SourceFilename into TargetFile.
 * Created by Luiz Arantes Sa on 11/29/14.
 */
public class Exercise_12 {

    public static void main(String[] args) throws Exception {

        if (args.length < 3) {
            System.out.printf("(Invalid args) Proper usage: java Exercise_12 src1, src2 ... targetFile");
            System.exit(0);
        }

        File[] splitFiles = new File[args.length - 1];
        // Verify if src files exists
        for (int i = 0; i < splitFiles.length; i++) {
            splitFiles[i] = new File(args[i]);
            if (!splitFiles[i].isFile()) {
                throw new FileNotFoundException(splitFiles[i].getAbsolutePath() + " file not found.");
            }
        }

        // Combine files into targetFile
        File targetFile = new File(args[args.length - 1]);

        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(targetFile))) {

            int buffer;
            for (File f : splitFiles) {
                try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(f))) {

                    while ((buffer = in.read()) != -1)
                        out.write(buffer);

                }
            }
        }

    }
}
