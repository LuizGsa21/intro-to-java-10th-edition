package Chapter_10;

import ToolKit.MyString1;

/**
 * Chapter 10 Exercise 22:
 *
 *      (Implement the String class) The String class is provided in the Java library."
 *      "Provide your own implementation for the following methods (name the new"
 *      "class MyString1):"
 *      "public MyString1(char[] chars);"
 *      "public char charAt(int index);"
 *      "public int length();"
 *      "public MyString1 substring(int begin, int end);"
 *      "public MyString1 toLowerCase();"
 *      "public boolean equals(MyString1 s);"
 *      "public static MyString1 valueOf(int i);"
 *
 * Created by Luiz Arantes Sa on 9/6/14.
 */
public class Exercise_22 {

    public static void main(String[] args) {
        // MyString1
        MyString1 num = MyString1.valueOf(987654321L);
        System.out.println(num.toChars());
        MyString1 s = new MyString1("Test123");
        System.out.println(s.length());
        System.out.println(s.charAt(1));
        System.out.println(s.equals(new MyString1("Test123")));
        System.out.print(MyString1.valueOf(345).toChars());
    }
}