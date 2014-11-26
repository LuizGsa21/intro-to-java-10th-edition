package Chapter_13;

import java.util.ArrayList;

/**
 * Chapter 13 Exercise 8:
 *      (Revise the MyStack class)
 *      Rewrite the MyStack class in Listing 11.10
 *      to perform a deep copy of the list field.
 *
 * Created by Luiz Arantes Sa on 9/10/14.
 */
public class Exercise_08 {

    public static void main(String[] args) {

        MyStack stack1 = new MyStack();
        for (int i = 0; i < 10; i++) {
            stack1.push(i);
        }
        MyStack stack2 = (MyStack) stack1.clone();
        // get rid of two items
        stack1.pop();
        stack1.pop();

        // display size for both stacks to make sure they are different
        System.out.println("stack1 size = " + stack1.getSize());
        System.out.println("stack2 size = " + stack2.getSize());

    }

}

class MyStack implements Cloneable {
    private ArrayList<Object> list = new ArrayList<>();

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int getSize() {
        return list.size();
    }

    public Object peek() {
        return list.get(getSize() - 1);
    }

    public Object pop() {
        Object o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }

    public void push(Object o) {
        list.add(o);
    }

    @Override /** Override the toString in the Object class */
    public String toString() {
        return "stack: " + list.toString();
    }

    @Override
    protected Object clone()  {
        MyStack myStack = null;
        try {
            myStack = (MyStack) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        myStack.list = new ArrayList<>(list);
        return myStack;
    }
}
