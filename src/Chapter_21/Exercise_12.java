package Chapter_21;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 *(Name for both genders)
 * Write a program that prompts the user to enter one of the filenames described
 * in Programming Exercise 12.31 and displays the names that are used for both
 * genders in the file. Use sets to store names and find com- mon names in two sets.
 * Created by Luiz Arantes Sa on 1/30/15.
 */
public class Exercise_12 {

    public static void main(String[] args) throws FileNotFoundException {

        System.out.print("Choose an year to see its baby name rankings (2001-2010): ");
        Scanner in = new Scanner(System.in);
        String path = "/Users/Kernel/GitHub/intro-to-java-10th-edition/src/text-files/babynamesranking" + in.nextInt() + ".txt";
        in.close();


        in = new Scanner(new File(path));

        HashSet<String> boyNames = new HashSet<>();
        HashSet<String> girlNames = new HashSet<>();

        while (in.hasNext()) {
            in.nextInt(); // rank (trash)
            boyNames.add(in.next()); // boy name
            in.nextInt(); // popularity (trash)
            girlNames.add(in.next()); // girl name
            in.nextInt(); // popularity (trash)
        }

        boyNames.retainAll(girlNames);
        System.out.println(boyNames.size() + " names used for both genders.");
        System.out.print("They are ");
        Iterator iterator = boyNames.iterator();
        int count = 1;
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + ", ");
            if (count % 10 == 0)
                System.out.println();
            count++;
        }
    }

}
