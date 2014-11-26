package Chapter_05;

/**
 * Chapter 5 Exercise 15:
 *
 *      (Display the ASCII character table)
 *      Write a program that prints the characters in the ASCII
 *      character table from ! to ~. Display ten characters per line.
 *      The ASCII table is shown in Appendix B.
 *      Characters are separated by exactly one space.
 *
 * Created by Luiz Arantes Sa on 8/24/14.
 */
public class Exercise_15 {

    public static void main(String[] args) {

        for (int i = '!', count = 1; i <= '~'; i++)
            System.out.print((count++ % 10 != 0) ? (char)i + " " : (char)i + "\n");

    }
}
