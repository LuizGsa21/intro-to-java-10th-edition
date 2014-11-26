package Chapter_05;

/**
 * Chapter 5 Exercise 49:
 *
 *      (Count vowels and consonants) Assume letters A, E, I, O, and U as the vowels.
 *      Write a program that prompts the user to enter a string and displays the number
 *      of vowels and consonants in the string.
 *
 * Created by Luiz Arantes Sa on 8/24/14.
 */
public class Exercise_49 {

    public static void main(String[] args) {

        int vowel = getVowel("Programming is fun");
        int consonant = getConsonants("Programming is fun");

        System.out.println(vowel + " " + consonant);



    }

    public static int getConsonants(String s) {

        s = s.toUpperCase();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (isConsonant(ch)) {
                count++;
            }
        }

        return count;
    }

    public static int getVowel(String s) {

        int count = 0;
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            if (isVowel(ch)) {
                count++;
            }

        }
        return count;
    }

    public static boolean isVowel(char ch) {

        ch = Character.toUpperCase(ch);

        return ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';

    }

    public static boolean isConsonant(char ch) {

        return !isVowel(ch) && ch >= 'A' && ch <= 'Z';
    }








}
