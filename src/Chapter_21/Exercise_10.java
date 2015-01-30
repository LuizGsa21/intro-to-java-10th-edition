package Chapter_21;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * (Count the occurrences of each keyword)
 * Rewrite Listing 21.7 CountKeywords. java to read in a Java source code file
 * and count the occurrence of each keyword in the file, but don’t count the
 * keyword if it is in a comment or in a string literal.
 *
 * Created by Luiz Arantes Sa on 1/28/15.
 */
public class Exercise_10 {


    public static void main(String[] args) {
        // /Users/Kernel/GitHub/intro-to-java-10th-edition/src/Chapter_21/Exercise_10.java
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter a file name: ");
//        File file = new File(scanner.next());
        File file = new File("/Users/Kernel/GitHub/intro-to-java-10th-edition/src/Chapter_21/Exercise_10.java");
        if (!file.isFile()) {
            System.out.println(file + " is not a file");
            System.exit(0);
        }

        StringBuilder sb = null;
        try {
            byte[] bytes = Files.readAllBytes(file.toPath());
            sb = new StringBuilder(Charset.forName("UTF-8").decode(ByteBuffer.wrap(bytes)));
        } catch (IOException ex) {
            System.out.println("Error reading file.");
            ex.printStackTrace();
            System.exit(0);
        }
        filterString(sb);

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

        HashMap<String, Integer> occurrences = new HashMap<>();

        for (String aKeywordString : keywordString) occurrences.put(aKeywordString, 0);

        String[] words = sb.toString().split("[()}\\{\\s+;=!,]");
        for (String word : words) {
            if (occurrences.containsKey(word)) {
                occurrences.put(word, occurrences.get(word) + 1);
            }
        }

        occurrences.forEach((k,v) -> System.out.println(k + " " + v));

    }

    private static void filterString(StringBuilder sb) {
        int startIndex = 0;
        while ((startIndex = resetToNextState(sb, startIndex) )!= -1) {
            if (states[IN_BLOCK])
                startIndex = removeBlockComment(sb, startIndex);
            else if (states[IN_LINE])
                startIndex = removeInlineComment(sb, startIndex);
            else if (states[IN_STRING])
                startIndex = removeStringLiteral(sb, startIndex);
            else if (states[IN_CHAR])
                startIndex = removeCharLiteral(sb, startIndex);
        }
    }

    private static int removeCharLiteral(StringBuilder sb, int startIndex) {
        return removeString(sb,  startIndex, tokens[IN_CHAR], "\\", INCLUSIVE);
    }

    private static int removeStringLiteral(StringBuilder sb, int startIndex) {
        return removeString(sb, startIndex,  tokens[IN_STRING], "\\", INCLUSIVE);
    }

    private static int removeInlineComment(StringBuilder sb, int startIndex) {
        return removeString(sb, startIndex, tokens[IN_LINE], "", KEEP_END);
    }

    private static int removeBlockComment(StringBuilder sb, int startIndex) {
        return removeString(sb,  startIndex, tokens[IN_BLOCK], "", INCLUSIVE);
    }


    private static final int INCLUSIVE = 0;
    private static final int EXCLUSIVE = 1;
    private static final int KEEP_START = 2;
    private static final int KEEP_END = 3;

    private static int removeString(StringBuilder sb, int startIndex, String[] tokens, String escapeToken, int options) {

        String startToken = tokens[0];
        String endToken = tokens[1];
        // Find the ending index
        int endIndex = sb.indexOf(endToken, startIndex + startToken.length()); // currently unknown

        // Check for any escape tokens
        if (escapeToken.length() > 0) {
            int escTokenIndex = startIndex;
            while (endIndex > (escTokenIndex = sb.indexOf(escapeToken, escTokenIndex)) && escTokenIndex != -1) {
                escTokenIndex += 2;
                endIndex = sb.indexOf(endToken, escTokenIndex);
            }
        }

        int startOffset = 0;
        int endOffset = 0;
        int finalIndex = startIndex; // Then new end index after the string is truncated
        switch (options) {
            case INCLUSIVE: // includes removal of both tokens
                endOffset = endToken.length();
                break;
            case EXCLUSIVE: // exclude tokens from being removed
                startOffset = startToken.length();
                finalIndex += startOffset + endToken.length();
                break;
            case KEEP_START: // keep only the start token
                endOffset = endToken.length();
                finalIndex += startToken.length();
                break;
            case KEEP_END: // keep only the ending token
                // Keep end is the default setting
                break;
        }

        if (endIndex < 0)
            endIndex = sb.length();

        sb.delete(startIndex + startOffset, endIndex + endOffset);
        return finalIndex;
    }


    // Used for indicating the current state
    private static boolean[] states = new boolean[4];
    // Possible states
    private static final int IN_LINE = 0; // line comment //
    private static final int IN_BLOCK = 1; // start with: /* */
    private static final int IN_STRING = 2; // string literal ""
    private static final int IN_CHAR = 3; // character literal ''
    // Tokens that trigger the beginning of a state
    private static final String[][] tokens = {{"//","\n"}, {"/*","*/",}, {"\"","\"",}, {"\'", "\'"}};

    private static int resetToNextState(StringBuilder sb, int startIndex) {

        // Reset the current state
        for (int i = 0; i < states.length; i++) {
            if (states[i])
                states[i] = false;
        }
        int key = -1;
        int nextStateIndex = -1;

        // Find the lowest value greater than -1
        for (int i = 0; i < tokens.length; i++) {
            int indexOf = sb.indexOf(tokens[i][0], startIndex);
            if (indexOf == -1) continue;
            if (indexOf < nextStateIndex || nextStateIndex == -1) {
                nextStateIndex = indexOf;
                key = i;
            }
        }

        if (key != -1)
            states[key] = true; // Set the current state
        return nextStateIndex;
    }
}