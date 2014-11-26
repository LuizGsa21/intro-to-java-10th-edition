package Chapter_12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Chapter 12 Exercise 31:
 *
 *      (Baby name popularity ranking)
 *      The popularity ranking of baby names from years 2001 to 2010 is downloaded
 *      from www.ssa.gov/oact/babynames and stored in files named babynameranking2001.txt,
 *      babynameranking2002.txt, . . . , babynameranking2010.txt. Each file contains one thousand
 *      lines. Each line contains a ranking, a boy’s name, number for the boy’s name, a girl’s name,
 *      and number for the girl’s name. For example, the first two lines in the file
 *      babynameranking2010.txt are as follows:
 *
 *      So, the boy’s name Jacob and girl’s name Isabella are ranked #1 and the boy’s name
 *      Ethan and girl’s name Sophia are ranked #2. 21,875 boys are named Jacob and 22,731
 *      girls are named Isabella. Write a program that prompts the user to enter the year, gender,
 *      and followed by a name, and displays the ranking of the name for the year.
 *
 * Created by Luiz Arantes Sa on 9/9/14.
 */
public class Exercise_31 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter year: ");
        String year = input.next();

        System.out.print("Enter gender: ");
        String gender = input.next();

        System.out.print("Enter name: ");
        String name = input.next();
        input.close();

        File file = new File("babynamesranking" + year + ".txt");
        if (!file.exists()) {
            System.out.println("No record for " + year);
            System.exit(1);
        }

        int rank = 0;
        try {
            Scanner read = new Scanner(file);
            while (read.hasNext()) {

                String s = read.nextLine();
                String[] temp = s.split(" ");

                if (gender.equalsIgnoreCase("M") && temp[1].contains(name))
                    rank = new Integer(temp[0]);
                else if (temp[3].contains(name))
                    rank = new Integer(temp[0]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (rank == 0) {
            System.out.println("The name "+name+" is not ranked in year " + year);
        } else {

            System.out.println(name+" is ranked #"+rank+" in year "+ year);
        }


    }
}