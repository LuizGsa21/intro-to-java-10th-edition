package Chapter_20;

import ToolKit.StopWatch;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * (Use iterators on linked lists)
 * Write a test program that stores 5 million integers in a linked
 * list and test the time to traverse the list using an iterator vs.
 * using the get(index) method.
 *
 * Created by Luiz Arantes Sa on 12/19/14.
 */
public class Exercise_06 {

    public static void main(String[] args) {

        StopWatch stopWatch = new StopWatch();

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 5000000; i++) {
            list.add(i);
        }
        Iterator<Integer> iterator = list.iterator();
        System.out.println("Start iterator");
        stopWatch.start();
        while (iterator.hasNext()) {
            iterator.next();
        }
        stopWatch.stop();
        System.out.println("End iterator");
        System.out.println("total time: " + stopWatch.getElapsedTime());

        stopWatch.reset();
        System.out.println("Start .get()");
        stopWatch.start();
        for (int i = 0; i < 5000000; i++) {
            list.get(i);
        }
        stopWatch.stop();
        System.out.println("End .get");
        System.out.println("total time: " + stopWatch.getElapsedTime());

        stopWatch.reset();
    }
}
