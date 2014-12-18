package Chapter_19;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * (Implement GenericStack using inheritance)
 *  In Listing 19.1, GenericStack is implemented
 *  using composition. Define a new stack class that extends ArrayList.
 *  Draw the UML diagram for the classes and then implement GenericStack.
 *  Write a test program that prompts the user to enter five strings and displays them in reverse order.
 *
 * Created by Luiz Arantes Sa on 12/17/14.
 */
public class Exercise_02 {

    public static void main(String[] args) {

        GenericStack1<String> stack = new GenericStack1<>();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter 5 strings: ");
        for (int i = 0; i < 5; i++)
            stack.push(input.next());

        System.out.println("Displaying strings in reverse order: ");
        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }


}

class GenericStack1<E> extends ArrayList<E> {


    public E peek() {
        return get(size() - 1);
    }

    public void push(E o) {
        add(o);
    }

    public E pop() {
        E o = get(size() - 1);
        remove(size() - 1);
        return o;
    }

    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public String toString() {
        return "stack: " + toString();
    }
}
