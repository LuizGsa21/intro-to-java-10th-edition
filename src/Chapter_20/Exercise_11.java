package Chapter_20;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * (Match grouping symbols)
 * A Java program contains various pairs of grouping symbols, such as:
 *  ■ Parentheses: ( and ) ■ Braces: { and }
 *  ■ Brackets: [ and ]
 * Note that the grouping symbols cannot overlap. For example, (a{b)} is
 * illegal. Write a program to check whether a Java source-code file has
 * correct pairs of grouping symbols. Pass the source-code file
 * name as a command-line argument.
 *
 * Created by Luiz Arantes Sa on 12/30/14.
 */

public class Exercise_11 {


    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Usage: filename");
            System.exit(0);
        }

        File file = new File(args[0]);

        if (!file.isFile()) {
            System.out.println(args[0] + " is not a file.");
            System.exit(0);
        }

        Stack<String> stack = new Stack<>();
        ArrayList<String> symbols = new ArrayList<>();
        Collections.addAll(symbols, "(", ")", "{", "}", "[", "]");
        try(BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {
            String s;
            while ((s = in.readLine()) != null) {

                for (char c : s.toCharArray()) {
                    String symbol = c + "";
                    int symbolIndex = symbols.indexOf(symbol);

                    if (symbolIndex == -1)
                        continue;

                    if (stack.size() == 0) {
                        stack.push(symbol);
                    } else {
                        int lastIndex = symbols.indexOf(stack.peek());
                        if (symbolIndex - 1 == lastIndex) {
                            stack.pop();
                        } else {
                            if ((lastIndex & 1) == 1)
                                System.out.println("ERROR at:" + s);
                            stack.push(symbol);
                        }
                    }

                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("IO error.");
            e.printStackTrace();
        }

    }

}
