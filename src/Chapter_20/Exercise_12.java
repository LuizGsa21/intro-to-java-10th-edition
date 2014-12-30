package Chapter_20;

import java.util.PriorityQueue;

/**
 * (Clone PriorityQueue)
 * Define MyPriorityQueue class that extends PriorityQueue to implement the
 * Cloneable interface and implement the clone() method to clone a priority queue.
 *
 * Created by Luiz Arantes Sa on 12/30/14.
 */
public class Exercise_12 {

    public static void main(String[] args) {

        MyPriorityQueue<String> queue = new MyPriorityQueue<>();
        queue.offer("1");
        queue.offer("2");
        queue.offer("3");

        MyPriorityQueue<String> queue1 = null;
        try {
            queue1 = (MyPriorityQueue<String>)(queue.clone());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.print(queue1);
    }

    static class MyPriorityQueue<E> extends PriorityQueue<E> implements Cloneable {

        @Override
        public Object clone() throws CloneNotSupportedException {

            MyPriorityQueue<E> clone = new MyPriorityQueue<>();

            this.forEach(clone::offer);

            return clone;
        }

    }
}
