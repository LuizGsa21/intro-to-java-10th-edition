package Chapter_12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Chapter 12 Exercise 30:
 *
 *      (Occurrences of each letter)
 *      Write a program that prompts the user to enter a file name and
 *      displays the occurrences of each letter in the file. Letters are
 *      case-insensitive.
 *
 * Created by Luiz Arantes Sa on 9/9/14.
 */
public class Exercise_30 {

    public static void main(String[] args) {

        System.out.print("Enter file name: ");
        File file = new File(new Scanner(System.in).next());

        if (!file.exists()) {
            System.out.println(file + " doesn't exist");
            System.exit(1);
        }
        String buffer = "";
        int[] letterCount = new int[26];
        try (Scanner input = new Scanner(file)) {

            while (input.hasNext()) {
                buffer = input.nextLine();
                for (char ch : buffer.toCharArray()) {
                    ch = Character.toUpperCase(ch);
                    if (isLetter(ch)) {
                        letterCount[ch - 'A']++;
                    }
                }

            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        for (int i = 0; i < letterCount.length; i++) {
            System.out.println((char)(i + 'A') + " occurrence = " + letterCount[i]);
        }

    }

    private static boolean isLetter(char ch) {

        return (ch >= 'A' && ch <= 'Z');
    }


}
