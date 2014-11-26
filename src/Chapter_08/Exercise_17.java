package Chapter_08;

import java.util.Scanner;

/**
 * Chapter 8 Exercise 17:
 *
 *      (Financial tsunami)
 *      Banks lend money to each other. In tough economic times, if a bank goes
 *      bankrupt, it may not be able to pay back the loan. A banks total assets
 *      are its current balance plus its loans to other banks.
 *      The diagram in Figure 8.8 shows five banks. The banks; current balances
 *      are 25, 125, 175, 75, and 181 million dollars, respectively.
 *      The directed edge from node 1 to node 2 indicates that
 *      bank 1 lends 40 million dollars to bank 2.
 *
 *      If a banks total assets are under a certain limit, the bank is unsafe.
 *      The money it borrowed cannot be returned to the lender, and the lender
 *      cannot count the loan in its total assets. Consequently, the lender may
 *      also be unsafe, if its total assets are under the limit. Write a program
 *      to find all the unsafe banks. Your program reads the input as follows. It
 *      first reads two integers n and limit, where n indicates the number of banks
 *      and limit is the minimum total assets for keeping a bank safe. It then reads
 *      n lines that describe the information for n banks with IDs from 0 to n-1.
 *      The first number in the line is the banks balance, the second number indicates
 *      the number of banks that borrowed money from the bank, and the rest are pairs of
 *      two numbers. Each pair describes a borrower. The first number in the pair is the
 *      borrowers ID and the second is the amount borrowed.
 *       For example, the input for the five banks in Figure 8.8 is as follows (note that the limit is 201):
 *
 *      5 - number of banks
 *      201 - minimum asset limit
 *
 *      Bank#0 Balance:  25  NumOfBanksLoaned: 2 BankID: 1 Amount: 100.5 BankID: 4 Amount:  320.5
 *
 *      Bank#1 Balance: 125  NumOfBanksLoaned: 2 BankID: 2 Amount:  40   BankID: 3 Amount:   85
 *
 *      Bank#2 Balance: 175  NumOfBanksLoaned: 2 BankID: 0 Amount: 125   BankID: 3 Amount:   75
 *
 *      Bank#3 Balance:  75  NumOfBanksLoaned: 1 BankID: 0 Amount: 125
 *
 *      Bank#4 Balance: 181  NumOfBanksLoaned: 1 BankID: 2 Amount: 125
 *
 *      The total assets of bank 3 are (75 + 125), which is under 201, so bank 3 is unsafe.
 *      After bank 3 becomes unsafe, the total assets of bank 1 fall below (125 + 40).
 *      Thus, bank 1 is also unsafe. The output of the program should be
 *
 *      Unsafe banks are 3 1
 *
 *      (Hint: Use a two-dimensional array borrowers to represent loans.
 *      borrowers[i][j] indicates the loan that bank i loans to bank j.
 *      Once bank j becomes unsafe, borrowers[i][j] should be set to 0.)
 *
 * Created by Luiz Arantes Sa on 8/30/14.
 */
public class Exercise_17 {

    static final int ID = 0;
    static final int LOAN = 1;
    static double[][][] mBanks;
    public static void main(String[] args) {



        Scanner input = new Scanner(System.in);
        // First ask for number of banks and minimum limit
        System.out.print("Enter the number of banks: ");
        int n = input.nextInt(); // n = number of banks
        System.out.print("Enter minimum limit: ");
        int limit = input.nextInt(); // limit is the minimum total assets for keeping a bank safe

        mBanks = new double[n][][];

        System.out.println("Example:");
        System.out.printf("%-5s%-5s%-5s%-5s%-5s%-5s%-5s\n",
                "bank # |", "balance |", "Loaned# |", "Bank ID |", "Amounts |", "Bank ID |", "Amounts |");
        System.out.printf("%-7d|%8.2f|%8d|", 1, 200.0, 2);
        System.out.printf("%8.0f|%8.2f|", 2.0, 73.0);
        System.out.printf("%8.0f|%8.2f|\n\n", 1.0, 130.0);

        for (int i = 0; i < mBanks.length; i++) {
            System.out.print("Enter bank #"+i+" > ");
            double balance = input.nextDouble();
            int numBanks = input.nextInt();
            mBanks[i] = new double[++numBanks][2];
            mBanks[i][0][0] = balance; // banks balance

            for (int bank = 1; bank < mBanks[i].length; bank++) {
                mBanks[i][bank][ID] = input.nextDouble();
                mBanks[i][bank][LOAN] = input.nextDouble();
            }

        }
        System.out.println("");
        displayMatrix(mBanks);
        boolean[] unsafeIndex = scanBanks(mBanks, limit);

        for (int i = 0; i < unsafeIndex.length; i++) {
            System.out.println("Bank# " + i + " unsafe: " +unsafeIndex[i] );
        }

    }

    public static boolean[] scanBanks(double[][][] m, int limit) {

        boolean[] indexUnsafeBanks = new boolean[m.length];
        double total;
        boolean isSafe = false;
        // keep looping until indexUnsafe isn't modified
        // throw an entire iteration
        while (!isSafe) {
            isSafe = true; // gets set false if indexUnsafeBanks is changed
            for (int banks = 0; banks < m.length; banks++) {
                total = m[banks][0][0];
                for (int LoanedBanks = 1; LoanedBanks < m[banks].length; LoanedBanks++) {
                    int index = (int)m[banks][LoanedBanks][ID];
                    if (!indexUnsafeBanks[index])
                        total += m[banks][LoanedBanks][LOAN];
                }
                // Update indexUnsafeBanks if bank is under limit
                // and indexUnsafeBanks has not yet marked current bank unsafe
                if (total < limit && !indexUnsafeBanks[banks]) {
                    indexUnsafeBanks[banks] = true;
                    isSafe = false;
                }
            }
        }
        return indexUnsafeBanks;
    }


    public static void displayMatrix(double[][][] m) {

        System.out.printf("%-5s%-5s%-5s%-5s%-5s%-5s%-5s\n",
                "bank # |", "balance |", "Loaned# |", "Bank ID |", "Amounts |", "Bank ID |", "Amounts |");
        for (int banks = 0; banks < m.length; banks++) {
            System.out.printf("%-7d|%8.2f|%8d|", banks, m[banks][0][0], m[banks].length -1);

            for (int LoanedBanks = 1; LoanedBanks < m[banks].length; LoanedBanks++) {
                System.out.printf("%8.0f|%8.2f|", m[banks][LoanedBanks][ID], m[banks][LoanedBanks][LOAN]);
            }
            System.out.println("");
        }
    }


}

// Debug:
//        double[][][] debug = new double[][][] {
//           {{25, 0}, {1, 100.5}, {4, 320.5}},
//           {{125, 0},  {2, 40}, {3, 85}},
//           {{175, 0}, {0, 125}, {3, 75}},
//           {{75, 0},  {0, 125}},
//           {{181, 0}, {2, 125}}
//        };















