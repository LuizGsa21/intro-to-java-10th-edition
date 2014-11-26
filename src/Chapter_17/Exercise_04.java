package Chapter_17;

import java.io.*;

/**
 * (Convert a text file into UTF)
 * Write a program that reads lines of characters from a text
 * file and writes each line as a UTF-8 string into a binary file.
 * Display the sizes of the text file and the binary file.
 * Use the following command to run the program:
 * java Exercise17_04 Welcome.java Welcome.utf
 * Created by luizsa on 10/5/14.
 */
public class Exercise_04 {

    public static void main(String[] args) throws IOException {

        File file = new File(args[0]);
        // If file doesn't doesn't exit notify the user and terminate program
        if (!file.exists()) {
            System.out.println(file.getAbsolutePath());
            System.out.println("File does not exist...");
            System.exit(1);
        }

        try (BufferedReader in = new BufferedReader(new FileReader(file));
             DataOutputStream out =
                     new DataOutputStream(new BufferedOutputStream(new FileOutputStream(new File(args[1])))) ) {
            String s;
            int fileSize = 0;
            while ((s = in.readLine()) != null) {
                s += "\n";
                out.writeUTF(s);
                fileSize += s.length();
            }
            System.out.println(args[0] + " = " + fileSize + " bytes");
            System.out.println(args[1] + " = " + out.size() + " bytes");
        }

    }
}
