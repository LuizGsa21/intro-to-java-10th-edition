package Chapter_21;

import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * (Count the occurrences of numbers entered)
 * Write a program that reads an unspecified number of integers and finds
 * the one that has the most occurrences. The input ends when the input
 * is 0. For example, if you entered 2 3 40 3 5 4 –3 3 3 2 0, the number 3
 * occurred most often. If not one but several numbers have the most occurrences,
 * all of them should be reported. For example, since 9 and 3 appear twice in the
 * list 9 30 3 9 3 2 4, both occurrences should be reported.
 *
 * Created by Luiz Arantes Sa on 1/27/15.
 */
public class Exercise_06 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter random integers.\nEnter 0 when finished: ");

        HashMap<Integer, Integer> occurrences = new HashMap<>();
        int number;
        while ((number = scanner.nextInt()) != 0) {
            if (!occurrences.containsKey(number))
                occurrences.put(number, 1);
            else
                occurrences.put(number, occurrences.get(number) + 1);
        }

        int max = Collections.max(occurrences.values());
        HashMap<Integer, Integer> highestOccurrences = new HashMap<>();
        occurrences.forEach((key, value) -> {
            if (value >= max)
                highestOccurrences.put(key, value);
        });

        System.out.println("Numbers with the max occurrences: ");
        highestOccurrences.forEach((key, value) ->
                System.out.println(key + " occurred " + value + " times"));
    }


}
