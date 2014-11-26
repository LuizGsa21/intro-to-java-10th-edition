package Chapter_13;

import java.util.ArrayList;

/**
 * Chapter 13 Exercise 2:
 *
 *   (Shuffle ArrayList) Write the following method that shuffles an ArrayList of numbers:
 *
 * Created by Luiz Arantes Sa on 9/10/14.
 */
public class Exercise_02 {

    public static void main(String[] args) {

        ArrayList<Number> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) list.add(i);

        System.out.println(list);
        System.out.println("Shuffling list...");
        shuffle(list);
        System.out.println(list);
    }

    public static void shuffle(ArrayList<Number> list) {

        // simple solution
        //Collections.shuffle(list);

        // manual shuffle
        for (int i = 0; i < list.size(); i++) {
            int randomIndex = (int) (Math.random() * list.size());
            Number temp = list.get(randomIndex);
            list.set(randomIndex, list.get(i));
            list.set(i, temp);
        }

    }
}
