package Chapter_10;

import ToolKit.MyCharacter;

/**
 * Chapter 10 Exercise 24:
 *
 *     (Implement the Character class)
 *     The Character class is provided in the Java library.
 *     Provide your own implementation for this class.
 *     Name the new class MyCharacter.
 *
 * Created by Luiz Arantes Sa on 9/6/14.
 */
public class Exercise_24 {


    public static void main(String[] args) {
        MyCharacter ch = new MyCharacter('L');
        System.out.println("ch = " + ch.getChar());
        System.out.println("Is a letter: " + ch.isLetter());
        System.out.println("Is a digit: " + ch.isDigit());
        System.out.println("L == L ?" + ch.equals(new MyCharacter('L')));
    }
}
