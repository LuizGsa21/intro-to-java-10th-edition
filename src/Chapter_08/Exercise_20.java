package Chapter_08;

import java.util.Scanner;

/**
 * Chapter 8 Exercise 20:
 *
 *      (Game: connect four) Connect four is a two-player board game
 *      in which the players alternately drop colored disks into a seven-column,
 *      six-row vertically suspended grid, as shown below.
 *      The objective of the game is to connect four same-colored disks in a row,
 *      a column, or a diagonal before your opponent can do likewise. The program
 *      prompts two players to drop a red or yellow disk alternately. In the preceding
 *      figure, the red disk is shown in a dark color and the yellow in a light color.
 *      Whenever a disk is dropped, the program re-displays the board on the console
 *      and determines the status of the game (win, draw, or continue).
 *
 * Created by Luiz Arantes Sa on 8/31/14.
 */
public class Exercise_20 {

    static boolean isPlayer1Turn = true;
    static boolean hasWon = false;

    public static void main(String[] args) {

        String[][] m = createGrid(6,7);
        Scanner input = new Scanner(System.in);
        int column;


        while (!hasWon) {

            String diskColor = (isPlayer1Turn) ? "red" : "yellow";

            displayMatrix(m);
            boolean isFirstInput = true;
            do {
                if (!isFirstInput) {
                    System.out.println("COLUMN IS FULL. Try again...");
                }
                System.out.print("Drop a " + diskColor + " at column (0–6): ");
                column = input.nextInt();
                isFirstInput = false;
            } while (!dropDisk(m, column));

            if (isConsecutiveFour(m)) {
                displayMatrix(m);
                System.out.print("The "+diskColor+" player won! Do you want to play again? (y/n)");
                char s = input.next().charAt(0);
                if (s == 'y' || s == 'Y') {
                    m = createGrid(6, 7);
                    isPlayer1Turn = false;
                } else {
                    System.exit(0);
                }
            }

            isPlayer1Turn = !isPlayer1Turn;
        }

    }

    public static void displayMatrix(String[][] m) {

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j]);
            }
            System.out.println("");
        }

    }

    public static String[][] createGrid(int row, int column) {

        String[][] m = new String[row][column];
        for (int i = 0; i < m.length; i++) {

            for (int j = 0; j < m[i].length; j++) {
                if (j == 0)
                    m[i][j] = "| |";
                else
                    m[i][j] = " |";

            }
        }
        return m;
    }

    public static boolean isConsecutiveFour(String[][] m) {

        String s = (isPlayer1Turn) ? "R" : "Y";

        int occurrence = 0;
        // (m[0].length - 3) --> reason: only checking occurrences of 4
        for (int j = 0; j < m[0].length - 3; j++) {
            int y = m.length - 1; // row always starts on last row
            int x = j;
            while (x < m[0].length && y >= 0) {

                 if (m[y][x].contains(s)) {              // | | | | | |R|R|
                     occurrence++;                       // | | | | |R|R|R|
                    if (occurrence == 4) return true;    // | | | |R|R|R|R|
                } else {                                 // | | |R|R|R|R| |
                     occurrence = 0;                     // | |R|R|R|R| | |
                }                                        // |R|R|R|R| | | |
                x++;
                y--;
            }
        }

        // (m.length - 2) --> reason: only checking occurrences of 4
        // and last row has already been checked
        for (int i = m.length - 2; i > 2; i--) {
            int x = 0; // column always starts on the left side
            int y = i;
            occurrence = 0;
            while (x < m[0].length && y >= 0) {           // | | | |R|R| | |
                                                          // | | |R|R| | | |
                                                          // | |R|R| | | | |
                if (m[y][x].contains(s)) {                // |R|R| | | | | |
                    occurrence++;                         // |R| | | | | | |
                    if (occurrence == 4) return true;     // | | | | | | | |
                } else {
                    occurrence = 0;
                }

                x++;
                y--;
            }
        }

        // j >= 3 --> reason: only checking occurrences of 4
        for (int j = m[0].length - 1; j >= 3; j--) {
            int y = m.length -1; // row always starts on last row
            int x = j;
            occurrence = 0;

            while (x >= 0 && y >= 0) {
                                                            // |L|L| | | | | |
                if (m[y][x].contains(s)) {                  // |L|L|L| | | | |
                    occurrence++;                           // |L|L|L|L| | | |
                    if (occurrence == 4) return true;       // | |L|L|L|L| | |
                } else {                                    // | | |L|L|L|L| |
                    occurrence = 0;                         // | | | |L|L|L|L|
                }
                x--;
                y--;
            }

        }

        // i > 2 --> reason: only checking occurrences of 4
        for (int i = m.length - 2; i > 2; i--) {
            int x = m[0].length - 1;
            int y = i;
            occurrence = 0;
            while (x >= 0 && y >= 0) {                       // | | |L|L| | | |
                                                             // | | | |L|L| | |
                if (m[y][x].contains(s)) {                   // | | | | |L|L| |
                    occurrence++;                            // | | | | | |L|L|
                    if (occurrence == 4) return true;        // | | | | | | |L|
                } else {                                     // | | | | | | | |
                    occurrence = 0;
                }
                x--;
                y--;
            }

        }

        return false;
    }

    public static boolean dropDisk(String[][] m, int column) {

        // figure out which disk to drop
        String s;
        if (isPlayer1Turn) {
            s = (column > 0) ?  "R|" : "|R|";
        } else {
            s = (column > 0) ? "Y|" : "|Y|";
        }
        boolean didRowUpdate = false;
        int row = 0;

        // check if there is a disk in column
        // if there is get the proper row index
        for (int i = 0; i < m.length; i++) {

            if (isClear(m[i][column])) {
                didRowUpdate = true;
                row = i;
            }
        }

        if (!didRowUpdate) return false;

        m[row][column] = s;

        return true;
    }

    public static boolean isClear(String s) {

        return s.contains("| |") || s.contains(" |");
    }


}
