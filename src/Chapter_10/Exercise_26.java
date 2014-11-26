package Chapter_10;

import ToolKit.MyString1;

/**
 * Chapter 10 Exercise 26:
 *
 *      (Calculator)
 *      Revise Listing 7.9, Calculator.java, to accept an expression as
 *      a string in which the operands and operator are separated by zero
 *      or more spaces. For example, 3+4 and 3 + 4 are acceptable expressions.
 *
 * Created by Luiz Arantes Sa on 9/7/14.
 */
public class Exercise_26 {

    public static void main(String[] args) {

        String temp = "";
        for (String s : args) {
            temp += s;
        }
        // Check number of strings passed
        args = MyString1.split(temp, "[+-/*]");
        if (args.length != 3) {
            System.out.println(
                    "Usage: java Calculator operand1 operator operand2");
            System.exit(0);
        }

        // The result of the operation
        int result = 0;

       // String[] array = MyString1.split()
        // Determine the operator
        switch (args[1].charAt(0)) {
            case '+':
                result = Integer.parseInt(args[0]) +
                        Integer.parseInt(args[2]);
                break;
            case '-':
                result = Integer.parseInt(args[0]) -
                        Integer.parseInt(args[2]);
                break;
            case '*':
                result = Integer.parseInt(args[0]) *
                        Integer.parseInt(args[2]);
                break;
            case '/':
                result = Integer.parseInt(args[0]) /
                        Integer.parseInt(args[2]);
        }

        // Display result
        System.out.println(args[0] + ' ' + args[1] + ' ' + args[2]
                + " = " + result);
    }
}
