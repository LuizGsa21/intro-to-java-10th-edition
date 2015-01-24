package ToolKit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * Created by Luiz Arantes Sa on 1/23/15.
 */
public class PostfixNotation {


    public static String postfixGenerator(double result, int threshold, Double... requiredNumbers) {

        double answer;
        int operatorLimit = requiredNumbers.length - 1;
        int length = requiredNumbers.length + operatorLimit; // required length
        String expression;

        Stack<Double> shuffledNumbers = new Stack<>();
        int attempts = 0;
        do {
            // reset required fields
            expression = "";
            shuffledNumbers.clear();
            shuffledNumbers.addAll(Arrays.asList(requiredNumbers));
            Collections.shuffle(shuffledNumbers);

            int tracker = 0;
            int operatorCount = 0;
            int count = 0;

            while (count < length) {
                if (shuffledNumbers.empty()) { // check if operator is required
                    expression += getRandomOperator() + " ";
                    tracker -= 2;
                } else if (operatorCount == operatorLimit || tracker - 2 < 0) { // check if an operand is required
                    expression += shuffledNumbers.pop() + " ";
                    tracker++;
                } else if ((int) (Math.random() * 2) == 1) { // add operand
                    expression += shuffledNumbers.pop() + " ";
                    tracker++;
                } else {
                    expression += getRandomOperator() + " "; // add operator
                    tracker -= 1;
                }
                count++;
            }

            answer = evaluate(expression);

            attempts++;
        } while (answer != result && attempts < threshold);

        if (answer == result)
            return expression;
        else
            return "No Solution";
    }

    public static double safeInfixEvaluation(String infixExpression) throws RuntimeException {

        StringBuilder sb = new StringBuilder();

        String operators = "()-+*/";

        // Check for syntax errors. Only only operators and numbers are allowed (including floating points '.')
        // Numbers with spaces in-between will be merged,
        // Example (9 3 + 3) * 2, the string will be read as ( 93 + 3 ) * 2
        for (char ch : infixExpression.toCharArray()) {

            if (ch == ' ') continue; // ignore white space
            if (Character.isAlphabetic(ch)) // no letters
                throw new RuntimeException("No characters allowed");

            if (operators.indexOf(ch) >= 0)
                sb.append(" ").append(ch).append(" ");
            else if (Character.isDigit(ch) || ch == '.')
                sb.append(ch);
            else
                throw new RuntimeException("Invalid character! " + ch);
        }

        // Check if parenthesis overlap
        Stack<String> opStack = new Stack<>();
        String[] symbols = sb.toString().trim().split("\\s+");
        System.out.println(Arrays.toString(symbols));
        for (String symbol : symbols) {
            if (symbol.equals("(")) {
                opStack.push(symbol);
            } else if (symbol.equals(")")) {
                if (opStack.empty())
                    throw new RuntimeException("ERROR: Expected a '(' before ')'");
                else
                    opStack.pop(); // pop (
            }
        }
        if (opStack.size() > 0)
            throw new RuntimeException("Invalid number of parenthesis");

        return evaluateInfix(sb.toString().trim());
    }


    public static double evaluate(String postfixExpression) {

        String[] expression = postfixExpression.split("\\s+");

        Stack<Double> postfix = new Stack<>();
        for (String token : expression) {
            if (isArithmeticOperator(token)) {
                evaluate(postfix, token);
            } else {
                postfix.push(Double.parseDouble(token));
            }
        }

        return postfix.pop();
    }

    public static double evaluateInfix(String infixExpression) {
        String postfix = convertToPostfix(infixExpression);
        return evaluate(postfix);
    }

    public static String convertToInfix(String postfixExpression) {
        String[] symbols = postfixExpression.split("\\s+");

        Stack<String> stack = new Stack<>();
        stack.addAll(Arrays.asList(symbols));

        for (String symbol : symbols) {
            if (isArithmeticOperator(symbol)) {

                // Invalid input
                if (stack.size() < 2) { System.out.println("ERROR"); break; }

                String num2 = stack.pop();
                String num1 = stack.pop();

                stack.push("(" + num1 +" "+ symbol +" "+ num2 + ")");
            } else {
                stack.push(symbol); // is an operand
            }
        }

        String expression = stack.pop();
        // remove extra outer parenthesis, then return infix expression
        return expression.substring(1, expression.length() - 1);
    }

    public static String convertToPostfix(String infixExpression) {

        String[] tokens = infixExpression.split("\\s+");

        Stack<String> stackOperators = new Stack<>();
        String infixString = "";

        for (String token : tokens) {

            if (isOperator(token)) {
                if (stackOperators.empty() || token.equals("(")) {
                    stackOperators.push(token);

                } else if (token.equals(")")) {
                    while (!stackOperators.peek().equals("(")) {
                        infixString += stackOperators.pop() + " ";
                    }
                    stackOperators.pop(); // pop "("
                } else {

                    int topValue = opValue(stackOperators.peek());
                    int current = opValue(token);

                    if (current > topValue) {
                        stackOperators.push(token);
                    } else if (current == topValue) {
                        infixString += stackOperators.pop() + " ";
                        stackOperators.push(token);
                    } else {

                        while (!stackOperators.empty() &&
                                !stackOperators.peek().equals("(") &&
                                current <= opValue(stackOperators.peek())) {

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

    public static Double[] getOperands(String expression, boolean isInfix) {

        String operators;
        if (isInfix) {
            operators = "()+-*/";
        } else  {
            operators = "+-*/";
        }

        ArrayList<Double> operands = new ArrayList<>(10);

        StringBuilder sb = new StringBuilder(10);

        boolean containsPeriod = false; // '.' for floating points
        for (char ch : expression.toCharArray()) {
            if (ch == ' ') continue;
            if (operators.indexOf(ch) > -1 && sb.length() > 0) {
                operands.add(Double.parseDouble(sb.toString()));
                sb = new StringBuilder(10);
                containsPeriod = false;
            } else if (ch == '.') {
                if (sb.length() == 0 || containsPeriod)
                    return null;
                else
                    sb.append(ch);
                containsPeriod = true;
            } else if (Character.isDigit(ch)) {
                sb.append(ch);
            }

        }

        if (sb.length() > 0) {
            operands.add(Double.parseDouble(sb.toString()));
        }

        return operands.toArray(new Double[operands.size()]);

    }

    private static String getRandomOperator() {
        String[] operators = new String[]{"*", "/", "+", "-"};
        return operators[(int) (Math.random() * operators.length)];
    }

    private static int opValue(char operator) {

        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return 3;
        }
    }

    private static int opValue(String operator) {
        return opValue(operator.trim().charAt(0));
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
            default:
                System.out.println("ERROR INVALID OPERATOR:"+operator);
        }
    }

    private static void evaluate(Stack<Double> postfix, String operator) {
        evaluate(postfix, operator.trim().charAt(0));
    }

    private static boolean isOperator(char ch) {
        return isArithmeticOperator(ch) ||
                ch == '(' ||
                ch == ')';
    }

    private static boolean isArithmeticOperator(char ch) {
        return (ch == '/' ||
                ch == '+' ||
                ch == '-' ||
                ch == '*');
    }

    private static boolean isArithmeticOperator(String operator) {
        return isArithmeticOperator(operator.trim().charAt(0));
    }

    private static boolean isOperator(String operator) {
        return isOperator(operator.trim().charAt(0));
    }

}
