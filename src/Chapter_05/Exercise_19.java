package Chapter_05;

/**
 * Chapter 5 Exercise 19:
 *
 *      (Display numbers in a pyramid pattern)
 *
 * Created by Luiz Arantes Sa on 8/24/14.
 */
public class Exercise_19 {

    public static void main(String[] strings) {

        String string = " ";

        int number = 0;
        for (int row = 0; row <= 7; row++)
        {
            // prints beginning blank strings
            for (int column = 1; column <= 7 - row; column++)
            {
                System.out.printf("%4s", string);
            }

            // first half of row
            for (int column = 0; column <= row; column++)
            {
                number = (int) Math.pow(2, column);

                System.out.printf("%4d", number);
            }

            // second half of row
            for (int column = row - 1; column >= 0; column--)
            {
                number = (int) Math.pow(2, column);

                System.out.printf("%4d", number);
            }
            // new line
            System.out.println();
        }

    }
}
