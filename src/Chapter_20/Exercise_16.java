package Chapter_20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 *
 * (Convert infix to postfix)
 * Write a method that converts an infix expression
 * into a postfix expression using the following header:
 *
 * public static String infixToPostfix(String expression)
 * For example, the method should convert the infix expression
 * (1 + 2) * 3 to 1 2 + 3 *and2 * (1 + 3)to2 1 3 + *
 *
 * Created by Luiz Arantes Sa on 1/21/15.
 */
public class Exercise_16 {

    public static void main(String[] args) {

        System.out.println(infixToPostfix("10 * (2 + 10) * (10 / 2 + 5) + ( 10/(2*(10 * 2) + 2) + 8)"));
    }

    public static String infixToPostfix(String expression) {

        String[] tokens = separateExpression(expression);

        System.out.println(Arrays.toString(tokens));
        Stack<String> stackOperators = new Stack<>();
        String infixString = "";

        for (String token : tokens) {

            if (isOperator(token)) {
                if (stackOperators.empty()) {
                    stackOperators.push(token);

                } else if (token.equals("(")) {
                    stackOperators.push(token);

                } else if (token.equals(")")) {

                    while (!stackOperators.peek().equals("(")) {
                        infixString += stackOperators.pop() + " ";
                    }
                    stackOperators.pop(); // pop "("

                } else {

                    int top = opValue(stackOperators.peek());
                    int current = opValue(token);

                    if (current > top) {
                        stackOperators.push(token);
                    } else if (current == top) {
                        infixString += stackOperators.pop() + " ";
                        stackOperators.push(token);
                    } else {

                        while (!stackOperators.empty() &&
                                current <= opValue(stackOperators.peek()) &&
                                !stackOperators.peek().equals("(")) {
                            infixString += stackOperators.pop() + " ";
                        }
                        stackOperators.push(token);
                    }
                }
            } else {
                infixString += token + " ";
            }
        }


        while (!stackOperators.empty()) {
            infixString += stackOperators.pop() + " ";
        }

        return infixString;
    }

    private static String[] separateExpression(String s) {

        ArrayList<String> tokens = new ArrayList<>(30);

        char[] chars = s.toCharArray();

        String numBuffer = "";
        for (char ch : chars) {
            if (isOperator(ch)) {
                if (numBuffer.length() > 0) {
                    tokens.add(numBuffer);
                    numBuffer = "";
                }
                tokens.add(ch + "");
            } else {
                if (ch != ' ')
                    numBuffer += ch;
            }
        }

        if (numBuffer.length() > 0) {
            tokens.add(numBuffer);
        }

        return tokens.toArray(new String[tokens.size()]);

    }

    private static boolean isOperator(char ch) {
        return (ch == '(' ||
                ch == ')' ||
                isArithmeticOperator(ch));
    }

    private static boolean isOperator(String s) {
        return isOperator(s.trim().charAt(0));
    }

    private static int getOperatorValue(char ch) {

        switch (ch) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case ')':
                return 3;
            default:
                return -1;
        }
    }

    private static int opValue(String s) {
        return getOperatorValue(s.trim().charAt(0));
    }

    private static boolean isArithmeticOperator(char ch) {
        return (ch == '/' ||
                ch == '+' ||
                ch == '-' ||
                ch == '*');
    }
}
