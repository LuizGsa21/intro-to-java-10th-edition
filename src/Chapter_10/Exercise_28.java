package Chapter_10;

import ToolKit.MyStringBuilder1;

/**
 * Chapter 10 Exercise 28:
 *
 *      (Implement the StringBuilder class) The StringBuilder class is provided"
 *      "in the Java library. Provide your own implementation for the following methods"
 *      "(name the new class MyStringBuilder2):"
 *      "public  MyStringBuilder2();"
 *      "public MyStringBuilder2(char[] chars);"
 *      "public MyStringBuilder2(String s);"
 *      "public MyStringBuilder2 insert(int offset, MyStringBuilder2 s);"
 *      "public MyStringBuilder2 reverse();"
 *      "public MyStringBuilder2 substring(int begin);"
 *      "public MyStringBuilder2 toUpperCase();"
 * Created by Luiz Arantes Sa on 9/7/14.
 */
public class Exercise_28 {

    public static void main(String[] args) {

        MyStringBuilder1 temp = new MyStringBuilder1("temp123");
        System.out.println("Current word = " + temp.toString());
        System.out.println("inserting INSERT at index 1: " + temp.insert(1, new MyStringBuilder1("INSERT")).toString());
        System.out.println("reverse temp123: " + temp.reverse().toString());
        System.out.println("to upper: " + temp.toUpperCase().toString());
    }
}
