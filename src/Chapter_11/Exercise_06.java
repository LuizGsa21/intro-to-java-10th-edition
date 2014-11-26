package Chapter_11;

import ToolKit.Account;
import ToolKit.Circle2D;

import java.util.ArrayList;
import java.util.Date;

/**
 * Chapter 11 Exercise 6:
 *
 *      (Use ArrayList) Write a program that creates an ArrayList and adds a Loan
 *      object, a Date object, a string, and a Circle object to the list, and use a loop
 *      to display all the elements in the list by invoking the object’s toString()
 *      method.
 *
 * Created by Luiz Arantes Sa on 9/8/14.
 */
public class Exercise_06 {

    public static void main(String[] args) {

        ArrayList<Object> list = new ArrayList<>();

        list.add(new Circle2D());
        list.add("Hello I'm a string");
        list.add(new Date());
        list.add(new Account(111, 230));

        list.forEach(System.out::println);

    }

}
