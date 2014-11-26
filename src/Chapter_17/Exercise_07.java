package Chapter_17;

import ToolKit.Loan;

import java.io.*;

/**
 * (Restore objects from a file)
 *      Suppose a file named Exercise17_07.dat has been created using
 *      the ObjectOutputStream. The file contains Loan objects. The Loan
 *      class in Listing 10.2 does not implement Serializable. Rewrite the
 *      Loan class to implement Serializable. Write a program that reads the
 *      Loan objects from the file and displays the total loan amount. Suppose
 *      you don’t know how many Loan objects are there in the file,
 *      use EOFException to end the loop.
 * Created by luizsa on 10/5/14.
 */
public class Exercise_07 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        File file = new File("src/text files/Exercise17_07.dat");

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {

            double totalAmount = 0;
            try {
                Loan loan;
                while ((loan = (Loan)in.readObject()) != null) {

                totalAmount += loan.getLoanAmount();
                }
            } catch (EOFException ex) {

                System.out.println("Total loan amount = " + totalAmount);
            }
        }
    }
}
