package ToolKit;

/**
 * Chapter 10 Exercise 27:
 *
 *      (Implement the StringBuilder class)
 *
 *      using MyStringBuilder1
 *
 * Created by Luiz Arantes Sa on 9/7/14.
 */
public class MyStringBuilder1 {

    private char[] buffer;
    public MyStringBuilder1(char[] chars) {
        buffer = new char[chars.length];

        System.arraycopy(chars, 0, buffer, 0, chars.length);
    }

    public MyStringBuilder1(String s) {
        this(s.toCharArray());
    }

    public MyStringBuilder1 append(int i) {

        String temp = "";
        while (i > 0) {
            temp = i % 10 + temp;
            i /= 10;
        }
        return new MyStringBuilder1(toString() + temp);
    }

    public MyStringBuilder1 append(MyStringBuilder1 s) {

        return new MyStringBuilder1(toString() + s.toString());
    }

    public String toString() {
        return new String(buffer);
    }

    public int length() {
        return buffer.length;
    }

    public char charAt(int i) {
        return buffer[i];
    }

    public MyStringBuilder1 toLowerCase() {
        char[] lower = new char[buffer.length];

        for (int i = 0; i < buffer.length; i++) {
            char old = buffer[i];
            if (old >= 'A' && old <= 'Z') {
                lower[i] = (char) (old - 'A' + 'a');
            } else {
                lower[i] = old;
            }
        }
        return new MyStringBuilder1(lower);
    }

    public MyStringBuilder1 substring(int begin, int end) {

        char[] temp = new char[end - begin];
        for (int i = begin; i < end; i++) {
            temp[i - begin] = buffer[i];
        }

        return new MyStringBuilder1(temp);
    }

    public MyStringBuilder1 insert(int offset, MyStringBuilder1 s) {
        char[] temp = new char[s.length() + buffer.length];
        for (int i = 0; i < offset; i++) {
            temp[i] = buffer[i];
        }

        for (int i = 0; i < s.length(); i++) {
            temp[offset + i] = s.charAt(i);

        }
        for (int i = offset + s.length(); i < temp.length; i++) {
            temp[i] = buffer[offset++];
        }

        return new MyStringBuilder1(temp);
    }

    public MyStringBuilder1 reverse() {
        char[] reverse = new char[buffer.length];

        int start = 0;
        for (int i = buffer.length - 1; i >= 0; i--) {
            reverse[i] = buffer[start++];
        }
        return new MyStringBuilder1(reverse);
    }

    public MyStringBuilder1 substring(int begin) {
        return substring(begin, buffer.length);
    }

    public MyStringBuilder1 toUpperCase() {

        char[] temp = new char[buffer.length];

        for (int i = 0; i < buffer.length; i++) {
            char ch = buffer[i];
            if (ch >= 'a' && ch <= 'z') {
                temp[i] = (char) (ch - 'a' + 'A');
            } else {
                temp[i] = ch;
            }
        }
        return new MyStringBuilder1(temp);
    }



}
