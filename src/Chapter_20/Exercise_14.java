package Chapter_20;

import java.util.Stack;

/**
 * (Postfix notation)
 * Postfix notation is a way of writing expressions without using parentheses.
 * For example, the expression (1 + 2) * 3 would be written as 1 2 + 3 *.
 * A postfix expression is evaluated using a stack. Scan a postfix expression
 * from left to right. A variable or constant is pushed into the stack. When an
 * operator is encountered, apply the operator with the top two operands in the
 * stack and replace the two operands with the result. The follow- ing diagram
 * shows how to evaluate 1 2 + 3 *.
 *
 * Write a program to evaluate postfix expressions.
 * Pass the expression as a command-line argument in one string.
 * Created by Luiz Arantes Sa on 1/16/15.
 */
public class Exercise_14 {

    public static void main(String[] args) throws IllegalArgumentException {

        String[] tokens;
        switch (args.length) {
            case 0: throw new IllegalArgumentException("Usage: 1 5 * 10");
            case 1: tokens = args[0].split(" "); break;
            default:
                tokens = args;
        }

        Stack<Double> postfix = new Stack<>();

        for (String token : tokens) {

            if (isOperator(token.charAt(0))) {
                evaluate(postfix, token.charAt(0));
            } else {
                postfix.push(Double.parseDouble(token));
            }

        }

        System.out.println("result = " + postfix.pop());
    }

    private static void evaluate(Stack<Double> postfix, char operator) {
        double num2 = postfix.pop();
        double num1 = postfix.pop();
        switch (operator) {
            case '+':
                postfix.push(num1 + num2); break;
            case '-':
                postfix.push(num1 - num2); break;
            case '/':
                postfix.push(num1 / num2); break;
            case '*':
                postfix.push(num1 * num2); break;
        }
    }

    private static boolean isOperator(char ch) {
        return (ch == '/' ||
                ch == '+' ||
                ch == '-' ||
                ch == '*');
    }

}
