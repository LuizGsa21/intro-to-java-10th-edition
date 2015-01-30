package AppUtils;


import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Luiz Arantes Sa on 1/29/15.
 */
public class JavaStringRemover {

    public static void main(String[] args) {

        Queue<File> queue = new PriorityQueue<>(1000);
        queue.add(new File("/Users/Kernel/Desktop/intro-to-java-10th-edition/src"));

        int count = 0;
        while (!queue.isEmpty()) {
            File file = queue.poll();
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                for (File listFile : listFiles) {
                    queue.add(listFile);
                }
            } else {
                if (!file.getName().matches(".*.java"))
                    continue;
                try (BufferedReader in = new BufferedReader(new FileReader(file))) {
                    StringBuilder sb = new StringBuilder(100000);
                    char[] chars;

                    while ((in.read(chars = new char[(int)file.length()])) != -1)
                        sb.append(chars);


                    in.close();
                    System.out.println(file.getName());
                    String s = filterString(sb.toString());
                    try (BufferedWriter out = new BufferedWriter(new FileWriter(file, false))) {
                        out.write(s.toCharArray());
                    }
                    count++;
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }
    }

    public static String filterString(String string) {
        StringBuilder sb = new StringBuilder(string);
        int startIndex = 0;
        while ((startIndex = resetToNextState(sb, startIndex)) != -1) {
            if (states[IN_BLOCK])
                startIndex = removeBlockComment(sb, startIndex);
            else if (states[IN_LINE])
                startIndex = removeInlineComment(sb, startIndex);
            else if (states[IN_STRING])
                startIndex = removeStringLiteral(sb, startIndex);
            else if (states[IN_CHAR])
                startIndex = removeCharLiteral(sb, startIndex);
        }

        return sb.toString();
    }

    private static int removeCharLiteral(StringBuilder sb, int startIndex) {
        return removeString(sb,  startIndex, tokens[IN_CHAR], "\\", EXCLUSIVE);
    }

    private static int removeStringLiteral(StringBuilder sb, int startIndex) {
        return removeString(sb, startIndex,  tokens[IN_STRING], "\\", EXCLUSIVE);
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
            case KEEP_END: // keep only the end token
                // KEEP_END is the default setting
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
