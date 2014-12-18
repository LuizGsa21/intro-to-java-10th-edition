package Chapter_19;

import java.util.ArrayList;

/**
 *  (Shuffle ArrayList)
 *  Write the following method that shuffles an ArrayList:
 *
 *  public static <E> void shuffle(ArrayList<E> list)
 *
 * Created by Luiz Arantes Sa on 12/17/14.
 */
public class Exercise_08 {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list);
        shuffle(list);
        System.out.println(list);

    }

    public static <E> void shuffle(ArrayList<E> list) {

        for (int i = 0; i < list.size(); i++) {
            int random = (int) (Math.random() * list.size());
            E tmp = list.get(random);
            list.set(random, list.get(i));
            list.set(i, tmp);
        }
    }
}
