package Chapter_12;

import ToolKit.Kit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Chapter 12 Exercise 15:
 *
 *  (Write/read data) Write a program to create a file named Exercise12_15.txt
 *  if it does not exist. Write 100 integers created randomly into the file using text I/O.
 *  Integers are separated by spaces in the file. Read the data back from the file and
 *  display the data in increasing order.
 *
 * Created by Luiz Arantes Sa on 9/9/14.
 */
public class Exercise_15 {

    public static void main(String[] args) {

        File filename = new File("Exercise12_15.txt");
        if (!filename.exists()) {
            System.out.println(filename + " already exists...");
            //System.exit(1); // this is commented out so file can still be read
        }

        // writing 100 integers to into the file
        try {
            PrintWriter out = new PrintWriter(filename);
            out.print(Kit.randomNumbers(100));
            out.close();
            System.out.println("Wrote to file...");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        System.out.println("Reading from file...");
        ArrayList<Integer> list = new ArrayList<>();
        try {
            Scanner input = new Scanner(filename);
            while (input.hasNextInt()) {
                list.add(input.nextInt());
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        // simple solution to sort
        //Collections.sort(list);

        // Manual solution
        sort(list);
        System.out.println(list);
    }

    public static void sort(ArrayList<Integer> list) {

        for (int i = 0; i < list.size(); i++) {
            int currentMin = list.get(i);
            int currentIndex = i;
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j) < currentMin) {
                    currentIndex = j;
                    currentMin = list.get(j);
                }
            }

            if (currentIndex != i) {
                list.set(currentIndex, list.get(i));
                list.set(i, currentMin);
            }
        }

    }


}
