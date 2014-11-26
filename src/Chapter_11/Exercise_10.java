package Chapter_11;

import ToolKit.MyStack;

import java.util.Scanner;

/**
 * Chapter 11 Exercise 10:
 *
 *      (Implement MyStack using inheritance) In Listing 11.10, MyStack is implemented
 *      using composition. Define a new stack class that extends ArrayList.
 *      Draw the UML diagram for the classes and then implement MyStack. Write
 *      a test program that prompts the user to enter five strings and displays them in
 *      reverse order.
 *
 * Created by Luiz Arantes Sa on 9/8/14.
 */
public class Exercise_10 {

    public static void main(String[] args) {

        MyStack stack = new MyStack();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter 5 strings... ");
        for (int i = 0; i < 5; i++) stack.push(input.next());

        System.out.println("Displaying them in reverse order.");
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }
}
