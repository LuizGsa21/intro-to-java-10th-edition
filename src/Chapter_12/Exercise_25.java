package Chapter_12;

import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Chapter 12 Exercise 25:
 *
 *      (Process large dataset)
 *      A university posts its employees’ salaries at
 *      http:// cs.armstrong.edu/liang/data/Salary.txt.
 *      Each line in the file consists of a faculty member’s first name, last name,
 *      rank, and salary (see Programming Exercise 12.24). Write a program to display
 *      the total salary for assistant professors, associate professors, full professors,
 *      and all faculty, respectively, and display the average salary for assistant professors,
 *      associate professors, full professors, and all faculty, respectively.
 *
 * Created by Luiz Arantes Sa on 9/9/14.
 */
public class Exercise_25 {

    private static final int ASSI = 0; // ASSISTANT
    private static final int ASSO = 1; // ASSOCIATE
    private static final int FULL = 2;

    public static void main(String[] args) throws Exception {

        ArrayList<ArrayList<Double>> allRanks = new ArrayList<>(3);
        allRanks.add(ASSI, new ArrayList<>());
        allRanks.add(ASSO, new ArrayList<>());
        allRanks.add(FULL, new ArrayList<>());

        URL url = new URL("http://cs.armstrong.edu/liang/data/Salary.txt");
        Scanner input = new Scanner(url.openStream());


        while (input.hasNext()) {
            String firstName = input.next();
            String lastName = input.next();
            String rank = input.next();
            if (rank.contains("assistant")) {
                allRanks.get(ASSI).add(input.nextDouble());
            } else if (rank.contains("associate")) {
                allRanks.get(ASSO).add(input.nextDouble());
            } else {
                allRanks.get(FULL).add(input.nextDouble());
            }
        }

        long assiTotal = (long)getTotal(allRanks.get(ASSI).toArray());
        long assoTotal = (long)getTotal(allRanks.get(ASSO).toArray());
        long fullTotal = (long)getTotal(allRanks.get(FULL).toArray());
        long total = assiTotal + assoTotal + fullTotal;
        System.out.println("Assistant total = " + assiTotal);
        System.out.println("Associate total = " + assoTotal);
        System.out.println("Full total = " + fullTotal);
        System.out.println("All Total = " + total);
        System.out.printf("Assistant average = %.2f \n", getAverage(assiTotal, allRanks.get(ASSI).size()));
        System.out.printf("Associate average = %.2f \n", getAverage(assoTotal, allRanks.get(ASSO).size()));
        System.out.printf("Full average = %.2f \n", getAverage(fullTotal, allRanks.get(FULL).size()));
        System.out.printf("All average = %.2f \n", getAverage(total, getInternalSize(allRanks)));



    }

    private static double getTotal(Object[] objects) {
        double total = 0;
        for (Object o : objects) {
            total += (double)o;
        }
        return total;
    }

    private static int getInternalSize(ArrayList<ArrayList<Double>> lists) {

        int size = 0;
        for (ArrayList<Double> list : lists) {
            size += list.size();
        }

        return size;
    }

    private static double getAverage(long total, int size) {

        return (double)total / size;
    }
}
