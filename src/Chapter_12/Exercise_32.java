package Chapter_12;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Chapter 12 Exercise 32:
 *
 *      (Ranking summary)
 *      Write a program that uses the files described in Programming
 *      Exercise 12.31 and displays a ranking summary table for the
 *      first five girl’s and boy’s names.
 *
 *
 * Created by Luiz Arantes Sa on 9/9/14.
 */
public class Exercise_32 {

    public static void main(String[] args) throws Exception {

        System.out.printf("%-10s ", "year");
        for (int i = 0; i < 2; i++)
            for (int j = 1; j <= 5; j++)
                System.out.printf("%-10s ", "Rank "+j);

        for (int year = 2010; year >= 2001; year--) {
            System.out.printf("\n%-10s ", year);

            File file = new File("babynamesranking" + year + ".txt");
            String[] boys = new String[5];

            Scanner input = new Scanner(file);
            for (int i = 0; i < 5 && input.hasNext(); i++) {

                String s = input.nextLine();

                String[] buffer = s.split("[0-9, ]");
                buffer = removeEmptyStrings(buffer);
                boys[i] = buffer[0];

                System.out.printf("%-10s ", buffer[i]);
            }

            for (String boy : boys) {
                System.out.printf("%-10s ", boy);
            }
        }
    }

    private static String[] removeEmptyStrings(String[] strings) {

        ArrayList<String> temp = new ArrayList<>();
        for (String s : strings) {
            s = s.trim();
            if (s.length() > 1) {

                temp.add(s);
            }
        }
        return temp.toArray(new String[temp.size()]);
    }

}
