package ToolKit;

/**
 * Chapter 10 Exercise 24:
 * <p>
 * Created by Luiz Arantes Sa on 9/6/14.
 */
public class MyCharacter {

    private char ch;

    public MyCharacter(char ch) {
        this.ch = ch;
    }

    public static boolean isDigit(char ch) {
        return ch <= '9' && ch >= '0';
    }

    public static boolean isLowerCase(char ch) {

        return (ch <= 'z' && ch >= 'a');
    }

    public static boolean isUpperCase(char ch) {
        return (ch <= 'Z' && ch >= 'A');
    }

    public static boolean isLetter(char ch) {
        return (ch <= 'z' && ch >= 'a') ||
                (ch <= 'Z' && ch >= 'A');
    }

    public static boolean isLetterOrDigit(char ch) {
        return isLetter(ch) || isDigit(ch);
    }

    public static char toUpperCase(char ch) {
        if (isLowerCase(ch)) {
            return (char) (ch - 'a' + 'A');
        } else {
            return ch;
        }
    }

    public static char toLowerCase(char ch) {
        if (isUpperCase(ch)) {
            return (char) (ch - 'A' + 'a');
        } else {
            return ch;
        }
    }

    public boolean isDigit() {
        return isDigit(ch);
    }

    public boolean isLetter() {
        return isLetter(ch);
    }

    public char getChar() {
        return ch;
    }

    public int compareTo(MyCharacter ch) {
        return this.ch - ch.getChar();
    }

    public boolean equals(MyCharacter ch) {
        return this.ch == ch.getChar();
    }

}
