package Chapter_21;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * (Count consonants and vowels)
 * Write a program that prompts the user to enter a text file name and
 * displays the number of vowels and consonants in the file. Use a set
 * to store the vowels A, E, I, O, and U.
 *
 * Created by Luiz Arantes Sa on 1/26/15.
 */
public class Exercise_04 {

    public static void main(String[] args) throws IOException {

        System.out.println("Enter file name: ");
        File file = new File(new Scanner(System.in).next());
        if (!file.isFile())
            throw new FileNotFoundException(file + " is not a file");

        int vowelCount = 0;
        int consonantCount = 0;
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {

            HashSet<Character> vowels = new HashSet<>(Arrays.asList(new Character[]{'A', 'E', 'I', 'O', 'U'}));

            String s;
            while ((s = in.readLine()) != null) {
                for (char ch : s.toCharArray()) {
                    if (Character.isAlphabetic(ch)) {
                        ch = Character.toUpperCase(ch);
                        if (vowels.contains(ch))
                            vowelCount++;
                        else
                            consonantCount++;
                    }
                }
            }

        } catch (IOException ex) {

        }

        System.out.println("Total vowels = " + vowelCount);
        System.out.println("Total consonants = " + consonantCount);
    }

}
