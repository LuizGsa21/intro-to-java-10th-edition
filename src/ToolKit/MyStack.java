package ToolKit;

import java.util.ArrayList;

/**
 * Chapter 11 Exercise :
 *
 *  Modified using inheritance
 *
 * Created by Luiz Arantes Sa on 9/8/14.
 */
public class MyStack  extends ArrayList<Object> {


    public Object peek() {
        return get(size() - 1);
    }

    public Object pop() {
        Object o = get(size() - 1);
        remove(size() - 1);
        return o;
    }

    public void push(Object o) {
        add(o);
    }


    @Override /** Override the toString in the Object class */
    public String toString() {
        return "stack: " + super.toString();
    }
}
