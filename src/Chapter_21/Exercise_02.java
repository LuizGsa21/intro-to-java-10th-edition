package Chapter_21;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.io.*;
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * (Display non-duplicate words in ascending order)
 * Write a program that reads words from a text file
 * and displays all the non-duplicate words in ascending order.
 * The text file is passed as a command-line argument.
 *
 * Created by Luiz Arantes Sa on 1/25/15.
 */
public class Exercise_02 {

    public static void main(String[] args) throws FileNotFoundException {

        if (args.length != 1)
            throw new InvalidParameterException("Usage: fullFilePathName");

        File file = new File(args[0]);
        if (!file.isFile())
            throw new FileNotFoundException(file + " is not a file.");

        try (BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file)), 10000)) {

            String inputS;
            StringBuilder sb = new StringBuilder(10000);
            while ((inputS = in.readLine()) != null)
                sb.append(inputS);

            String[] words = sb.toString().split("\\s+");
            // non duplicate words
            TreeSet<String> ndWords = new TreeSet<>(Arrays.asList(words));

            for (String s : ndWords)
                System.out.println(s);

        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }

    }
}
