package Chapter_10;

import ToolKit.MyStringBuilder1;

/**
 * Chapter 10 Exercise 27:
 *
 *      (Implement the StringBuilder class) The StringBuilder class is provided"
 *      "in the Java library. Provide your own implementation for the following methods"
 *      "(name the new class MyStringBuilder1):"
 *      "public MyStringBuilder1(String s);"
 *      "public MyStringBuilder1 append(MyStringBuilder1 s);"
 *      "public MyStringBuilder1 append(int i);"
 *      "public int length();"
 *      "public char charAt(int index);"
 *      "public MyStringBuilder1 toLowerCase();"
 *      "public MyStringBuilder1 substring(int begin, int end);"
 *      "public String toString();"
 *
 * Created by Luiz Arantes Sa on 9/7/14.
 */
public class Exercise_27 {

    public static void main(String[] args) {

        MyStringBuilder1 s = new MyStringBuilder1("ButtonDemo");
        System.out.println(s.toString());
        System.out.println(s.append(100).toString());
        System.out.println(s.toString());
        System.out.println("lowercase = " + s.toLowerCase());
        System.out.println("substring 0 3: " + s.substring(0, 3));

    }
}
