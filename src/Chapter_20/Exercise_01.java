package Chapter_20;

import java.io.*;
import java.security.InvalidParameterException;
import java.util.PriorityQueue;

/**
 * (Display words in ascending alphabetical order)
 * Write a program that reads words from a text file and displays all
 * the words (duplicates allowed) in ascend- ing alphabetical order.
 * The words must start with a letter. The text file is passed as a command-line argument.
 *
 * Created by Luiz Arantes Sa on 12/18/14.
 */
public class Exercise_01 {

    public static void main(String[] args) throws Exception {

        if (args.length != 1)
            throw new InvalidParameterException("Usage: Exercise_01 filename");

        File file = new File(args[0]);

        if (!file.isFile())
            throw new FileNotFoundException(file.getName() + " is not a file");

        PriorityQueue<String> pQueue = new PriorityQueue<>(1000, String.CASE_INSENSITIVE_ORDER);

        try (BufferedReader in = new BufferedReader(new FileReader(file))) {

            String s;
            while ((s = in.readLine()) != null) {

                String[] words = getValidWords(s);
                for (String word : words) {
                    pQueue.add(word);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            e.printStackTrace();
        }

        while (pQueue.size() > 0) {
            System.out.println(pQueue.poll() );
        }

    }

    public static String[] getValidWords(String s) {
        s = s.replaceAll("[0-9]\\p{L}+", ""); // Removes any word starting with a number
        s = s.replaceAll("\\s+", " "); // trims extra whitespace "    " into " "
        return s.split(" ");
    }

}