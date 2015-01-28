package Chapter_21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * (Revise Listing 21.9, CountOccurrenceOfWords.java)
 * Rewrite Listing 21.9 to display the words in ascending order
 * of occurrence counts. (Hint: Create a class named WordOccurrence
 * that implements the Comparable interface. The class contains two fields,
 * word and count. The compareTo method compares the counts. For each pair
 * in the hash set in Listing 21.9, create an instance of WordOccurrence and
 * store it in an array list. Sort the array list using the Collections.sort method.
 * What would be wrong if you stored the instances of WordOccurrence in a tree set?)
 *
 * Created by Luiz Arantes Sa on 1/27/15.
 */
public class Exercise_07 {

    public static void main(String[] args) {
        // Set text in a string
        String text = "z Good morning. Have a good class. " +
                "Have a good visit. Have fun!";

        // Create a TreeMap to hold words as key and count as value
        Map<String, Integer> map = new TreeMap<>();

        String[] words = text.split("[\\s+]");
        for (String word1 : words) {
            String key = word1.toLowerCase();

            if (key.length() > 0) {
                if (!map.containsKey(key)) {
                    map.put(key, 1);
                } else {
                    int value = map.get(key);
                    value++;
                    map.put(key, value);
                }
            }
        }

        ArrayList<WordOccurrence> list = new ArrayList<>();
        // Display key and value for each entry
        map.forEach((k, v) -> list.add(new WordOccurrence(k, v)));
        Collections.sort(list);
        list.forEach((word) -> System.out.println(word.word + "\t" + word.count));


    }

    private static class WordOccurrence implements Comparable<WordOccurrence> {

        int count;
        String word;

        public WordOccurrence(String word, int count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public int compareTo(WordOccurrence o) {
            if (o.count > count)
                return -1;
            else if (o.count < count)
                return 1;
            else
                return 0;
        }
    }
}
