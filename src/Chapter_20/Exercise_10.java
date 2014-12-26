package Chapter_20;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * (Perform set operations on priority queues)
 * Create two priority queues,
 * {"George", "Jim", "John", "Blake", "Kevin", "Michael"}
 * {"George", "Katie", "Kevin", "Michelle", "Ryan"},
 * and find their union, difference, and intersection.
 * Created by Luiz Arantes Sa on 12/25/14.
 */
public class Exercise_10 {

    public static void main(String[] args) {

        PriorityQueue<String> pq1 = new PriorityQueue<>(Arrays.asList("George", "Jim", "John", "Blake", "Kevin", "Michael"));
        PriorityQueue<String> pq2 = new PriorityQueue<>(Arrays.asList("George", "Katie", "Kevin", "Michelle", "Ryan"));

        PriorityQueue<String> union = new PriorityQueue<>(pq1);
        PriorityQueue<String> tmp = new PriorityQueue<>(pq2);

        String s;
        while ((s = tmp.poll()) != null) {
            if (!union.contains(s)) {
                union.add(s);
            }
        }
        System.out.println("Union set: " + union);

        PriorityQueue<String> difference = new PriorityQueue<>(pq1);
        difference.removeAll(pq2);
        System.out.println("Difference: " + difference);

        PriorityQueue<String> intersection = new PriorityQueue<>(pq1);
        intersection.retainAll(pq2);
        System.out.println("Difference: " + intersection);

    }

}
