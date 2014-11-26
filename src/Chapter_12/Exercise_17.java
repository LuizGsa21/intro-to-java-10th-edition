package Chapter_12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Chapter 12 Exercise 17:
 * <p>
 * (Game: hangman) Rewrite Programming Exercise 7.35. The program reads the
 * words stored in a text file named hangman.txt. Words are delimited by spaces.
 * <p>
 * Created by Luiz Arantes Sa on 9/9/14.
 */
public class Exercise_17 {

    static ArrayList<String> words = new ArrayList<>();

    static boolean isCorrect;

    public static void main(String[] args) {

        // getting file
        File filename = new File("hangman.txt");
        if (!filename.exists()) {
            System.out.println(filename.getAbsolutePath());
            System.out.println(filename + " does not exist.");
            System.exit(1);
        }
        // reading word file
        try {
            Scanner input = new Scanner(filename);
            while (input.hasNext()) {
                words.add(input.next());
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        // debug: display words
        //System.out.println(words);

        Scanner input = new Scanner(System.in);
        String playStats = "y";
        while (playStats.equals("y")) {
            String word = getWord();
            String hiddenWord = getHiddenWord(word);
            int missCount = 0;
            while (!word.equals(hiddenWord)) {

                System.out.print("(Guess) Enter a letter in word " + hiddenWord + " > ");
                char ch = input.next().charAt(0);

                if (!isAlreadyInWord(hiddenWord, ch)) {

                    hiddenWord = getGuess(word, hiddenWord, ch);

                    if (!isCorrect) {
                        System.out.println(ch + " is not in the word.");
                        missCount++;
                    }

                } else {
                    System.out.println(ch + " is already in word.");
                }

            }
            System.out.println("The word is program. You missed " + missCount + "times");
            System.out.println("Do you want to guess another word? Enter y or n >");
            playStats = input.next();
        }

    }

    public static String getWord() {
        return words.get((int) (Math.random() * words.size()));
    }

    public static String getHiddenWord(String word) {

        String hidden = "";
        for (int i = 0; i < word.length(); i++) {
            hidden += "*";
        }
        return hidden;
    }

    static public String getGuess(String word, String hiddenWord, char ch) {

        isCorrect = false;
        StringBuilder s = new StringBuilder(hiddenWord);
        for (int i = 0; i < word.length(); i++) {

            if (ch == word.charAt(i) && s.charAt(i) == '*') {
                isCorrect = true;
                s = s.deleteCharAt(i);
                s = s.insert(i, ch);
            }
        }
        return s.toString();
    }

    public static boolean isAlreadyInWord(String hiddenWord, char ch) {

        for (int i = 0; i < hiddenWord.length(); i++) {

            if (ch == hiddenWord.charAt(i)) {
                return true;
            }
        }
        return false;
    }
}
