package Chapter_21;

import java.io.File;
import java.util.*;

/**
 * (Count the keywords in Java source code)
 * Revise the program in Listing 21.7. If a keyword is in a comment or in a
 * string, don’t count it. Pass the Java file name from the command line.
 * Assume that the Java source code is correct and line comments and paragraph
 * comments do not overlap.
 *
 * Created by Luiz Arantes Sa on 1/25/15.
 */
public class Exercise_03 {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Java source file: ");
        String filename = input.nextLine();
        // test file
        // String filename = "/Users/Kernel/GitHub/intro-to-java-10th-edition/src/Chapter_21/Exercise_03.java";

        File file = new File(filename);
        if (file.exists()) {
            System.out.println("The number of keywords in " + file.getName()
                    + " is " + countKeywords(file));
        }
        else {
            System.out.println("File " + filename + " does not exist");
        }
    }

    private static boolean[] states = new boolean[4];
    private static int BLOCK = 0;
    private static int LINE = 1;
    private static int STRING = 2;
    private static int CHAR = 3;

    public static int countKeywords(File file) throws Exception {
        // Array of all Java keywords + true, false and null
        String[] keywordString = {"abstract", "assert", "boolean",
                "break", "byte", "case", "catch", "char", "class", "const",
                "continue", "default", "do", "double", "else", "enum",
                "extends", "for", "final", "finally", "float", "goto",
                "if", "implements", "import", "instanceof", "int",
                "interface", "long", "native", "new", "package", "private",
                "protected", "public", "return", "short", "static",
                "strictfp", "super", "switch", "synchronized", "this",
                "throw", "throws", "transient", "try", "void", "volatile",
                "while", "true", "false", "null"};

        Scanner input = new Scanner(file);
        int count = 0;
        HashSet<String> keywords = new HashSet<>(Arrays.asList(keywordString));
        String word = "";
        while (input.hasNext()) {
            word += input.nextLine() + "\n";
        }

        int index;
        while ((index = getNextState(word)) != -1) {
            if (states[BLOCK])
                word = removeBlock(word, index);
            else if (states[LINE])
                word = removeLine(word, index);
            else if (states[STRING])
                word = removeString(word, index);
            else if (states[CHAR])
                word = removeChar(word, index);
        }

        String[] filter = word.split("\\W");

        for (String s : filter) {
            if (s.length() > 0 && keywords.contains(s))
                count++;

        }
        return count;
    }

    private static String removeString(String word, int index) {

        states[STRING] = false;
        String clean = word.substring(0, index);
        String dirty = word.substring(index + 1);
        int escape = dirty.indexOf("\\");
        int dQuote = dirty.indexOf("\"");
        if (escape == -1 || escape > dQuote) // its clean to merge string
            return clean + dirty.substring(dQuote + 1);

        // else get the next double quote that doesn't have an escape character
        Stack<Character> tokens = new Stack<>();

        char[] charArray = dirty.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            if (ch == '\"' && tokens.isEmpty())
                return clean + dirty.substring(i + 1);

            if (!tokens.isEmpty())
                tokens.pop();
            else if (ch == '\\') {
                tokens.push(ch);
            }
        }
        return "ERROR FINDING END OF STRING";
    }

    private static String removeLine(String word, int index) {
        states[LINE] = false;
        String clean = word.substring(0, index);
        String end = word.substring(index);
        end = end.substring(end.indexOf("\n"));

        return clean + end;
    }

    private static String removeChar(String word, int index) {
        states[CHAR] = false;
        String clean = word.substring(0, index);
        String dirty = word.substring(index + 1);

        if (dirty.charAt(0) == '\\')
            dirty = dirty.substring(3);
        else
            dirty = dirty.substring(2);

        return clean + dirty;
    }

    private static String removeBlock(String s, int index) {
        states[BLOCK] = false;
        int end = s.indexOf("*/");
        String clean = s.substring(0, index);
        String endString = s.substring(end + 2);

        return clean + endString;
    }

    public static int getNextState(String s) {
        // block, line, string, char
        int[] indices = new int[4];
        String[] startStateTokens = {"/*", "//", "\"", "\'"};

        int lowest = -1;
        int key = 0;
        for (int i = 0; i < indices.length; i++) {
            indices[i] = s.indexOf(startStateTokens[i]);
            if (lowest == -1) {
                lowest = indices[i];
                key = i;
            } else if (lowest > indices[i] && indices[i] >= 0) {
                lowest = indices[i];
                key = i;
            }
        }

        if (key != -1) {
            states[key] = true;
        }

        return indices[key];
    }

}
