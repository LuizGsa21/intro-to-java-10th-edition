package Chapter_06;

/**
 * Chapter 6 Exercise 38:
 *
 *
 *      (Generate random characters)
 *      Use the methods in RandomCharacter in Listing 6.10 to print 100
 *      uppercase letters and then 100 single digits, printing ten per line.
 *
 * Created by Luiz Arantes Sa on 8/26/14.
 */
public class Exercise_38 {

    public static void main(String[] args) {

        for (int i = 1; i <= 100; i++) {

            System.out.print(RandomCharacter.getRandomUpperCaseLetter() + " ");
            if (i % 10 == 0) System.out.println("");
        }

        for (int i = 1; i <= 100; i++) {

            System.out.print(RandomCharacter.getRandomDigitCharacter() + " ");
            if (i % 10 == 0) System.out.println("");
        }

    }

}
