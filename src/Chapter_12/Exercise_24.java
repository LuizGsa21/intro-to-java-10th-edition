package Chapter_12;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Chapter 12 Exercise 24:
 *
 *  (Create large dataset)
 *  Create a data file with 1,000 lines. Each line in the file consists of a
 *  faculty member’s first name, last name, rank, and salary. The faculty member’s
 *  first name and last name for the ith line are FirstNamei and LastNamei. The rank
 *  is randomly generated as assistant, associate, and full. The salary is randomly
 *  generated as a number with two digits after the decimal point. The salary for an
 *  assistant professor should be in the range from 50,000 to 80,000, for associate professor
 *  from 60,000 to 110,000, and for full professor from 75,000 to 130,000. Save the file in Salary.txt.
 *  Here are some sample data:
 *
 *      FirstName1 LastName1 assistant 60055.95
 *      FirstName2 LastName2 associate 81112.45
 *      FirstName1000 LastName1000 full 92255.21
 *
 * Created by Luiz Arantes Sa on 9/9/14.
 */
public class Exercise_24 {

    static final String[] ranks = {"assistant", "associate", "full"};

    public static void main(String[] args) throws Exception {

// VERSION 1:
//        ArrayList<String> members = new ArrayList<>();
//        String lineSeparator = System.getProperty("line.separator");
//
//        for (int i = 1; i <= 1000; i++) {
//            members.add(createString(i) + lineSeparator);
//        }
//
//        writeToFile(members);

// VERSION 2:
        try (PrintWriter out = new PrintWriter("Salary.txt")) {
            for (int i = 1; i <= 1000; i++) {
                String rank = getRandomRank();
                String salary = String.format("%.2f", getRandomSalaryByRank(rank));

                out.print("FirstName" + i + " LastName" + i + " ");
                out.print(" " + rank + " " + salary);
                if (i != 1000) {
                    out.println();
                }

            }
        }

       System.out.println("File saved...");

    }

    private static void writeToFile(ArrayList<String> members) {

        try (PrintWriter out = new PrintWriter("Salary.txt")) {

            for (String member : members) {
                out.write(member);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();;
        }
    }

    private static String createString(int i) {

        String rank = getRandomRank();
        double salary = getRandomSalaryByRank(rank);

        return "FirstName" + i + " LastName" + i + " " + rank + " " + String.format("%.2f", salary);
    }

    private static String getRandomRank() {
        return ranks[(int)(Math.random() * ranks.length)];
    }

    private static double getRandomSalaryByRank(String rank) {

        int max = 0;
        int min = 0;
        switch (rank) {
            case "assistant":
                min = 50000;
                max = 80000;
                break;
            case "associate":
                min = 60000;
                max = 110000;
                break;
            case "full":
                min = 75000;
                max = 130000;
                break;
        }
        return getRandomSalary(min, max + 1); //
    }

    /** returns a random double from min to max - 1 **/
    private static double getRandomSalary(int min, int max) {
        int range = max - min;

        return Math.random() * range + min;
    }
}
