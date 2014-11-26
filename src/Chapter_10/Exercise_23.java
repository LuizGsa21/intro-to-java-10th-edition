package Chapter_10;

import ToolKit.MyString1;

/**
 * Chapter 10 Exercise 23:
 *
 *      (Implement the String class) The String class is provided in the Java library."
 *      "Provide your own implementation for the following methods (name the new"
 *      "class MyString2):"
 *      "public MyString2(String s);"
 *      "public int compare(String s);"
 *      "public MyString2 substring(int begin);"
 *      "public MyString2 toUpperCase();"
 *      "public char[] toChars();"
 *      "public static MyString2 valueOf(boolean b);"
 *
 * Created by Luiz Arantes Sa on 9/6/14.
 */
public class Exercise_23 {

    public static void main(String[] args) {

        System.out.println(new MyString1("I'm a string.").toChars());
        MyString1 s1 = new MyString1("test123");
        MyString1 s2 = new MyString1("test123");
        System.out.println("s1 = " + s1.toString());
        System.out.println("s2 = " + s2.toString());
        System.out.println("Is s1 equal to s2? " + s1.compare(s2));
        System.out.println("Value of false changed to uppercase = " + (MyString1.valueOf(false).toUpperCase().toString()));
        System.out.println("Value of true = " + (MyString1.valueOf(true).toString() ));

    }
}
