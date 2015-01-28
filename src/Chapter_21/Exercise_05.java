package Chapter_21;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.*;

/**
 * (Syntax highlighting)
 * Write a program that converts a Java file into an HTML file.
 * In the HTML file, the keywords, comments, and literals are displayed
 * in bold navy, green, and blue, respectively. Use the command line to
 * pass a Java file and an HTML file. For example, the following command
 * java Exercise21_05 Welcome.java Welcome.html
 * converts Welcome.java into Welcome.html. Figure 21.8a shows a Java file.
 * The corresponding HTML file is shown in Figure 21.8b.
 * <p>
 * Created by Luiz Arantes Sa on 1/26/15.
 */
public class Exercise_05 {


    public static void main(String[] args) throws Exception {
//        Scanner input = new Scanner(System.in);
//        System.out.print("Enter a Java source file: ");
//        String filename = input.nextLine();
//        String filename = "/Users/Kernel/GitHub/intro-to-java-10th-edition/src/Chapter_21/Exercise_05.java";
        String filename = "/Users/Kernel/GitHub/intro-to-java-10th-edition/src/ToolKit/Loan.java";
//        String filename = "/Users/Kernel/GitHub/intro-to-java-10th-edition/src/ToolKit/Account.java";

        File file = new File(filename);
        if (file.exists()) {
            System.out.println(file.getName() + " has been parsed to html " + parseToHTML(file));
        } else {
            System.out.println("File " + filename + " does not exist");
        }
    }

    private static boolean[] states = new boolean[4];
    private static int BLOCK = 0;
    private static int LINE = 1;
    private static int STRING = 2;
    private static int CHAR = 3;

    public static int parseToHTML(File file) throws Exception {
        Scanner input = new Scanner(file);
        int count = 0;
        String word = "";
        while (input.hasNext()) {
            word += input.nextLine() + "\n";
        }

        int index;
        int prevIndex = 0;
        while ((index = getNextState(word, lastIndex)) != -1) {

            if (index > lastIndex) {
                word = parseSyntax(word, lastIndex, index);
//                for (int i = 0; i < states.length; i++)
//                    states[i] = false;
//                index = getNextState(word, lastIndex);
                index = lastIndex;
            }
            if (states[BLOCK])
                word = parseBlock(word, index);
            else if (states[LINE])
                word = parseLine(word, index);
            else if (states[STRING])
                word = parseString(word, index);
            else if (states[CHAR])
                word = parseChar(word, index);
            prevIndex = lastIndex;
        }

        if (prevIndex < word.length()) {
            word = parseSyntax(word, prevIndex, word.length());
        }
        word = getHeader() + word + getFooter();
//        ByteBuffer parsedHTML = Charset.forName("UTF-8").encode(word);

        // Save to a html file
        try (FileOutputStream out = new FileOutputStream("/Users/Kernel/Desktop/test3.html")) {
            out.write(word.getBytes());
        } catch (IOException ex) {

        }
        return count;
    }


    // Array of all Java keywords + true, false and null
    private  static HashSet<String> keywords = new HashSet<>(Arrays.asList(
            "abstract", "assert", "boolean", "break", "byte", "case",
            "catch", "char", "class", "const", "continue", "default",
            "do", "double", "else", "enum", "extends", "for", "final",
            "finally", "float", "goto", "if", "implements", "import",
            "instanceof", "int", "interface", "long", "native", "new",
            "package", "private", "protected", "public", "return",
            "short", "static", "strictfp", "super", "switch", "synchronized",
            "this", "throw", "throws", "transient", "try", "void", "volatile",
            "while", "true", "false", "null"));

    private static String parseSyntax(String s, int startIndex, int last) {

        String beforeSyntax = s.substring(0, startIndex);
        String syntax = s.substring(startIndex, last);

        syntax = parseSyntax(syntax, false);
        String[] splitSyntax = syntax.split("(\\|\\|\\|\\|\\|)|((?<=\\()|(?=\\)))");
        syntax = "";
        for (String split : splitSyntax) {
            System.out.println(split);
            if (keywords.contains(split)) {
                syntax += wrapWithSpanTag(split, "blue");
            } else {
                syntax += split;
            }
        }

        String afterString = s.substring(last);
        lastIndex = beforeSyntax.length() + syntax.length();
        return beforeSyntax + syntax + afterString;
    }

    private static int lastIndex;

    private static String parseString(String word, int index) {

        states[STRING] = false;
        String beforeString = word.substring(0, index);
        String unknownLiteral = word.substring(index);

        int escape = unknownLiteral.indexOf("\\", 1); // escape sequence (back slash)
        int dQuote = unknownLiteral.indexOf("\"", 1); // double quote

        // Does this string literal have any escape sequence?
        if (escape == -1 || escape > dQuote) { // If no, save string literal to the hash map, then return the string
            String strLiteral = unknownLiteral.substring(0, dQuote + 1); // + 1 to include double quote
            String afterLiteral = unknownLiteral.substring(dQuote + 1);

            strLiteral = parseToHTML(strLiteral, true);
            strLiteral = wrapWithSpanTag(strLiteral, "green");
            lastIndex = beforeString.length() + strLiteral.length();
            return beforeString + strLiteral + afterLiteral;
        }

        // Code reaches here is this string has an escape sequence
        // Find the next double quote that doesn't have an escape character
        Stack<Character> tokens = new Stack<>();
        char[] charArray = unknownLiteral.toCharArray();
        for (int i = 1; i < charArray.length; i++) {
            char ch = charArray[i];
            if (ch == '\"' && tokens.isEmpty()) {
                String strLiteral = unknownLiteral.substring(0, i + 1); // +1 to include "
                strLiteral = parseToHTML(strLiteral, true);
                strLiteral = wrapWithSpanTag(strLiteral, "green");
                lastIndex = beforeString.length() + strLiteral.length();
                return beforeString + strLiteral + unknownLiteral.substring(i + 1);
            }

            if (!tokens.isEmpty())
                tokens.pop();
            else if (ch == '\\') {
                tokens.push(ch);
            }
        }
        return "ERROR FINDING END OF STRING";
    }

    private static String parseSyntax(String s, boolean isStrLiteral) {
        s = s.replaceAll("&", "|||||&#x26;|||||");
        s = s.replaceAll("<", "|||||&#x3C;|||||");
        s = s.replaceAll(">", "|||||&#x3E;|||||");
        s = s.replaceAll("\"", "|||||&#x22;|||||");
        s = s.replaceAll(" ", "|||||&nbsp;|||||");
        if (!isStrLiteral) {
            s = s.replaceAll("\n", "|||||<br>|||||");
            s = s.replaceAll("\t", "|||||&nbsp;|||||&nbsp;|||||&nbsp;|||||&nbsp;|||||&nbsp;");
        }
        return s;
    }
    private static String parseToHTML(String s, boolean isStrLiteral) {
        s = s.replaceAll("&", "&#x26;");
        s = s.replaceAll("<", "&#x3C;");
        s = s.replaceAll(">", "&#x3E;");
        s = s.replaceAll("\"", "&#x22;");
        s = s.replaceAll(" ", "&nbsp;");
        if (!isStrLiteral) {
            s = s.replaceAll("\n", "<br>");
            s = s.replaceAll("\t", "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
        }
        return s;
    }
    private static String parseLine(String s, int index) {
        states[LINE] = false;
        String beforeLine = s.substring(0, index);

        String unknownLine = s.substring(index);
        int eof = unknownLine.indexOf("\n");
        String line = unknownLine.substring(0, eof);

        line = parseToHTML(line, false);

        String afterLine = unknownLine.substring(eof + 1); // ignore \n
        line = wrapWithSpanTag(line, "orange") + "<br>"; // append new line (<br>)

        lastIndex = beforeLine.length() + line.length();

        return beforeLine + line + afterLine;
    }

    private static String parseChar(String word, int index) {
        states[CHAR] = false;

        String beforeChar = word.substring(0, index);
        String unknownLiteral = word.substring(index);

        String charLiteral;
        if (unknownLiteral.charAt(1) == '\\') // if there's an escape sequence
            charLiteral = unknownLiteral.substring(0, 4);
        else
            charLiteral = unknownLiteral.substring(0, 3);

        String afterChar = word.substring(index + charLiteral.length());

        charLiteral = parseToHTML(charLiteral, true);
        charLiteral = wrapWithSpanTag(charLiteral, "green");

        lastIndex = beforeChar.length() + charLiteral.length();

        return beforeChar + charLiteral + afterChar;
    }

    private static String parseBlock(String s, int index) {
        states[BLOCK] = false;
        String beforeBlock = s.substring(0, index);

        int endIndex = s.indexOf("*/", index) + 2; // +2 for /*
        String block = s.substring(index, endIndex);
        String afterBlock = s.substring(endIndex);

        block = parseToHTML(block, false);
        block = wrapWithSpanTag(block, "orange");
        lastIndex = beforeBlock.length() + block.length();
        return beforeBlock + block + afterBlock;
    }

    private static String getHeader() {
        return "<!DOCTYPE html><html><head lang=\"en\"><meta charset=\"UTF-8\"><title></title></head><body>";
    }

    private static String getFooter() {
        return "</body></html>";
    }

    public static int getNextState(String s, int startIndex) {
        // block, line, string, char
        int[] indices = new int[4];
        String[] startStateTokens = {"/*", "//", "\"", "\'"};

        int lowest = -1;
        int key = 0;
        for (int i = 0; i < indices.length; i++) {
            indices[i] = s.indexOf(startStateTokens[i], startIndex);
            if (lowest == -1) {
                lowest = indices[i];
                key = i;
            } else if (lowest > indices[i] && indices[i] >= 0) {
                lowest = indices[i];
                key = i;
            }
        }

        // Set the current state
        if (key != -1) {
            states[key] = true;
        }

        return indices[key];
    }

    private static String wrapWithSpanTag(String s, String color) {
        return "<span style=\"color:" + color + ";\">" + s + "</span>";

    }
}
