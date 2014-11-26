package Chapter_06;

/**
 * Chapter 6 Exercise 12:
 *
 *      (Display characters)
 *
 * Created by Luiz Arantes Sa on 8/25/14.
 */
public class Exercise_12 {


    public static void main(String[] args) {

        printChars('1', 'Z', 10);

    }


    /**
     * This method prints the characters between ch1 and ch2 with the specified numbers per line.
     * @param ch1 beginning index
     * @param ch2 end index
     * @param numberPerLine chars to display per line
     */
    public static void printChars(char ch1, char ch2, int numberPerLine) {


        for (int count = 1; ch1 <= ch2; count++, ch1++) {

            System.out.print(ch1 + " ");
            if (count % numberPerLine == 0) System.out.println("");

        }

    }
}
