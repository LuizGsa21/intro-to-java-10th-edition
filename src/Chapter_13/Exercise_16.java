package Chapter_13;

import ToolKit.BigRational;

import java.util.ArrayList;

/**
 * Chapter 13 Exercise 16:
 *
 *      (Create a rational-number calculator)
 *      Write a program similar to Listing 7.9, Calculator.java. Instead of using integers,
 *      use rationals, as shown in Figure 13.10a. You will need to use the split method in
 *      the String class, introduced in Section 10.10.3, Replacing and Splitting Strings,
 *      to retrieve the numerator string and denominator string, and convert strings into
 *      integers using the Integer.parseInt method.
 *
 * Created by Luiz Arantes Sa on 9/10/14.
 */
public class Exercise_16 {

    public static void main(String[] args) {

        String[] token = getTokens(args);

        if (token.length != 3 || !isValidOperator(token)) {
            System.out.println("Invalid arguments.");
            System.out.println("Usage: java Chapter_13.Exercise_16 1/2 * 8/17");
            System.exit(1);
        }

        BigRational operand1 = new BigRational(token[0]);
        BigRational operand2 = new BigRational(token[2]);

        BigRational answer = null;
        switch (args[1]) {
            case "+": answer = operand1.add(operand2); break;
            case "-": answer = operand1.subtract(operand2); break;
            case "*": answer = operand1.multiply(operand2); break;
            case "/": answer = operand1.divide(operand2); break;
        }

        System.out.println(operand1 + " " + args[1] + " " + operand2 + " = " + answer);
    }

    private static boolean isValidOperator(String[] token) {

        return  token[0].matches("[\\d]*[0-9]/[\\d]*[0-9]") &&
                token[1].matches("[\\-\\+\\*\\/]") &&
                token[2].matches("[\\d]*[0-9]/[\\d]*[0-9]");
    }

    private static String[] getTokens(String[] strings) {
        String merged = " ";
        for (String s : strings) {
            merged += " " + s;
        }

        String[] tokens = merged.split("[\\s ]");
        ArrayList<String> temp = new ArrayList<>();
        // remove blanks
        for (String s : tokens) {
            if (s.length() != 0) {
                temp.add(s);
            }
        }
        return temp.toArray(new String[temp.size()]);
    }

}
