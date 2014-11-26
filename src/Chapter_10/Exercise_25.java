package Chapter_10;

import ToolKit.MyString1;

/**
 * Chapter 10 Exercise 25:
 *
 *      (New string split method) The split method in the String class returns an array of strings consisting of the substrings split by the delimiters. However, the delimiters are not returned. Implement the following new method that returns an array of strings consisting of the substrings split by the matching delimiters, including the matching delimiters."
 *      "public static String[] split(String s, String regex)"
 *      "For example, split(""ab#12#453"",  ""#"") returns ab, #, 12, #, 453 in an"
 *      "array of String, and split(""a?b?gf#e"", ""[?#]"") returns a, b, ?, b, gf,"
 *      "#, and e in an array of String."
 *
 * Created by Luiz Arantes Sa on 9/6/14.
 */
public class Exercise_25 {


    public static void main(String[] args) {

        String[] temp1 = MyString1.split("WordAttachedlolol", "Attached");
        for (String s : temp1) {
            System.out.println(s);
        }

        String[] temp2 = MyString1.split("Wor#dAt#tac#he#dl#ol#ol", "#");
        for (String s : temp2) {
            System.out.println(s);
        }

    }
}
